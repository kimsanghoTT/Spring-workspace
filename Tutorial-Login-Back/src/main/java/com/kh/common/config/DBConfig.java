package com.kh.common.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// 컴퓨터 설정, 구성
@Configuration
@PropertySource("classpath:/config.properties") //추후 변경
//@PropertySource : properties 파일의 내용을 이용함을 명시
//다른 properties 파일을 추가하고 싶다면 어노테이션을 추가
//@PropertySource("classpath:/config2.properties")
public class DBConfig {

	@Autowired
	private ApplicationContext applicationContext; // 폴더 흐름
	//import org.springframework.context.ApplicationContext; 할 것.
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	//properties 파일의 내용을 이용해서 생성되는 bean을 설정하는 어노테이션
	//prefix = 시작 위치를 지정해서 'spring.datasource.hikari'로 시작하는 설정을 모두 적용
	//spring.datasource.hikari = Oracle DB 연결할 때 쓰는 풀. 빠르고 가벼움
	public HikariConfig hikariConfig() { //주소 설정
		return new HikariConfig();
	}
	
	@Bean //Spring Context 스프링 안에서 관리되고 있는 기능임을 명시하는 설정
	public DataSource dataSource(HikariConfig config) { //연결된 db를 스프링에서 관리. -> 관리하는 용도로 등록한 것
		DataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}
	
	//Mybatis 설정 추가
	//SqlSessionFactory : SqlSession을 만드는객체
	@Bean
	public SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		
		//매퍼 파일이 모여있는 경로 설정
		sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/**.xml")); //추후 변경
		
		//별칭 지정해야하는 dto가 모여있는 패키지 지정
		//해당 패키지에 있는 모든 클래스가 클래스명으로 별칭이 지정됨
		//aliase = 별칭, package 폴더 밑에 있는 파일 모두
		sessionFactoryBean.setTypeAliasesPackage("com.kh.dto"); //추후 변경
		
		//mybatis 설정 파일 경로 지정
		sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml")); //추후 변경
		
		return sessionFactoryBean.getObject();
	}
	
	//기본 sql 실행 + Commit 처리 = 트랜잭션 처리. (commit = 최종 파일 저장)
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sessionFactory) {
		return new SqlSessionTemplate(sessionFactory);
	}
	
	//전반적인 Commit과 Rollback과 같은 관리를 해주는 트랜잭션 매니저
	//DataSourceTransactionManager = 트랜잭션 매니저
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
