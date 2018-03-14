package com.wgl.ssm.base;


public class HttpException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private int statusCode; // http://baike.baidu.com/link?url=NX-UGsi4nKyoXnq22B77zuGS-BuRaxJpiSHX6h0VXH0YBpbOzq4yskmbHo1RB4YK17LUobAjF9LioFaeX4qFWa
	private String reason;
	
	public HttpException(){
		
	}
	
	public HttpException(int statusCode){
		
		this.statusCode = statusCode;
	}
	
	public HttpException(int statusCode, String reason){
		
		this.statusCode = statusCode;
		this.reason = reason;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
