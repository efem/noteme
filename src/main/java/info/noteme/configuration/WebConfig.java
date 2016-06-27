package info.noteme.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import freemarker.template.TemplateException;
//import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import freemarker.template.utility.XmlEscape;

@Configuration
@EnableWebMvc
@ComponentScan({"info.noteme", "info.noteme.repository"})
public class WebConfig extends WebMvcConfigurerAdapter {
	/*@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/ftl/");
		resolver.setSuffix(".ftl");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}*/
	
/*    @Bean
    public FreeMarkerViewResolver viewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setCache(true);
        freeMarkerViewResolver.setPrefix("");
        freeMarkerViewResolver.setSuffix(".ftl");
        return freeMarkerViewResolver;
    }

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/ftl/");
        Properties settings = new Properties();
        settings.setProperty("number_format", "0.######");
        freeMarkerConfigurer.setFreemarkerSettings(settings);
        Map variables = new java.util.HashMap<String, Object>();

        variables.put("xml_escape", new XmlEscape());
        freeMarkerConfigurer.setFreemarkerVariables(variables);
        return freeMarkerConfigurer;
    }*/
	@Bean 
	public FreeMarkerViewResolver freemarkerViewResolver() { 
	    FreeMarkerViewResolver resolver = new FreeMarkerViewResolver(); 
	    resolver.setOrder(1);
	    resolver.setCache(true); 
	    resolver.setPrefix("/WEB-INF/views/ftl/"); 
	    resolver.setSuffix(".ftl"); 
	    return resolver; 
	}
	
	/*@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer(WebApplicationContext applicationContext) throws IOException, TemplateException {
	    FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();

	    freemarker.template.Configuration configuration = configurer.getConfiguration();
	    //configuration.addAutoInclude("/templates/include-common.ftl");
	    
	   Configuration configuration = new Configuration();
	    configuration.setWhitespaceStripping(true);

	    configuration.setDefaultEncoding("UTF-8");
	    configuration.setOutputEncoding("UTF-8");
	    configuration.setURLEscapingCharset("UTF-8");
	    configuration.setServletContextForTemplateLoading(applicationContext.getServletContext(), "/WEB-INF/views/ftl/");

	    configurer.setConfiguration(configuration);

	    return configurer;
	}*/
	
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
		property.setProperty("templateLoaderPath", "/WEB-INF/view/ftl");
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("xml_escape", fmXmlEscape);
		config.setFreemarkerVariables(variables);
		config.setFreemarkerSettings(property);
		return config;
	}
	
	
	
	@Override
	public void configureDefaultServletHandling (DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
}
