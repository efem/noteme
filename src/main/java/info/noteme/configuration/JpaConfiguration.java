package info.noteme.configuration;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages="info.noteme")
@EnableTransactionManagement
public class JpaConfiguration {
	@Autowired
	DataSourceConfig dsConfig;
	
	@Bean
	public PlatformTransactionManager transactionManager(){
	    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		EntityManagerFactory emf = dsConfig.entityManagerFactory(dsConfig.dataSource(), dsConfig.jpaVendorAdapter()).getNativeEntityManagerFactory();
				
	    jpaTransactionManager.setDataSource(dsConfig.dataSource());
	    jpaTransactionManager.setEntityManagerFactory(emf);
	    return jpaTransactionManager;
	}
}