package info.noteme.configuration;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({ "info.noteme" })
@EnableJpaRepositories(basePackages="info.noteme")
@EnableTransactionManagement
public class DataSourceConfig {
	static final Logger LOG = LoggerFactory.getLogger(DataSourceConfig.class);

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("noteme");
		dataSource.setPassword("noteme");
		dataSource.setUrl("jdbc:mysql://10.0.2.2:3306/notedb");
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}

	@Bean
	@DependsOn({"runFlywayScripts"})
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setPackagesToScan(new String[] { "info.noteme" });
		emfb.setDataSource(dataSource);

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emfb.setJpaVendorAdapter(vendorAdapter);
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		emfb.setJpaProperties(additionalProperties());
		return emfb;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "validate");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		return adapter;
	}

/*	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(dataSource);
		sfb.setPackagesToScan(new String[] { "info.noteme" });
		Properties props = new Properties();
		props.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
		sfb.setHibernateProperties(props);
		return sfb;
	}*/

	//@EventListener
	//@PostConstruct
	@Bean
	//public void runFlywayScripts(ContextRefreshedEvent event) {
		public String runFlywayScripts() {
		LOG.info("-----FLYWAY-----");
		Flyway flyway = new Flyway();
		flyway.setDataSource(this.dataSource());
		flyway.setLocations("sql");
		flyway.setBaselineOnMigrate(true);
		try {
			flyway.repair();
			flyway.migrate();
		} catch (Exception e) {
			e.toString();
		};
		return "OK";
	}
	
}
