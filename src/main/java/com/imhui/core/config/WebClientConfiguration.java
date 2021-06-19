package com.imhui.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author: zyixh
 * @date:   2021/5/28
 * @description:
 */
@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
