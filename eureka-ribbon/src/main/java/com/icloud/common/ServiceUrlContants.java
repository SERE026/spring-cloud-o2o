package com.icloud.common;

public class ServiceUrlContants {
	public static final String server_domain = "http:servername.com/";
	
	public static final String token_server_domain = "http:tokenservername.com/";
	
	public static final String userInfo_get = token_server_domain+"Token/userInfo";//获取token地址

	public static final String mct_mp_add = server_domain+"mp/add";//添加公众号地址
	
	public static final String mct_mp_list = server_domain+"mp/list";//获取公众号列表
	
	public static final String mct_mp_update = server_domain+"mp/update";// 
	 
	public static String mct_mp_query = server_domain+"mp/query";//通过ID获取公众号详情接口
	
	public static final String mct_mp_merchants_del = server_domain+"mp_merchants/del";// 

	 
}
