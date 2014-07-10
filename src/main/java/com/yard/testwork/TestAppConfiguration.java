package com.yard.testwork;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yard.testwork.utils.ObjectMapperHolder;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.yard.testwork.controller","com.yard.testwork.dao.impl","com.yard.testwork.service"})
@PropertySource({"classpath:application.properties"})
@EnableWebMvc
public class TestAppConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        super.configureDefaultServletHandling(configurer);
        configurer.enable();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter());
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectMapperHolder.set(mapper);
        return mapper;
    }

    @Bean
    static public PropertySourcesPlaceholderConfigurer
                                propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer
                propertySourcesPlaceholderConfigurer =
                        new PropertySourcesPlaceholderConfigurer();
        return  propertySourcesPlaceholderConfigurer;
    }
}