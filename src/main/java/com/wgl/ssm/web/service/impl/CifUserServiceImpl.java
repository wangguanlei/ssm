package com.wgl.ssm.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wgl.ssm.web.dao.CifUserMapper;
import com.wgl.ssm.web.service.ICifUserService;

@Service("cifUserService")
public class CifUserServiceImpl implements ICifUserService {

	@Resource
	private CifUserMapper userMapper;
	
}
