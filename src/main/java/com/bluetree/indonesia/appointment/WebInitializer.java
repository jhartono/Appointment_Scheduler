package com.bluetree.indonesia.appointment;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class WebInitializer implements WebApplicationInitializer {
	
	@Override 
	public void onStartup(ServletContext ctx) throws ServletException {
		//ContextLoaderListener
		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
		rootCtx.register(ApplicationConfig.class);
		ctx.addListener(new ContextLoaderListener(rootCtx));

		//SecurityFilter
//		Filter securityFilter = new DelegatingFilterProxy("springSecurityFilterChain");
//		FilterRegistration.Dynamic securityFilterReg = ctx.addFilter("securityFilter", securityFilter);
//		securityFilterReg.addMappingForUrlPatterns(null, false, "/*");
		
		//DispatcherServlet
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(DispatcherConfig.class);
		DispatcherServlet dispatcher = new DispatcherServlet(dispatcherContext);
 	
		ServletRegistration.Dynamic reg = ctx.addServlet("dispatcher", dispatcher);
		reg.setLoadOnStartup(1);
		reg.addMapping("/");
	}

}

