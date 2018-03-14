package com.wgl.ssm.base;

import java.io.Serializable;
import java.util.Map;

/**
 * 返回对象的封装，主要用于json返回
 *
 */
@SuppressWarnings("serial")
public class ReturnData implements Serializable {
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String WARNING = "warning";
	public static final String REDIRECT = "redirect";// 302
	private String statusCode = "200";
	private String status;
	private String message;
	private Object data;
	private Map<String, Object> map;

	public ReturnData() {

	}

	public static ReturnData newSuccessReturnData() {
		return new ReturnData(ReturnData.SUCCESS);
	}

	public static ReturnData newErrorReturnData() {
		return new ReturnData(ReturnData.ERROR);
	}

	public static ReturnData newWarningReturnData() {
		return new ReturnData(ReturnData.WARNING);
	}

	public static ReturnData newRedirectReturnData() {
		return new ReturnData(ReturnData.REDIRECT);
	}

	public ReturnData(String status) {
		this.status = status;
	}

	public ReturnData(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public ReturnData(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object obj) {
		this.data = obj;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
