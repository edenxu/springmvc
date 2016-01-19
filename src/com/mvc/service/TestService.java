package com.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.ITestDAO;
import com.mvc.pojo.UserInfo;

@Service("TestService")
public class TestService implements ITestService {
	@Autowired
	private ITestDAO dao;
	
	@Override
	@Transactional
	public List<UserInfo> testTransaction() {
		// TODO Auto-generated method stub
		List<UserInfo> ui = new ArrayList<UserInfo>();
		UserInfo tui = new UserInfo();
		tui.setUserCode("003");
		tui.setUserName("ÕıŒÂ");
		dao.add(tui);
		tui.setUserCode("002");
		tui.setUserName("’‘¡˘");
		dao.add(tui);
		ui = dao.getAllUserInfo();
		return ui;
	}

}
