package com.wgl.ssm.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = "com.wgl.ssm.web.controller")
class ErrorHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ReturnData> webErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		e.printStackTrace();
		// If the exception is annotated with @ResponseStatus rethrow it and let
		// the framework handle it - like the OrderNotFoundException example
		// at the start of this post.
		// AnnotationUtils is a Spring Framework utility class.
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
			throw e;

		ReturnData ret = ReturnData.newErrorReturnData();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", req.getRequestURL());
		ret.setMap(map);

		int statuscode = 500;
		ret.setMessage("出错了，请稍后重试。");

		if (e instanceof HttpException) {
			// 自定义 HttpException

			statuscode = ((HttpException) e).getStatusCode();
			ret.setMessage(((HttpException) e).getReason());
		}
		HttpStatus httpStatus = HttpStatus.valueOf(statuscode);

		ret.setStatusCode(String.valueOf(statuscode));

		return new ResponseEntity<ReturnData>(ret, httpStatus);
	}
}
