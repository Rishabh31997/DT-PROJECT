package com.mainproject.backend01.config;



import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableTransactionManagement
@ComponentScan(value="{com.mainproject.backend01.config}")
public class HibernateConfig {
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(HibernateProprties());
		sessionFactory.setPackagesToScan(new String[]{"com.mainproject.backend01.models","com.mainproject.backend01.daos"});
		return sessionFactory;
		
	}
	
	@Bean(name="dataSource")
	public DataSource dataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:~/test");
		ds.setUsername("sa");
		ds.setPassword("");
		
		
		return ds;
		
	}
	
	@Bean
	public Properties HibernateProprties(){
		Properties pro=new Properties();
		pro.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		pro.put("hibernate.hbm2ddl.auto", "update");
		pro.put("hibernate.show_sql", "true");
		return pro;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionmanger(SessionFactory sessionfactory){
		HibernateTransactionManager tran=new HibernateTransactionManager();
		tran.setSessionFactory(sessionfactory);
		return tran;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
