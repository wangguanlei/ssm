package com.wgl.ssm.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageHelper;
import com.wgl.ssm.base.BaseController;
import com.wgl.ssm.base.ReturnData;
import com.wgl.ssm.web.service.ICifUserService;
import com.wgl.ssm.web.service.IFirstService;

@Controller
@RequestMapping("/first")
public class FirstController extends BaseController {
	
	@Resource
	private IFirstService firstService;
	@Resource
	private ICifUserService userService;

	@RequestMapping(value = "/f" , method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<ReturnData> insert(HttpServletRequest request,HttpServletResponse response) throws Exception{
    	ReturnData ret = ReturnData.newSuccessReturnData();
    	PageHelper.startPage(1, 5, true);  
    	List<Map<String,Object>> dataList = this.firstService.queryF();
    	ret.setData(dataList);
    	ret.setMessage("成功");
    	return new ResponseEntity<ReturnData>(ret, HttpStatus.OK);	
    }
	
}
