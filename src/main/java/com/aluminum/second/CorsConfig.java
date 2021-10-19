package com.aluminum.second;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
     @Override
    public void addCorsMappings (CorsRegistry registry) {
//        String[] allowOrigins ={"http://localhost:8080/","https://www.quyo.fun/"};
        //允許所有形式的跨域請求
        registry.addMapping ("/**")
                .allowedOriginPatterns ("*")
                .allowCredentials (true)
                .allowedMethods ("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .maxAge (3600);
    }


    private CorsConfiguration buildConfig () {
        CorsConfiguration corsConfiguration = new CorsConfiguration ();
        List<String> list = new ArrayList<>();
        list.add ("*");
        corsConfiguration.setAllowedOrigins (list);
        corsConfiguration.addAllowedOrigin ("*");
        corsConfiguration.addAllowedHeader ("*");
        corsConfiguration.addAllowedMethod ("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter () {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource ();
        source.registerCorsConfiguration ("/**", buildConfig ());
        return new CorsFilter (source);
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }
}
