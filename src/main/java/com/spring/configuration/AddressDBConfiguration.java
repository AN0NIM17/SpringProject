package com.spring.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.address.db.repositories.AddressRepository;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = AddressRepository.class, entityManagerFactoryRef = "addressFactoryBean", transactionManagerRef = "addressTransactionManager")
public class AddressDBConfiguration {
	

	@Bean
	@ConfigurationProperties("spring.datasource2")
	public DataSourceProperties addressDataSourceProperties() {
		return new DataSourceProperties();
	}
	

	@Bean
	public DataSource addressDataSource(@Qualifier("addressDataSourceProperties") DataSourceProperties addressDataSourceProperties) {
		return addressDataSourceProperties.initializeDataSourceBuilder().build();
	}
	

	@Bean
	public LocalContainerEntityManagerFactoryBean addressFactoryBean(@Qualifier("addressDataSource") DataSource addressDataSource) {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(addressDataSource);
		localContainerEntityManagerFactoryBean.setPackagesToScan("com.spring.address.models");
		localContainerEntityManagerFactoryBean.setPersistenceUnitName("Address");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		return localContainerEntityManagerFactoryBean;
	}
	

	@Bean
	public PlatformTransactionManager addressTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(addressFactoryBean(addressDataSource(addressDataSourceProperties())).getObject());
		return transactionManager;
	}
}
