/**
 * Project Name:chenxun-framework-start
 * File Name:UserServiceImpl.java
 * Package Name:com.chenxun.framework.service.impl
 * Date:2016年8月31日下午5:36:59
 * Copyright (c) 2016, www midaigroup com Technology Co., Ltd. All Rights Reserved.
 *
*/

package com.chenxun.framework.service.impl;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.chenxun.framework.common.BaseServiceImpl;
import com.chenxun.framework.config.mybatis.MyMapper;
import com.chenxun.framework.entity.User;
import com.chenxun.framework.mapper.UserMapper;
import com.chenxun.framework.service.UserService;

/**
 * ClassName:UserServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月31日 下午5:36:59 <br/>
 * @author   陈勋
 * @version  
 * @since    JDK 1.7
 * @see 	 
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

    public UserServiceImpl(UserMapper mapper) {      
        super(mapper);  
    }

    

   
}

