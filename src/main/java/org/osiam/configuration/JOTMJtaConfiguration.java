package org.osiam.configuration;

import org.objectweb.jotm.datasource.DataSourceFactory; 
import org.objectweb.jotm.*; 
import org.objectweb.jotm.Current; 
import org.objectweb.transaction.jta.TransactionManager; 
import org.springframework.context.annotation.Bean; 
import org.springframework.core.env.Environment; 
import org.springframework.transaction.PlatformTransactionManager; 
import org.springframework.transaction.jta.JtaTransactionManager; 
 
import javax.transaction.UserTransaction; 
import java.util.Enumeration; 
import java.util.Properties; 
 
 
public class JOTMJtaConfiguration{ 
    @Bean 
    public PlatformTransactionManager platformTransactionManager() throws Throwable { 
        UserTransaction userTransaction = this.userTransaction(); 
        TransactionManager transactionManager = this.transactionManager(); 
        return new JtaTransactionManager(userTransaction, transactionManager); 
    } 
 
    @Bean 
    public UserTransaction userTransaction() throws Throwable { 
    	  // Check for already active JOTM instance. 
    	Current jotmCurrent = Current.getCurrent(); 
    	 
	    // If none found, create new local JOTM instance. 
	    if (jotmCurrent == null) { 
	     // Only for use within the current Spring context: 
	     // local, not bound to registry. 
	     Jotm jotm = new Jotm(true, false); 
	     jotmCurrent = Current.getCurrent(); 
	    } 
	   return jotmCurrent;
    } 
 
    @Bean(initMethod = "init", destroyMethod = "close") 
    public TransactionManager transactionManager() throws Throwable { 
        UserTransaction userTransaction = this.userTransaction(); 
        TransactionManager userTransactionManager = Current.getTransactionManager(); 
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

