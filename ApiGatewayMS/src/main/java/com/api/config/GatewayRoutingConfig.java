package com.api.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutingConfig 
{
	@Bean
	public RouteLocator configureRoute(RouteLocatorBuilder builder)
	{
		
//		Static Route
//		return builder.routes()
//				.route("UserId", r -> r.path("/user/v1/**").uri("http://localhost:8081"))
//				.route("NoteId", r -> r.path("/api/v1/**").uri("http://localhost:8082"))
//				.build();
		
//		Dynamic Route
		return builder.routes()
				.route("UserId", r -> r.path("/user/v1/**").uri("http://localhost:8081"))
				.route("NoteId", r -> r.path("/api/v1/**").uri("lb://note-service"))
				.build();
	}
}