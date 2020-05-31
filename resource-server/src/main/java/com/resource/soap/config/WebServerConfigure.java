package com.resource.soap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.servlet.Servlet;

@EnableWs
@Configuration
public class WebServerConfigure extends WsConfigurerAdapter {

    private final ApplicationContext applicationContext;

    @Autowired
    public WebServerConfigure(ApplicationContext applicationContext) {
        super();
        this.applicationContext = applicationContext;
    }

    @Bean
    public ServletRegistrationBean<? extends Servlet> messageDispatcherServlet(){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();

        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);

        return new ServletRegistrationBean<>(servlet, "/api/*");
    }

    @Bean
    public XsdSchema schema(){
        return new SimpleXsdSchema(new ClassPathResource("schema.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(){
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();

        defaultWsdl11Definition.setPortTypeName("UsersPort");
        defaultWsdl11Definition.setLocationUri("/api");
        defaultWsdl11Definition.setTargetNamespace("http://soap.training/schema/user-account-api");
        defaultWsdl11Definition.setSchema(schema());

        return defaultWsdl11Definition;
    }

}
