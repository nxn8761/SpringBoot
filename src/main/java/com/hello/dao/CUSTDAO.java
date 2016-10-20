package com.hello.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class CUSTDAO
{
	
	public void test()
	{
		System.out.println("this is test");
	}
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	public void  getDetails()
	{
		String sql = "SELECT * FROM MACCT_CUST_TRTRY WHERE FSCL_YR = 2015 AND FSCL_WK_NBR = 3 FETCH FIRST 100 ROWS ONLY WITH UR";
		System.out.println("get details");
		jdbcTemplate.query(sql, new ResultSetExtractor(){
			
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException
			{
				String x = null;
				while(rs.next())
				{
					System.out.println(rs.getInt("CUST_ID"));
				}
				return x;
			}
		});
	}
	
	
}
