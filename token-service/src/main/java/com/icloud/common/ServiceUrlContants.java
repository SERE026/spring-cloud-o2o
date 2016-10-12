package com.icloud.common;

import com.icloud.ConfigUtil;

/**
 * 服务接口地址
 * @author luoqw
 *2016年9月18日 上午9:46:40
 */
public class ServiceUrlContants { 
	
	public static final String service_domain = ConfigUtil.get("service_domain");  
 
	
	/**公众号请求接口**/
	public static final String mct_mp_add = service_domain+"/mp/add";//添加公众号地址
	
	public static final String mct_mp_list = service_domain+"/mp/list";//获取公众号列表
	
	public static final String mct_mp_list_forMerchant = service_domain+"/mp/list/forMerchant";//根据商户号获取公众号列表
	
	public static final String mct_mp_update = service_domain+"/mp/update";// 更新
	 
	public static final String mct_mp_query = service_domain+"/mp/query";//通过ID获取公众号详情接口
	
	public static final String mct_mp_merchants_del = service_domain+"/mp_merchants/del";// 

	
	/**商户账户请求接口**/
	public static final String mct_account_add = service_domain+"/accout/add"; //添加商户账户
	
	public static final String mct_account_update = service_domain+"/accout/update"; //修改商户账户

	public static final String mct_account_list = service_domain+"/accout/list"; //获取商户账户

	public static final String mct_account_query  = service_domain+"/accout/query"; //获取商户账户
	
	public static final String mct_account_validation  = service_domain+"/accout/validation"; //获取商户账户
	 
	
	/**商户消息请求接口**/
	public static final String mct_message_add = service_domain+"/message/add"; //添加商户消息列表
	
	public static final String mct_message_update = service_domain+"/message/update"; //更新商户消息列表
	
	public static final String mct_message_list = service_domain+"/message/list"; //获取商户消息列表
	
	public static final String mct_message_query = service_domain+"/message/query"; //获取单个商户消息详情
	
	
	
	/**商户门店 请求接口**/
	public static final String mct_supplier_add = service_domain+"/supplier/add"; //添加商户账户
	
	public static final String mct_supplier_update = service_domain+"/supplier/update"; //更新商户账户
	
	public static final String mct_supplier_query = service_domain+"/supplier/query"; //查询商户账户
	
	public static final String mct_supplier_list = service_domain+"/supplier/list"; //商户账户列表
	
	public static final String mct_supplier_list_forAccount = service_domain+"/supplier/list/forAccount"; //根据账户查询商户账户列表
	
	
	/**商户账户_商户门店 请求接口**/
	public static final String mct_accountMerchants_add = service_domain+"/accountMerchants/add"; //添加商户账户_商户门店
	
	public static final String mct_accountMerchants_del = service_domain+"/accountMerchants/del"; //删除商户账户_商户门店
}
