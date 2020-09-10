package com.spring.db.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.db.entity.user.User;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = com.spring.db.repositories.user.UserRepository.class, entityManagerFactoryRef = "userFactoryBean", transactionManagerRef = "userTransactionManager")
public class UserDBConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource1")
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource userDataSource(
            @Qualifier("userDataSourceProperties") DataSourceProperties userDataSourceProperties) {
        return userDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean userFactoryBean(
            @Qualifier("userDataSource") DataSource userDataSource, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(userDataSource).packages(User.class).build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager userTransactionManager(EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
