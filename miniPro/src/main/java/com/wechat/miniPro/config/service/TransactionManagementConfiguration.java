package com.wechat.miniPro.config.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
@EnableTransactionManagement  //开启事务的管理
public class TransactionManagementConfiguration implements TransactionManagementConfigurer{

	@Autowired
    private DataSource dataSource; // Transaction需要一个成员变量 有了dataSource才能基于事物的管理
	@Override
	public TransactionManager annotationDrivenTransactionManager() {
		// TODO Auto-generated method stub
		return new DataSourceTransactionManager(dataSource);  
	}
	
}
