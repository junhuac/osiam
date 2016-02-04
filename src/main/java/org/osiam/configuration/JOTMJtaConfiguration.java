package org.osiam.configuration;

import org.objectweb.jotm.datasource.DataSourceFactory; 
import org.objectweb.jotm.*; 
import org.objectweb.jotm.UserTransactionService; 
import org.objectweb.jotm.UserTransactionServiceImp; 
import org.objectweb.transaction.jta.UserTransactionImp; 
import org.objectweb.transaction.jta.UserTransactionManager; 
import org.objectweb.transaction.jta.hibernate3.TransactionManagerLookup; 
import org.springframework.context.annotation.Bean; 
import org.springframework.core.env.Environment; 
import org.springframework.transaction.PlatformTransactionManager; 
import org.springframework.transaction.jta.JtaTransactionManager; 
 
import javax.transaction.TransactionManager; 
import javax.transaction.UserTransaction; 
import java.util.Enumeration; 
import java.util.Properties; 
 
 
public class JOTMJtaConfiguration implements TransactionConfig  { 
  
    public Properties tailorEntityManagerFactoryProperties(Properties properties) { 
        properties.setProperty("hibernate.transaction.manager_lookup_class", 
                TransactionManagerLookup.class.getName()); 
        return properties; 
    } 
 
    @Bean(destroyMethod = "shutdownForce") 
    public UserTransactionService userTransactionService() { 
 
        UserTransactionService service= new UserTransactionServiceImp() ; 
        Properties props= new Properties(); 
 
        props.put("org.objectweb.jotm.service","org.objectweb.jotm.standalone.UserTransactionServiceFactory"); 
        props.put("org.objectweb.jotm.log_base_name","aaaaaa"); 
        props.put("org.objectweb.jotm.output_dir","../standalone/log/"); 
        props.put("org.objectweb.jotm.log_base_dir","../standalone/log/"); 
 
        service.init(props); 
 
        return service; 
 
    } 
 
    @Bean 
    public PlatformTransactionManager platformTransactionManager() throws Throwable { 
        UserTransaction userTransaction = this.userTransaction(); 
        TransactionManager transactionManager = this.transactionManager(); 
        return new JtaTransactionManager(userTransaction, transactionManager); 
    } 
 
    @Bean 
    public UserTransaction userTransaction() throws Throwable { 
        UserTransactionImp userTransactionImp = new UserTransactionImp(); 
        userTransactionImp.setTransactionTimeout(60); 
        return userTransactionImp; 
    } 
 
    @Bean(initMethod = "init", destroyMethod = "close") 
    public TransactionManager transactionManager() throws Throwable { 
        UserTransactionManager userTransactionManager = new UserTransactionManager(); 
        userTransactionManager.setForceShutdown(false); 
        userTransactionManager.setStartupTransactionService(false); 
        return userTransactionManager; 
    } 
 
 
    /**
     @Bean(initMethod = "init", destroyMethod = "close") 
     public ConnectionFactory connectionFactory() { 
     ActiveMQXAConnectionFactory activeMQXAConnectionFactory = new ActiveMQXAConnectionFactory(); 
     activeMQXAConnectionFactory.setBrokerURL(this.environment.getProperty( "jms.broker.url")  ); 
     AtomikosConnectionFactoryBean atomikosConnectionFactoryBean = new AtomikosConnectionFactoryBean(); 
     atomikosConnectionFactoryBean.setUniqueResourceName("xamq"); 
     atomikosConnectionFactoryBean.setLocalTransactionMode(false); 
     atomikosConnectionFactoryBean.setXaConnectionFactory(activeMQXAConnectionFactory); 
     return atomikosConnectionFactoryBean; 
     } 
     */ 
 
}

