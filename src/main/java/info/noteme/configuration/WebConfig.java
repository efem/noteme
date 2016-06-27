package info.noteme.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import freemarker.template.utility.XmlEscape;

@Configuration
@EnableWebMvc
@ComponentScan({ "info.noteme", "info.noteme.repository" })
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
		// resolver.setCache(true);
		resolver.setPrefix("/WEB-INF/views/ftl/");
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
	public FreeMarkerConfigurer freemarkerConfig() {
		FreeMarkerConfigurer config = new FreeMarkerConfigurer();
		Properties property = new Properties();
		property.setProperty("default_encoding", "UTF-8");

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("xml_escape", fmXmlEscape);
		config.setFreemarkerVariables(variables);
		// config.setTemplateLoaderPath("/WEB-INF/views/ftl");
		config.setFreemarkerSettings(property);
		return config;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
