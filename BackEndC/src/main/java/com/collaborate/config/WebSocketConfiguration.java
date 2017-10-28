package com.collaborate.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker   //enable broker based stomp messaging - Autodecting annotation @MessageMapping
@ComponentScan(basePackages="com.collaborate")
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{

	public void configureClientInboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	public void configureClientOutboundChannel(ChannelRegistration arg0) {
		// TODO Auto-generated method stub
		
	}

	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/queue/","/topic/"); //server to broker to client
		//destinationPrefixes path ="/app"
		//queue is for chat message
		// topic is for newly joined user....
		registry.setApplicationDestinationPrefixes("/app"); //from client to server...
		
	}

	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/portfolio").withSockJS();    //to connect with webSocet
		
	}

}