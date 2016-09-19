package com.icloud.dto;

import java.util.ArrayList;
import java.util.List;

import com.icloud.model.MerchantsAccount;

/**
 * 公众号条件分页查询dto
 * 
 * @author luoqw 2016-9-7上午10:11:30
 */
public class AccountQueryDto extends BaseDto {
	private int offset = 1;
	private int pageSize = 10;
	private List<MerchantsAccount> accouts = new ArrayList<MerchantsAccount>();

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

	public List<MerchantsAccount> getAccouts() {
		return accouts;
	}

	public void setAccouts(List<MerchantsAccount> accouts) {
		this.accouts = accouts;
	}

	public AccountQueryDto(String resultType, String resultCode,
			int offset, int pageSize, List<MerchantsAccount> accouts) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.offset = offset;
		this.pageSize = pageSize;
		this.accouts = accouts;
	}

	public AccountQueryDto(String resultType, String resultCode,
			String errorMsg, int offset, int pageSize) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
		this.offset = offset;
		this.pageSize = pageSize;
	}

}
