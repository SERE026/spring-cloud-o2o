package com.icloud.dto;

import com.icloud.model.MerchantsMessage;

/**
 * 商户帐户详情Dto
 * 
 * @author luoqw 2016-9-7上午10:10:57
 */
public class MessageDetailDto extends BaseDto  {
	 
	private MerchantsMessage message;

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public MerchantsMessage getMessage() {
		return message;
	}

	public void setMessage(MerchantsMessage message) {
		this.message = message;
	}

}
