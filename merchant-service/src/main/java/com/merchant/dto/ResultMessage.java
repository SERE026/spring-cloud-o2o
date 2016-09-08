package com.merchant.dto;

/**
 * 数据消息bean
 * @author luoqw
 * 2016-9-7上午10:12:01
 */
public class ResultMessage {

	private boolean success;
	private String msg;
	private Object data;
	
	public ResultMessage() { 
	}
	 
	public ResultMessage(boolean success, String msg) { 
		this.success = success;
		this.msg = msg;
	}
	
	public ResultMessage(boolean success, String msg,Object data) { 
		this.success = success;
		this.msg = msg;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
