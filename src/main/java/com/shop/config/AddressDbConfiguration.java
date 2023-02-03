package com.shop.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "addressEntityManagerFactory", transactionManagerRef = "addressTransactionManager", basePackages = {
		"com.shop.repo2" })
public class AddressDbConfiguration {
	
	
	@Bean(name = "addressDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource addressDataSource() {
		return DataSourceBuilder.create().build();
	}

	
	@Bean(name = "addressEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean addressEntity(EntityManagerFactoryBuilder builder,
			@Qualifier("addressDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.shop.model2").persistenceUnit("spring").build();
	}

	
	@Bean(name = "addressTransactionManager")
	public PlatformTransactionManager addressTransactionManager(
			@Qualifier("addressEntityManagerFactory") EntityManagerFactory addressEntityManagerFactory) {
		return new JpaTransactionManager(addressEntityManagerFactory);
	}
}
