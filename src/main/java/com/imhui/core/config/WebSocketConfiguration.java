package com.imhui.core.config;

import com.imhui.core.interceptor.WebSocketHandshakeInterceptor;
import com.imhui.mvc.socket.DemoSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * nginx need to be config
 * Upgrade: websocket
 * Connection: Upgrade
 *
 * proxy_set_header Upgrade $http_upgrade;
 * proxy_set_header Connection $connection_upgrade;
 */
@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(demoSocketHandler(), "/socket/demo")
                .setAllowedOrigins("*")
                .addInterceptors(webSocketHandshakeInterceptor());
    }

    @Bean
    public DemoSocketHandler demoSocketHandler() {
        return new DemoSocketHandler();
    }

    @Bean
    public WebSocketHandshakeInterceptor webSocketHandshakeInterceptor(){
        return new WebSocketHandshakeInterceptor();
    }

}