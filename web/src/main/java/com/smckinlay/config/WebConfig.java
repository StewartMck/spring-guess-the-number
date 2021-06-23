package com.smckinlay.config;

import com.smckinlay.interceptor.RequestInterceptor;
import com.smckinlay.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // == bean methods ==
    @Bean
    public LocaleResolver localeResolver() {
        return new SessionLocaleResolver();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor());

        // this is for customizing the locale param: http://localhost:8080/?lang=es will display in spanish
//        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//        localeChangeInterceptor.setParamName("lang");
//        registry.addInterceptor(localeChangeInterceptor);

        // this uses the default implementation - locale
        registry.addInterceptor(new LocaleChangeInterceptor());
    }
}
