package com.alg.springwebreactive.reservation.service;

import com.alg.springwebreactive.reservation.domain.Reservation;
import com.alg.springwebreactive.reservation.domain.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final TransactionalOperator transactionalOperator;

	public Flux<Reservation> saveAll(String ... names) {
		Flux<Reservation> reservations = Flux
				.fromArray(names)
				.map(name -> new Reservation(null, name))
				.flatMap(this.reservationRepository::save)
				.doOnNext(this::assertValid);

		return this.transactionalOperator.transactional(reservations);
	}

	private void assertValid(Reservation reservation) {
		Assert.isTrue(reservation.getName() != null
		&& reservation.getName().length() > 0
		&& Character.isUpperCase(reservation.getName().charAt(0)),
				"El nombre de iniciar con una letra mayúscula");
	}
}
