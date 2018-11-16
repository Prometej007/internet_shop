package com.web.edu.internetshop.config;


import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static java.util.Optional.ofNullable;

/**
 * Created by danul on 27.04.2017.
 */


@Configuration
public class ApplicationWebMvcConfig extends WebMvcConfigurerAdapter {

    public static final String FILE_HOME="FILE_HOME";
    private static final String rootPath = System.getProperty("catalina.home");
    private static final String filePath = System.getenv(FILE_HOME);

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {

        final FilterRegistrationBean resolver = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        resolver.setFilter(characterEncodingFilter);
        return resolver;
    }


    private String mod(String str) {
        if(!ofNullable(str).isPresent())
            return "C:\\file.home/";
        if (!(str.charAt(str.length() - 1) == '\\' || str.charAt(str.length() - 1) == '/'))
            return str+"/";
        else
            return str;
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:///" + mod(filePath));
//                .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
//                .resourceChain(false)
//                .addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
    }


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .defaultContentType(MediaType.APPLICATION_JSON)
                .favorPathExtension(true);
    }

    @Bean
    public EmbeddedServletContainerCustomizer tomcatCustomizer() {
        return (container) -> {
            if (container instanceof TomcatEmbeddedServletContainerFactory) {
                ((TomcatEmbeddedServletContainerFactory) container)
                        .addConnectorCustomizers((connector) -> {
                            connector.addUpgradeProtocol(new Http2Protocol());
                        });
            }
        };
    }

}
