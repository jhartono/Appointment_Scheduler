package com.bluetree.indonesia.appointment;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.data.web.PageableArgumentResolver;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.webflow.context.servlet.WebFlow1FlowUrlHandler;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowController;

@Configuration
@ComponentScan(basePackages={"com.bluetree.indonesia.appointment.controller"})
@ImportResource({
	"classpath:appointment-webflow-config.xml"
})
public class DispatcherConfig extends WebMvcConfigurationSupport {
	
	@Inject
	FlowExecutor flowExecutor;
	
	@Override
	protected void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		PageableArgumentResolver resolver = new PageableArgumentResolver();
		resolver.setFallbackPagable(new PageRequest(0, 10));      
		argumentResolvers.add(new ServletWebArgumentResolverAdapter(resolver));
	}
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry
			.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/");
	}
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

	@Bean
	public DomainClassConverter<?> domainClassConverter() {
		return new DomainClassConverter<FormattingConversionService>(mvcConversionService());
	}

	@Bean(name = "internalResourceViewResolver")
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
    
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource result
            = new ResourceBundleMessageSource();
        String[] basenames = {
            "i18n.message.message"
        };
        result.setBasenames(basenames);
        return result;
    }
 
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor result = new LocaleChangeInterceptor();
        result.setParamName("lang");
        return result;
 
    }
 
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver result = new SessionLocaleResolver();
        result.setDefaultLocale(Locale.ENGLISH);
        return result;
    }
    
    @Bean(name = "/flow")
    public FlowController flowController() {
    	FlowController flowController = new FlowController();
    	flowController.setFlowExecutor(flowExecutor);
    	flowController.setFlowUrlHandler(new WebFlow1FlowUrlHandler());
    	return flowController;
    }
}
