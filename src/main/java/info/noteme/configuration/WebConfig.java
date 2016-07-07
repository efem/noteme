package info.noteme.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import freemarker.template.TemplateException;
import freemarker.template.utility.ClassUtil;
import freemarker.template.utility.XmlEscape;

@Configuration
@EnableWebMvc
@ComponentScan({ "info.noteme" })
@ContextConfiguration(classes = { WebConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter {
	/*
	 * @Bean public ViewResolver viewResolver() { InternalResourceViewResolver
	 * resolver = new InternalResourceViewResolver();
	 * resolver.setPrefix("/WEB-INF/views/ftl/"); resolver.setSuffix(".ftl");
	 * resolver.setExposeContextBeansAsAttributes(true); return resolver; }
	 */

	@Bean
	public FreeMarkerViewResolver freemarkerViewResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setOrder(1);
		resolver.setCache(false);
		resolver.setPrefix("");
		resolver.setSuffix(".ftl");
		return resolver;
	}

	@Autowired
	private XmlEscape fmXmlEscape;

	@Bean
	public XmlEscape fmXmlEscape() {
		return new XmlEscape();
	}

	@Bean
	public FreeMarkerConfigurer freemarkerConfig(WebApplicationContext applicationContext)
			throws IOException, TemplateException {
		FreeMarkerConfigurer config = new FreeMarkerConfigurer();
		Map<String, Object> variables = new HashMap<String, Object>();
		Properties property = new Properties();

		property.setProperty("auto_import", "spring.ftl as spring");
		property.setProperty("default_encoding", "UTF-8");
		variables.put("xml_escape", fmXmlEscape);
		config.setServletContext(applicationContext.getServletContext());
		config.setFreemarkerVariables(variables);
		config.setTemplateLoaderPath("/WEB-INF/views/ftl");
		// config.setResourceLoader(applicationContext);
		config.setFreemarkerSettings(property);

		return config;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();

		interceptor.setParamName("lang");
		return interceptor;
	}

	@Bean
	SessionLocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("i18n/msg");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}

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
		emfb.setPersistenceUnitName("myDatabase");
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

	/*
	 * @Bean public RequestMappingHandlerMapping handlerMapping() {
	 * RequestMappingHandlerMapping handler = new
	 * RequestMappingHandlerMapping();
	 * handler.setInterceptors(this.localeChangeInterceptor()); return handler;
	 * }
	 */

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
