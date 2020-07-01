package com.dyliu.jdbc.mapper;


import com.dyliu.jdbc.pojo.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author liudongyang
 */
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(rs.getInt("id"),rs.getString("name")
		,rs.getInt("age"),rs.getString("sex"));
	}
}
