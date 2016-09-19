package com.icloud.dto;

import java.util.ArrayList;
import java.util.List;

import com.icloud.model.MerchantsMessage;

/**
 * 消息条件分页查询dto
 * 
 * @author luoqw 2016-9-7上午10:11:30
 */
public class MessageQueryDto extends BaseDto {
 
	private int offset = 1;
	private int pageSize = 10;
	private List<MerchantsMessage> messages = new ArrayList<MerchantsMessage>();

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

	public List<MerchantsMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<MerchantsMessage> messages) {
		this.messages = messages;
	}

	public MessageQueryDto(String resultType, String resultCode,
			String errorMsg, int offset, int pageSize) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
		this.offset = offset;
		this.pageSize = pageSize;
	}

	public MessageQueryDto(String resultType, String resultCode, int offset,
			int pageSize, List<MerchantsMessage> messages) {
		super();
		this.resultType = resultType;
		this.resultCode = resultCode;
		this.offset = offset;
		this.pageSize = pageSize;
		this.messages = messages;
	}

}
