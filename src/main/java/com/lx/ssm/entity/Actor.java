package com.lx.ssm.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1.@Data等价setter、getter、toString、equal、hashCode等方法
 * 2.@NoArgsConstructor等价无参构造方法
 * 3.@AllArgsConstructor等价有参构造方法
 * 
 * @version 2018年8月27日下午5:11:29
 * @author zhuwenbin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
	
    private Short actorId;

    private String firstName;

    private String lastName;

    private Date lastUpdate;

}