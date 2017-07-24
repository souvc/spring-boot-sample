package com.swagger.bootstrap.ui.demo.common;


import java.io.Serializable;

/***
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 */
public class RestMessage implements Serializable{
	private boolean success=true;
	private Object data;
	private Integer errCode;
	private String message;
	

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}




	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RestMessage() {
		super();
	}

	public RestMessage(Object data) {
		super();
		this.data = data;
	}

	public RestMessage(boolean success, Object data) {
		super();
		this.success = success;
		this.data = data;
	}
	

}
