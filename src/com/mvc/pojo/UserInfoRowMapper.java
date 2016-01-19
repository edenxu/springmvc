package com.mvc.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserInfoRowMapper implements RowMapper<UserInfo> {

	@Override
	public UserInfo mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		UserInfo ui = new UserInfo();
		ui.setUserCode(arg0.getString("user_code"));
		ui.setUserName(arg0.getString("user_name"));
		return ui;
	}

}
