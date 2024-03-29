package com.dappermoose.litcal.init;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringWebConfig.
 */
@ComponentScan (basePackages = { "com.dappermoose.litcal.formbean",
                                 "com.dappermoose.litcal.days",
                                 "com.dappermoose.litcal.action",
                                 "com.dappermoose.litcal.init" })
@Configuration
public class SpringWebConfig implements WebMvcConfigurer
{
    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
     * #addInterceptors(org.springframework.web.servlet.config.annotation.
     * InterceptorRegistry)
     */
    @Override
    public void addInterceptors (final @NonNull InterceptorRegistry registry)
    {
        registry.addInterceptor (new LocaleChangeInterceptor ());
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
     * #addViewControllers(org.springframework.web.servlet.config.annotation.
     * ViewControllerRegistry)
     */
    @Override
    public void addViewControllers (final @NonNull ViewControllerRegistry registry)
    {
        registry.addRedirectViewController ("/", "/main");
    }

    // beans for i18n
    /**
     * Message source.
     *
     * @return the message source
     */
    @Bean
    MessageSource messageSource ()
    {
        final ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource ();
        source.setCacheSeconds (60);
        source.setBasenames ("classpath:messages",
                "classpath:ValidationMessages");
        return source;
    }

    /**
     * Cookie locale resolver.
     *
     * @return the cookie locale resolver
     */
    @Bean
    CookieLocaleResolver localeResolver ()
    {
        final CookieLocaleResolver resolver = new CookieLocaleResolver ();
        return resolver;
    }

    /**
     * Bean for calendar data.
     *
     * <p>Make the bean containing the "database" of calendar dates.</p>
     *
     * @return the bean
     *
     */
    @Bean (name = "CalendarData")
    public String calendarData ()
    {
        return "CalendarData";
    }

    /**
     * bean for thymeleaf layout dialect 3.
     *
     * @return the layout Dialect
     */
    @Bean
    public LayoutDialect layoutDialect ()
    {
        return new LayoutDialect ();
    }
}
