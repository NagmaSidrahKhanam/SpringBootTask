package com.stackroute.muzixassignment.config;

import com.stackroute.muzixassignment.service.TrackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//Spring @Configuration annotation helps in Spring annotation based configuration.
// @Configuration annotation indicates that a class declares one or more @Bean methods and may be processed by the
// Spring container to generate bean definitions and service requests for those beans at runtime.
public class WebConfiguration {

    TrackService trackService;


    public WebConfiguration(TrackService trackService) {
        this.trackService = trackService;
    }


//    @Bean
//    ServletRegistrationBean h2servletRegistration()
//    {
//        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new WebServlet());
//        registrationBean.addUrlMappings("/console/*");
//        return registrationBean;
//    }
}

