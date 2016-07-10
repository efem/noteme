package info.noteme.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import freemarker.template.TemplateException;
import freemarker.template.utility.XmlEscape;

@Configuration
@EnableWebMvc
@ComponentScan({ "info.noteme" })
@ContextConfiguration(classes = { WebConfig.class, DataSourceConfig.class, JpaConfig.class, PassEncoderConfig.class })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private XmlEscape fmXmlEscape;

	@Bean
	public XmlEscape fmXmlEscape() {
		return new XmlEscape();
	}

	@Bean
	public FreeMarkerViewResolver freemarkerViewResolver() {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setOrder(1);
		resolver.setCache(false);
		resolver.setPrefix("");
		resolver.setSuffix(".ftl");
		return resolver;
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
	public SessionLocaleResolver localeResolver() {
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

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
