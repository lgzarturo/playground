package com.alg.springwebreactive.greeting.service;

import com.alg.springwebreactive.greeting.domain.GreetingRequest;
import com.alg.springwebreactive.greeting.domain.GreetingResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

@Service
public class GreetingService {

	public Flux<GreetingResponse> greetMany(GreetingRequest request) {
		return Flux
				.fromStream(Stream.generate(() -> greetOnce(request.getName())))
				.delayElements(Duration.ofSeconds(1))
				.subscribeOn(Schedulers.elastic());
	}

	public Mono<GreetingResponse> greetOnce(GreetingRequest request) {
		return Mono.just(greetOnce(request.getName()));
	}

	private GreetingResponse greetOnce(String name) {
		return new GreetingResponse("Hello " + name + " @ " + Instant.now());
	}
}
