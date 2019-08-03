package com.stackroute.muzix.config;

import org.apache.catalina.servlets.WebdavServlet;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
// @Configuration annotation indicates that a class declares one or more @Bean methods and may be processed by the
// Spring container to generate bean definitions and service requests for those beans at runtime.
public class WebConfiguration {
    @Bean
        // Spring @Bean Annotation is applied on a method to specify that it returns a bean to be managed by Spring context.
    ServletRegistrationBean servletRegistrationBean()
    {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
