package org.osiam;

import com.google.common.collect.ImmutableMap;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.hibernate.search.jpa.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.flywaydb.core.Flyway;
//import org.flywaydb.core.api.MigrationVersion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableWebMvc
@EnableWebSecurity
@EnableTransactionManagement
@EnableMetrics
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Osiam extends SpringBootServletInitializer {

    private static final Map<String, Object> DEFAULT_PROPERTIES = ImmutableMap.<String, Object>of(
            "spring.config.location", "classpath:/osiam.yaml"
    );

    @Value("${org.osiam.db.driver}")
    private String driverClassName;

    @Value("${org.osiam.db.url}")
    private String databaseUrl;

    @Value("${org.osiam.db.username}")
    private String databaseUserName;

    @Value("${org.osiam.db.password}")
    private String databasePassword;

    @Value("${org.osiam.db.vendor}")
    private String databaseVendor;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Osiam.class);
        application.setDefaultProperties(DEFAULT_PROPERTIES);
        ConfigurableApplicationContext context = application.run(args);
        
        EntityManager em = context.getBean(EntityManagerFactory.class).createEntityManager();
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
        try {
        	fullTextEntityManager.createIndexer().startAndWait();
        }
        catch (Exception ex) {
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.application().setDefaultProperties(DEFAULT_PROPERTIES);
        return application.sources(Osiam.class);
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
/*
    @Primary
    @Bean
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setPoolName("osiam-cp");
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setJdbcUrl(databaseUrl);
        hikariConfig.setUsername(databaseUserName);
        hikariConfig.setPassword(databasePassword);
        return new HikariDataSource(hikariConfig);
    }
*/

    @Bean
    public DataSource dataSource(){
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jpa");
       dataSource.setUsername( "tutorialuser" );
       dataSource.setPassword( "tutorialmy5ql" );
       return dataSource;
    }
    
/*
    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource());
        flyway.setLocations("db/migration/" + databaseVendor);
        flyway.setBaselineOnMigrate(true);
        flyway.setBaselineVersion(MigrationVersion.fromVersion("2"));
        return flyway;
    }
*/
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("osiam");
        
        //factoryBean.setDataSource(dataSource());
        //factoryBean.setPackagesToScan(new String[] { "org.osiam.storage.entities" });
   
        //JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        //factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setJpaProperties(jpaProperties());
        factoryBean.setJpaProperties(additionalProperties());
        
        return factoryBean;
    }

/*    
    @Bean
    public PlatformTransactionManager platformTransactionManager()  throws Throwable {
        JtaTransactionManager transactionBean = new JtaTransactionManager();
        transactionBean.setTransactionManagerName("java:comp/UserTransaction");
        transactionBean.setAllowCustomIsolationLevels(true);
        transactionBean.setTransactionSynchronizationRegistryName("java:comp/env/TransactionSynchronizationRegistry");
        return transactionBean;
	}
*/	
    
    @Bean
    public ShaPasswordEncoder passwordEncoder() {
        ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(512);
        passwordEncoder.setIterations(1000);
        return passwordEncoder;
    }
    
    Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JTATransactionFactory");  
        return properties;
    }
    
    Properties additionalProperties() {
       Properties properties = new Properties();
       properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
       properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
       return properties;
    }    
}
