package com.bluetree.indonesia.appointment.test;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bluetree.indonesia.appointment.domain.AbstractEntity;

@Configuration
@EnableTransactionManagement
@ImportResource({
	"classpath:audit-context.xml"
})
@PropertySource("classpath:database.properties")
@EnableJpaRepositories(basePackages={"com.bluetree.indonesia.appointment.repository"})
//@ComponentScan(basePackages={
//		"in.bluetree.visitor_management.service", 
//		"in.bluetree.visitor_management.mapper"
//})
public class TestConfig {
	
	@Inject
	Environment env;
	
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();        
        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));        
        return ds;
    }
	
	@Bean 
	public EntityManagerFactory entityManagerFactory() {
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setDatabase(Database.MYSQL);
	    vendorAdapter.setShowSql(Boolean.TRUE);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan(AbstractEntity.class.getPackage().getName());
	    factory.setDataSource(dataSource());

	    factory.afterPropertiesSet();

	    return factory.getObject();
	}

	@Bean 
	public JpaDialect jpaDialect() {
	    return new HibernateJpaDialect();
	}

	@Bean 
	public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	}
}