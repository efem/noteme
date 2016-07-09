package info.noteme.configuration;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan({ "info.noteme" })
public class DataSourceConfig {
	static final Logger LOG = LoggerFactory.getLogger(DataSourceConfig.class);
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("noteme");
		dataSource.setPassword("noteme");
		dataSource.setUrl("jdbc:mysql://localhost:3306/notedb");
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(BasicDataSource dataSource,
			JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setPersistenceUnitName("noteMeDb");
		emfb.setJpaVendorAdapter(jpaVendorAdapter);
		return emfb;
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
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
	LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
	sfb.setDataSource(dataSource);
	sfb.setPackagesToScan(new String[] { "info.noteme" });
	Properties props = new Properties();
	props.setProperty("dialect", "org.hibernate.dialect.MySQL5Dialect");
	sfb.setHibernateProperties(props);
	return sfb;
	}
		
	@EventListener
    public void runFlywayScripts(ContextRefreshedEvent event) {

        LOG.info("-----FLYWAY-----");
        Flyway flyway = new Flyway();
		flyway.setDataSource(this.dataSource());
		flyway.setLocations("sql");
		flyway.setBaselineOnMigrate(true);
		try {
			flyway.repair();
			flyway.migrate();
		}
		catch (Exception e) {
			e.toString();
		};
    }
}
