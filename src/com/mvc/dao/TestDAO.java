package com.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.pojo.UserInfo;
import com.mvc.pojo.UserInfoRowMapper;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Repository("TestDAO")
public class TestDAO implements ITestDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(UserInfo ui) {
		// TODO Auto-generated method stub
		String sql = "insert into user_info(user_code,user_name) values(?,?)";
		int i = 0;
		i = this.jdbcTemplate.update(sql, ui.getUserCode(),
				ui.getUserName());
		return i;
	}

	@Override
	public UserInfo queryByUserCode(String userCode) {
		// TODO Auto-generated method stub
		String sql = "select * from user_info where user_code=?";
		UserInfo ui = (UserInfo) this.jdbcTemplate.queryForObject(sql,
				new Object[] { userCode }, new UserInfoRowMapper());
		return ui;
	}

	@Override
	public List<UserInfo> getAllUserInfo() {
		// TODO Auto-generated method stub
		String sql = "select * from user_info";
		List<UserInfo> list = this.jdbcTemplate
				.query(sql, new UserInfoRowMapper());
		return list;
	}
}
