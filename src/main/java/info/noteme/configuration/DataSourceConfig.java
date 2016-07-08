package info.noteme.configuration;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@ComponentScan({ "info.noteme" })
public class DataSourceConfig {
	
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
		adapter.setShowSql(false);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		return adapter;
	}
	
	/*@Bean
	//@PostConstruct
	//@DependsOn({"freemarkerViewResolver", "entityManagerFactory", "jpaVendorAdapter"})
	public String aa(){
		Flyway flyway = new Flyway();
		flyway.setDataSource(this.dataSource());
		flyway.setLocations("sql");
		flyway.setInitOnMigrate(true);
		flyway.clean();
		//flyway.migrate();
		try {
			flyway.migrate();
		}
		catch (Exception e) {
			e.toString();
		}
		System.out.println("xdf");
		return "aa";
	}*/
		
	@EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        System.out.println("AXXX");
        Flyway flyway = new Flyway();
		flyway.setDataSource(this.dataSource());
		flyway.setLocations("sql");
		flyway.setInitOnMigrate(true);
		try {
			//flyway.clean();
			flyway.migrate();
		}
		catch (Exception e) {
			e.toString();
		};
    }
}
