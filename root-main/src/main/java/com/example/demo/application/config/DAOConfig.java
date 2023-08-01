package com.example.demo.application.config;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;
/**
 * Created by Java Developer Zone on 25-08-2017.
 */
@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories
public class DAOConfig {
    @Autowired
    private Environment environment;
    @Autowired
    private DataSource dataSource;    // It will automatically read database properties from application.properties and create DataSource object
    @Autowired
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean getSessionFactory() {            // creating session factory
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(new String[]{"com.example.demo.models"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    private Properties hibernateProperties() {                  // configure hibernate properties
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("spring.jpa.database-platform"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
        return properties;
    }
    @Autowired
    @Bean(name = "transactionManager")                      // creating transaction manager factory
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);
        return transactionManager;
    }
}