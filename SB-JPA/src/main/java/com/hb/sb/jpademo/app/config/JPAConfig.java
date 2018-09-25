package com.hb.sb.jpademo.app.config;

import java.util.Properties;
import javax.sql.DataSource;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration 
@EnableTransactionManagement
@EnableJpaRepositories("com.hb.sb.jpademo.app.dao")
@PropertySource("classpath:database.properties")
public class JPAConfig {
	
	@Autowired
    private Environment env;
	
	//@Autowired 
	//private DBProps dbProps;
	
	@Bean(name="entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
	    LocalContainerEntityManagerFactoryBean entityManagerFactory 
			= new LocalContainerEntityManagerFactoryBean();
	    entityManagerFactory.setJpaVendorAdapter(getJpaVendorAdapter());
	    entityManagerFactory.setDataSource(getDataSource());
	    entityManagerFactory.setPersistenceUnitName("myJpaPersistenceUnit");
	    entityManagerFactory.setPackagesToScan("com.hb.sb.jpademo.app.dao");
	    entityManagerFactory.setJpaProperties(jpaProperties());
	    return entityManagerFactory;
	}
	
	@Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
	    JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    return adapter;
	}
    
	@Bean
	public DataSource getDataSource() {

		final HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(100);
        ds.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        ds.addDataSourceProperty("url", env.getProperty("database.url"));
        ds.addDataSourceProperty("user", env.getProperty("database.username"));
        ds.addDataSourceProperty("password", env.getProperty("database.password"));
        //ds.addDataSourceProperty("cachePrepStmts", true);
        //ds.addDataSourceProperty("prepStmtCacheSize", 250);
        //ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        //ds.addDataSourceProperty("useServerPrepStmts", true);
        return ds;
    }
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager txManager(){
	    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
			getEntityManagerFactoryBean().getObject());
	    return jpaTransactionManager;
	}
	
	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.default_schema", env.getProperty("hibernate.default_schema"));
		properties.put("hibernate.jdbc.lob.non_contextual_creation", env.getProperty("hibernate.jdbc.lob.non_contextual_creation"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		properties.put("hibernate.id.new_generator_mappings", env.getProperty("hibernate.id.new_generator_mappings"));
		return properties;        
	}	
} 