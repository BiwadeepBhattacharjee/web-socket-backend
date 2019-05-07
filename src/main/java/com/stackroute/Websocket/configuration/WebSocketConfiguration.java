package com.stackroute.Websocket.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer {
    //The below method defines the end point where the client has to register
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/socket")
                .setAllowedOrigins("*")
                .withSockJS()
                .setInterceptors(HttpSessionHandshakeInterceptor());
    }
    //The below mentioned code defines the destination prefix as "app" and it also defines 3 broker namely--user,topic,queue
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app")
                .enableSimpleBroker("/user/", "/topic/", "/queue/");
    }
    @Bean
    public HttpSessionHandshakeInterceptor HttpSessionHandshakeInterceptor(){
        return new HttpSessionHandshakeInterceptor();
    }
}
