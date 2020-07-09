package com.alg.springwebreactive.reservation.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ReservationRepository extends ReactiveCrudRepository<Reservation, Integer> {
	Flux<Reservation> findByName(String name);
}
