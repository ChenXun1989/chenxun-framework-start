/**
 * Project Name:chenxun-framework-start
 * File Name:DefualtThreadPool.java
 * Package Name:com.chenxun.framework.test
 * Date:2016年9月2日下午1:55:35
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.framework.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ClassName:DefualtThreadPool <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年9月2日 下午1:55:35 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public class DefualtThreadPool<Job extends Runnable> implements ThreadPool<Job > {
    //线程池最大限制数
    private static final int MAX_WORKER_NUMBERS=10;
    //线程池默认数量
    private static final int DEFAULT_WORKER_NUMBERS=5;
    //线程池最小连接数量
    private static final int MIN_WORKER_NUMBERS=1;
    //工作列表
    private final LinkedList<Job> jobs=new LinkedList<Job>();
    //工作者列表
    private final List<Worker> workers=Collections.synchronizedList(new
            ArrayList<Worker>());
    private int workerNum=MIN_WORKER_NUMBERS;
    //线程编号生成
    private AtomicLong threadNum=new AtomicLong();
    
    public DefualtThreadPool(){  
        initializeWorkers(DEFAULT_WORKER_NUMBERS);      
    }
    
    public DefualtThreadPool(int num){
        workerNum= num>MAX_WORKER_NUMBERS&&num<MIN_WORKER_NUMBERS?num:DEFAULT_WORKER_NUMBERS;
        initializeWorkers(num);      
    }
    
    
    
    @Override
    public void execute(Job job) {
       if(job!=null){
           //添加一个工作，然后进行通知
           synchronized (jobs) {
               jobs.addLast(job);
               jobs.notify();
        }
       } 
       
        
    }

    @Override
    public void shutdown() {
        for(Worker worker:workers){
            worker.shutdown();
        }
       
        
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs) {
            if(num+this.workerNum>MAX_WORKER_NUMBERS){
                num=MAX_WORKER_NUMBERS-this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum+=num;
        }
       
        
    }

    @Override
    public void removeWorker(int num) {
       synchronized (jobs) {
           if(num>=this.workerNum){
               throw new IllegalArgumentException("beyond workNum");
           }
           int count=0;
           while(count<num){
               Worker worker=workers.get(count);
               if(workers.remove(worker)){
                   worker.shutdown();
                   count++;
               }
               this.workerNum-=count;
           }
        
    }
        
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }
    
    private void initializeWorkers(int num){
        for(int i=0;i<num;i++){
            Worker worker=new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"ThreadPool-Worker"+threadNum.incrementAndGet());
            thread.start();
            
        }
    }
    
    class Worker implements Runnable{
         private volatile boolean running=true;
        
        @Override
        public void run() {
            while(running){
                Job job=null;
                synchronized (jobs) {
                    while(jobs.isEmpty()){                      
                            try {
                                jobs.wait();
                            } catch (InterruptedException e) {                            
                               Thread.currentThread().interrupt();
                               return;                               
                            }
                        
                    }                  
                    job=jobs.removeFirst();                   
                }
                if(job!=null){
                    try{
                            job.run();
                        }catch (Exception e) {
                       
                    }
                    
                }
            }
            
            
            
        }
        
        public void shutdown(){
            running=false;
        }
        
    }

}

