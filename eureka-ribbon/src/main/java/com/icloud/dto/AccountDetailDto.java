package com.icloud.dto;

import com.icloud.model.MerchantsAccount;

/**
 * 商户帐户详情Dto
 * 
 * @author luoqw 2016-9-7上午10:10:57
 */
public class AccountDetailDto extends BaseDto {
	private MerchantsAccount account;

	public AccountDetailDto(String resultType, String resultCode, String errorMsg) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
	}

	public AccountDetailDto(String resultType, String resultCode, MerchantsAccount account) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.account = account;
	}

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

	public MerchantsAccount getAccount() {
		return account;
	}

	public void setAccount(MerchantsAccount account) {
		this.account = account;
	}

}
