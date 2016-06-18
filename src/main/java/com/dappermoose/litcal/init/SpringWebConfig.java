package com.dappermoose.litcal.init;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.context.support.ResourceBundleThemeSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringWebConfig.
 */
@ComponentScan (basePackages = { "com.dappermoose.litcal.formbean",
        "com.dappermoose.litcal.action",
        "com.dappermoose.litcal.init" })
@Configuration
public class SpringWebConfig extends WebMvcConfigurerAdapter
{
    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
     * #configureDefaultServletHandling(org.springframework.web.servlet.config.
     * annotation.DefaultServletHandlerConfigurer)
     */
    @Override
    public void configureDefaultServletHandling (
            final DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable ();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
     * #addResourceHandlers(org.springframework.web.servlet.config.annotation.
     * ResourceHandlerRegistry)
     */
    @Override
    public void addResourceHandlers (final ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler ("/css/**").addResourceLocations ("/css/");
        registry.addResourceHandler ("/images/**").addResourceLocations (
                "/images/");
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
     * #addInterceptors(org.springframework.web.servlet.config.annotation.
     * InterceptorRegistry)
     */
    @Override
    public void addInterceptors (final InterceptorRegistry registry)
    {
        registry.addInterceptor (new LocaleChangeInterceptor ());
        registry.addInterceptor (new ThemeChangeInterceptor ());
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
    public void addViewControllers (final ViewControllerRegistry registry)
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

    // beans for themes
    /**
     * Resource bundle theme source.
     *
     * @return the resource bundle theme source
     */
    @Bean
    ResourceBundleThemeSource themeSource ()
    {
        final ResourceBundleThemeSource themeSource = new ResourceBundleThemeSource ();
        themeSource.setBasenamePrefix ("themes.");
        return themeSource;
    }

    /**
     * Cookie theme resolver.
     *
     * @return the cookie theme resolver
     */
    @Bean
    CookieThemeResolver themeResolver ()
    {
        final CookieThemeResolver resolver = new CookieThemeResolver ();
        resolver.setDefaultThemeName ("blue");
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
}
