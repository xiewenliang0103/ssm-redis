/*
 * Copyright (C) 2017 ShenZhen LiXiang Software Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳市理想软件有限公司
 */
package com.lx.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lx.ssm.entity.Actor;
import com.lx.ssm.mapper.ActorMapper;

/**
 * 首页流程控制器
 * 
 * @version 2018年8月27日上午11:23:10
 * @author zhuwenbin
 */
@Controller
public class IndexController {

	// 获取日志记录器
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private ActorMapper actorMapper;

	/**
	 * 
	 * 首页
	 * 
	 * @version 2018年8月27日上午11:24:07
	 * @author zhuwenbin
	 * @return
	 */
	@RequestMapping({ "", "/index" })
	public String index() {
		// 查询
		Actor actor = actorMapper.selectByPrimaryKey((short) 1);
		// 记录日志，{}是占位符，后面依次赋值
		log.info("演员信息：{}", actor);

		return "index";
	}
}
