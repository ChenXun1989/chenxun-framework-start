/**
 * Project Name:chenxun-framework-start
 * File Name:ThreadPool.java
 * Package Name:com.chenxun.framework.test
 * Date:2016年9月2日下午1:51:44
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.framework.test;
/**
 * ClassName:ThreadPool <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年9月2日 下午1:51:44 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
public interface ThreadPool<Job extends Runnable> {
    /**
     * 
     * execute:(执行job). <br/>
     * @author 陈勋
     * @param job
     * @since JDK 1.7
     */
    void execute(Job job);
    /**
     * 
     * shutdown:(关闭线程池). <br/>
     *
     * @author 陈勋
     * @since JDK 1.7
     */
    void shutdown();
    /**
     * 
     * addWorkers:(增加工作者线程). <br/>
     * @author 陈勋
     * @param num
     * @since JDK 1.7
     */
    void addWorkers(int num);
    /**
     * 
     * removeWorker:(减少工作者线程). <br/>
     * @author 陈勋
     * @param num
     * @since JDK 1.7
     */
    void removeWorker(int num);
    /**
     * 
     * getJobSize:(获取等待执行的任务数量). <br/>
     *
     * @author 陈勋
     * @return
     * @since JDK 1.7
     */
    int getJobSize();

}

