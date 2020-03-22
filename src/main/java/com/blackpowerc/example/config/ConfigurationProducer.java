package com.blackpowerc.example.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.IOException;
import java.util.Properties;

@ApplicationScoped
public class ConfigurationProducer
{
    private Properties p ;

    public ConfigurationProducer() throws IOException
    {
        p = new Properties() ;
        p.load(getClass().getResourceAsStream("/application.properties"));
    }

    private void checkAnnotation(final InjectionPoint ip) {
        if(!ip.getAnnotated().isAnnotationPresent(Config.class)) {
            throw new IllegalStateException("You cannot use the annotation @Configuration without the annotation @Config !") ;
        }
    }

    @Produces
    @Configuration
    private String stringProducer(InjectionPoint ip)
    {
        this.checkAnnotation(ip) ;

        Config annorationConfig =  ip.getAnnotated().getAnnotation(Config.class) ;
        final String ref = annorationConfig.ref() ;
        final String defaultValue = annorationConfig.defaultValue() ;

        return p.getProperty(ref, defaultValue) ;
    }

    @Produces
    @Configuration
    private int intProducer(InjectionPoint ip)
    {
        this.checkAnnotation(ip) ;

        Config annorationConfig =  ip.getAnnotated().getAnnotation(Config.class) ;
        final String ref = annorationConfig.ref() ;
        final String defaultValue = annorationConfig.defaultValue() ;

        return Integer.parseInt(p.getProperty(ref, defaultValue)) ;
    }
}
