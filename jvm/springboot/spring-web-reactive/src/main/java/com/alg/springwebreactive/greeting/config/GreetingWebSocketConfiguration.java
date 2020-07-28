package com.alg.springwebreactive.greeting.config;

import com.alg.springwebreactive.greeting.domain.GreetingRequest;
import com.alg.springwebreactive.greeting.domain.GreetingResponse;
import com.alg.springwebreactive.greeting.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Flux;

import java.util.Map;

@Configuration
public class GreetingWebSocketConfiguration {
	@Bean
	SimpleUrlHandlerMapping simpleUrlHandlerMapping(WebSocketHandler wsh) {
		return new SimpleUrlHandlerMapping(Map.of("/ws/greetings", wsh), 10);
	}

	@Bean
	WebSocketHandler webSocketHandler(GreetingService greetingService) {
		return session -> {
			Flux<WebSocketMessage> receive = session.receive();
			Flux<String> names = receive.map(WebSocketMessage::getPayloadAsText);
			Flux<GreetingRequest> requestFlux = names.map(GreetingRequest::new);
			Flux<GreetingResponse> greetingResponseFlux = requestFlux.flatMap(greetingService::greetMany);
			Flux<String> map = greetingResponseFlux.map(GreetingResponse::getMessage);
			Flux<WebSocketMessage> webSocketMessageFlux = map.map(session::textMessage);
			return session.send(webSocketMessageFlux);
		};
	}

	@Bean
	WebSocketHandlerAdapter webSocketHandlerAdapter() {
		return new WebSocketHandlerAdapter();
	}
}
