package com.cock.bos.utils;

import javax.servlet.http.HttpSession;

import com.cock.bos.domain.User;
import org.apache.struts2.ServletActionContext;


/**
 * BOS项目的工具类
 * @author zhaoqx
 *
 */
public class BOSUtils {
	//获取session对象
	public static HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	//获取登录用户对象
	public static User getLoginUser(){
		return (User) getSession().getAttribute("loginUser");
	}
}
