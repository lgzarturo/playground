package com.alg.springwebreactive.reservation.data;

import com.alg.springwebreactive.reservation.domain.Reservation;
import com.alg.springwebreactive.reservation.domain.ReservationRepository;
import com.alg.springwebreactive.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
@Log4j2
public class ReservationDataInitializer {

	private final ReservationRepository reservationRepository;
	private final ReservationService reservationService;
	private final DatabaseClient databaseClient;

	@EventListener(ApplicationReadyEvent.class)
	public void ready() {
		log.info("Aplicación lista");

		Flux<Reservation> reservations = reservationService.saveAll(
				"Arturo", "Juan", "Karla", "Michele", "Karina"
		);

		this.reservationRepository
				.deleteAll()
				.thenMany(reservations)
				.thenMany(this.reservationRepository.findAll())
				.subscribe(log::info);

		this.databaseClient
				.select()
				.from("reservation")
				.as(Reservation.class)
				.fetch()
				.all()
				.doOnComplete(() -> {log.info("---------------------");})
				.subscribe(log::info);
	}
}
