package com.alg.springwebreactive;

import com.alg.springwebreactive.greeting.domain.GreetingRequest;
import com.alg.springwebreactive.greeting.domain.GreetingResponse;
import com.alg.springwebreactive.greeting.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication
@EnableTransactionManagement
public class SpringWebReactiveApplication {

	final GreetingService greetingService;

	public SpringWebReactiveApplication(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	@Bean
	RouterFunction<ServerResponse> routes(GreetingService gs) {
		return route()
				.GET("/greeting/{name}", r -> ok().body(gs.greetOnce(new GreetingRequest(r.pathVariable("name"))), GreetingResponse.class))
				.GET("/greetingsMany/{name}", this::handleGreetingsMany)
				.build();
	}

	Mono<ServerResponse> handleGreetingsMany(ServerRequest r) {
		return ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(greetingService.greetMany(new GreetingRequest(r.pathVariable("name"))), GreetingResponse.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringWebReactiveApplication.class, args);
	}

}
