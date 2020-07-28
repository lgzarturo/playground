package com.alg.springwebreactive.greeting.controller;

import com.alg.springwebreactive.greeting.domain.GreetingRequest;
import com.alg.springwebreactive.greeting.domain.GreetingResponse;
import com.alg.springwebreactive.greeting.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class GreetingRestController {
	private final GreetingService greetingService;

	@GetMapping("/greetings/{name}")
	Mono<GreetingResponse> greet(@PathVariable String name) {
		return this.greetingService.greetOnce(new GreetingRequest(name));
	}
}
