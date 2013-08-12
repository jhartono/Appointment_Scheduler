package com.bluetree.indonesia.appointment;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan(basePackages={
		"com.bluetree.indonesia.appointment.service",
		"com.bluetree.indonesia.appointment.facade",
		"com.bluetree.indonesia.appointment.mapper", 
		"com.bluetree.indonesia.appointment.formatter", 
		"com.bluetree.indonesia.appointment.validator"
})
public class ApplicationConfig {
	
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