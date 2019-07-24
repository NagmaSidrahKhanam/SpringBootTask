package com.stackroute.muzix.config;

import com.stackroute.muzix.exceptions.UserAlreadyExistsException;
import com.stackroute.muzix.model.User;
import com.stackroute.muzix.service.UserService;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.sound.midi.Track;

@Configuration
@Component
public class WebConfiguration {
    private final
    UserService userService;
@Autowired
    public WebConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Bean
    ServletRegistrationBean servletRegistrationBean()
    {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent cfr) {
        try {
            userService.saveUser(new User(1,"Summer","Calvin Harris",23));
            userService.saveUser(new User(2,"Love me like","Olivia",34));
            System.out.println("Context Refreshed");
        } catch (UserAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/console/*");
        return servletRegistrationBean;

    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.stackroute.muzix.controllers"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }
}
