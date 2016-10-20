package com.hello.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class PR6Config
{

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	
	@Value("${spring.datasource.pr6.url}")
	private String connectionURL;
	
	@Value("${spring.datasource.pr6.username}")
	private String userId;
	
	@Value("${spring.datasource.pr6.password}")
	private String password;
	
	
	/**
	 * @return
	 */
	@Bean(name = "pr6DataSource", destroyMethod = "close")
	public DataSource primaryDataSource()
	{
		return DataSourceBuilder
			.create()
			.driverClassName(driverClassName)
			.url(connectionURL)
			.username(userId)
			.password(password)
			.build();
	}

	/**
	 * @param primaryDataSource
	 * @return
	 */
	@Bean(name = "pr6JdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("pr6DataSource") DataSource primaryDataSource)
	{
		return new JdbcTemplate(primaryDataSource);
	}
	
	@Bean(name = "pr6NamedJdbcTemplate")
	public NamedParameterJdbcTemplate primaryNamedJdbcTemplate(@Qualifier("pr6DataSource") DataSource primaryDataSource)
	{
		return new NamedParameterJdbcTemplate(primaryDataSource);
	}
	
}
