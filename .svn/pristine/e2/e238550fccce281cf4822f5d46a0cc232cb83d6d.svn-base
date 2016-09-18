package com.icloud.dto;

import java.util.ArrayList;
import java.util.List;

import com.icloud.model.MerchantsAccount;


/**
 * 公众号条件分页查询dto
 * @author luoqw
 * 2016-9-7上午10:11:30
 */
public class MerchantsAccountQueryResDto {

	private String resultType;
	private String resultCode;
	private String errorMsg;
	private int offset = 1;
	private int pageSize = 10;
	private List<MerchantsAccount> accout = new ArrayList<MerchantsAccount>();

	public MerchantsAccountQueryResDto() {
		super();
	}

	
	public MerchantsAccountQueryResDto(String resultType, String resultCode, int offset, int pageSize,
			List<MerchantsAccount> accout) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.offset = offset;
		this.pageSize = pageSize;
		this.accout = accout;
	}


	public MerchantsAccountQueryResDto(String resultType, String resultCode, String errorMsg, int offset, int pageSize) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
		this.offset = offset;
		this.pageSize = pageSize;
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

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<MerchantsAccount> getAccout() {
		return accout;
	}

	public void setAccout(List<MerchantsAccount> accout) {
		this.accout = accout;
	}

 

}
