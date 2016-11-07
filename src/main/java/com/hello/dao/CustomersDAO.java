package com.hello.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class CustomersDAO
{
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate namedJdbcTemplate;
	
	
	public void getCustomerDetails()
	{
		dataSource = DataSourceBuilder.create()
									  .driverClassName("com.ibm.db2.jcc.DB2Driver")
									  .url("jdbc:db2://172.18.103.52:5122/NP1")
									  .username("AD9MM06")
									  .password("FYWO2BHP")
									  .build();
		String sql = "SELECT * FROM CUST WHERE CUST_ID BETWEEN ? AND ? WITH UR";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object o = jdbcTemplate.query(sql, new Object[]{ new Integer(1), new Integer(100)}, new ResultSetExtractor()
		{

			@Override
			public Object extractData(ResultSet rs) throws SQLException,
					DataAccessException
			{
				while(rs.next())
				{
					System.out.println(rs.getInt("CUST_ID"));
				}
				return new Object();
			}
			
		});
		
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		String namedQuery = "SELECT * FROM CUST_CO WHERE CUST_ID = :CUSTID WITH UR";
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("CUSTID", 100);
		
		namedJdbcTemplate.query(namedQuery, source, new ResultSetExtractor()
		{
			public Object extractData(ResultSet rs) throws SQLException
			{
				while(rs.next())
				{
					System.out.println(rs.getString("CO_NM"));
				}
				return new Object();
			}
		});
		
		
		
		
		
											
	}

						
}
