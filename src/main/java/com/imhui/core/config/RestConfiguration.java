package com.imhui.core.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: zyixh
 * @date: 2020/5/23
 * @description:
 */
@Configuration
public class RestConfiguration {

//    private final Logger logger = LoggerFactory.getLogger(RestConfiguration.class);

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory requestFactory){
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return true;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });
        List<HttpMessageConverter<?>> messageConverterList = restTemplate.getMessageConverters();
        List<ClientHttpRequestInterceptor> clientHttpRequestInterceptorList = new ArrayList();
        clientHttpRequestInterceptorList.add(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
                System.out.println("start interceptor");
                return execution.execute(request, body);
            }
        });
        restTemplate.setInterceptors(clientHttpRequestInterceptorList);
        return restTemplate;
    }

    public RestTemplate okHttp3restTemplate(OkHttp3ClientHttpRequestFactory requestFactory){
        return new RestTemplate(requestFactory);
    }

    public SimpleClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(15000);
        factory.setProxy(null);
        return factory;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory requestFactory() {
        PoolingHttpClientConnectionManager connectionManager =
                new PoolingHttpClientConnectionManager(30, TimeUnit.SECONDS);
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(20);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .evictIdleConnections(30, TimeUnit.SECONDS)
                .disableAutomaticRetries()
                // 有 Keep-Alive 认里面的值，没有的话永久有效
                //.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                // 换成自定义的
                .setKeepAliveStrategy(new CustomConnectionKeepAliveStrategy())
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory(httpClient);

        return requestFactory;
    }
}
