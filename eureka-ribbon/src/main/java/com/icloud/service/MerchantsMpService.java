package com.icloud.service;

/**
 * 
 * @author luoqw
 *
 */
public interface MerchantsMpService {

	/**
	 * 添加公众号
	 * @param request
	 * @return
	 */
	public Object add(String jsonParams);
	
	/**
	 * 获取账户所管理的公众号列表
	 * @param access_token
	 * @param data
	 * @return
	 */
	public Object list(int accountId,String data) ;
	
 
	
 
	/**置为不可用**/
	public Object mpDisable(String mpId) ;



}
