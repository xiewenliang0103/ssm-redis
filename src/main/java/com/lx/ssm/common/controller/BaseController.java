/*
 * Copyright (C) 2017 ShenZhen LiXiang Software Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳市理想软件有限公司
 */
package com.lx.ssm.common.controller;

import java.beans.PropertyEditorSupport;
import java.util.Date;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import cn.hutool.core.date.DateUtil;

/**
 * 通用的控制器
 * 
 * @version 2018年8月22日下午12:04:58
 * @author zhuwenbin
 */
@ControllerAdvice
public class BaseController {

	/**
	 * 1.在绑定数据之前先将字符串类型数据含有的<、>、=等符号转换为&lt;、&gt;、&eq;防范xss攻击
	 * 2.在绑定数据之前先将字符串类型的日期转换为指定的格式
	 * 3.InitBinder注解的方法在绑定参数之前执行
	 * 
	 * @version 2018年8月22日上午11:32:47
	 * @author zhuwenbin
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 将字符串类型数据含有的<、>、=等符号转换为&lt;、&gt;、&eq;
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				setValue(StringEscapeUtils.escapeHtml4(text));
			}
		});
		// 将字符串类型的日期转换为指定的格式
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				// DateUtil.parse方法自动识别常用时间格式进行转换
				setValue(DateUtil.parse(text));
			}
		});
	}

}
