package com.websokect.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.websokect.demo.UserHandshakeHandler;

@Configuration
@EnableWebSocketMessageBroker
public class WebSokectConfig implements WebSocketMessageBrokerConfigurer{

	@Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
    	registry.enableSimpleBroker("/topic");
    	registry.setApplicationDestinationPrefixes("/ws");
    }
	
	@Override
	public void registerStompEndpoints(final StompEndpointRegistry registry) {
		registry.addEndpoint("/our-websocket").setHandshakeHandler(new UserHandshakeHandler()).withSockJS();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
