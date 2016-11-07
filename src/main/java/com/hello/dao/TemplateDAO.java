package com.hello.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TemplateDAO
{

	@Autowired
	@Qualifier("pr6JdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	@Qualifier("pr6NamedJdbcTemplate")
	NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public void  getDetails()
	{
		String sql = "SELECT * FROM MACCT_CUST_TRTRY WHERE CUST_ID = ? AND FSCL_YR = ? FETCH FIRST 100 ROWS ONLY WITH UR";
		System.out.println("get details");
		jdbcTemplate.query(sql,  new Object[] {new Integer(1905112), new Integer(2016)} , new ResultSetExtractor(){
			
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException
			{
				String x = null;
				while(rs.next())
				{
					System.out.println("cust id is "+rs.getInt("CUST_ID") + " Territory id is "+rs.getInt("CHG_TRTRY_ID")
							+ " YEAR is "+rs.getInt("FSCL_YR"));
				}
				return x;
			}
		});
		
		System.out.println("completed");
	}
	
	
	public void getDetailsByusingNamedParameterTemplate()
	{
		String sql = "SELECT * FROM MACCT_CUST_TRTRY WHERE CUST_ID = :CUSTID AND FSCL_YR = :FSCLYR FETCH FIRST 100 ROWS ONLY WITH UR";
		System.out.println("get details by using NAMED PARAMETER JDBC TEMPLATE ");
		
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("CUSTID",1905112);
		paramMap.addValue("FSCLYR",2015);
		
		namedJdbcTemplate.query(sql, paramMap, new ResultSetExtractor(){
			
			public Object extractData(ResultSet rs) throws SQLException, DataAccessException
			{
				String x = null;
				while(rs.next())
				{
					System.out.println("cust id is "+rs.getInt("CUST_ID") + " Territory id is "+rs.getInt("CHG_TRTRY_ID")
							+ " YEAR is "+rs.getInt("FSCL_YR"));
				}
				return x;
			}
		});
		System.out.println("completed");
	}
	
	@Transactional(rollbackFor = Exception.class) 
	public void insertByTemplate() throws Exception
	{
		String sql = "INSERT INTO MACCT_CUST_TRTRY VALUES (:CUSTID,:FSCLYR,:FSCLWKNBR,'NXN8761',CURRENT_TIMESTAMP,:CURRTERRID,:CHGTERRID,CURRENT_DATE)";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("CUSTID",232323232);
		paramMap.addValue("FSCLYR",2016);
		paramMap.addValue("FSCLWKNBR",9);
		paramMap.addValue("CURRTERRID",832);
		paramMap.addValue("CHGTERRID",832);
		
		namedJdbcTemplate.update(sql, paramMap);
		System.out.println("Inserted the data  ");
		
		//throw new Exception();
		
		
		
	}
	
}
