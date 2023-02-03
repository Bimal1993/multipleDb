package com.shop.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shop.model.Employee;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "employeeEntityManagerFactory", transactionManagerRef = "employeeTransactionManager", basePackages = {
		"com.shop.repo" })
public class EmployeeDbConfiguration {

	@Primary
	@Bean(name = "empDataSource")
	@ConfigurationProperties(prefix = "employee.datasource")
	public DataSource empDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "employeeEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean empEntity(EntityManagerFactoryBuilder builder,
			@Qualifier("empDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.shop.model").persistenceUnit("employee").build();
	}

	@Primary
	@Bean(name = "employeeTransactionManager")
	public PlatformTransactionManager employeeTransactionManager(
			@Qualifier("employeeEntityManagerFactory") EntityManagerFactory addressEntityManagerFactory) {
		return new JpaTransactionManager(addressEntityManagerFactory);
	}
}
