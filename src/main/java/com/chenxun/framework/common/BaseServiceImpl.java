/**
 * Project Name:chenxun-framework-start
 * File Name:BaseServiceImpl.java
 * Package Name:com.chenxun.framework.common
 * Date:2016年9月1日上午10:49:51
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
 */

package com.chenxun.framework.common;

import java.util.List;

import lombok.Data;

import com.chenxun.framework.config.mybatis.MyMapper;

/**
 * ClassName:BaseServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年9月1日 上午10:49:51 <br/>
 * 
 * @author 陈勋
 * @version
 * @param <T>
 * @since JDK 1.7
 * @see
 */
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    
    protected MyMapper<T> mapper;
    
    public BaseServiceImpl(MyMapper<T> mapper){
       this.mapper=mapper;
    }
  

    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

}
