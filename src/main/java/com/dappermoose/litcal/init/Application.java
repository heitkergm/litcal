package com.dappermoose.litcal.init;

import java.util.Arrays;
import java.util.TimeZone;

import org.apache.catalina.Context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * This is the class containing the main program for spring boot.
 */
@SpringBootApplication
@EnableRedisHttpSession
@ServletComponentScan
public class Application
{
    /**
     * This is the main program for spring boot.
     *
     * @param args the command line arguments
     *
     */
    public static void main (final String[] args)
    {
        TimeZone.setDefault (TimeZone.getTimeZone ("UTC"));

        ApplicationContext ctx = SpringApplication.run (Application.class, args);

        System.out.println ("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames ();
        Arrays.sort (beanNames);
        for (String beanName : beanNames)
        {
            System.out.println (beanName);
        }
    }
    
    /**
     * This sets up the embedded tomcat server.
     *
     * @return the customized embedded tomcat server
     */
    @Bean
    public EmbeddedServletContainerFactory servletContainer ()
    {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory ()
        {
            @Override
            protected void postProcessContext (final Context context)
            {
            }
        };
               
        return tomcat;
    }
}

