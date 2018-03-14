package com.wgl.ssm.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wgl.ssm.web.dao.FirstMapper;
import com.wgl.ssm.web.service.IFirstService;

@Service("firstService")
public class FirstServiceImpl implements IFirstService {

	@Resource
	private FirstMapper firstDaoMapper;

	@Override
	public List<Map<String, Object>> queryF() {
		return this.firstDaoMapper.queryF();
	}
	
}
