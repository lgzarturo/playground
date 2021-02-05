package com.alg.springweb.flight;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
class FlightCrudTest {
    @Autowired
    private FlightRepository flightRepository;

    @Before
    private void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    void verifyFlightOperations() {
        final Flight flight = createFlight("Cancún", "México");
        flightRepository.save(flight);
        Assertions.assertThat(flightRepository.findAll()).hasSize(1).first().isEqualToComparingFieldByField(flight);
        flightRepository.deleteById(flight.getId());
        Assertions.assertThat(flightRepository.count()).isZero();
    }

    @Test
    public void shouldFindFlightsFromLondon() {
        final Flight flight1 = createFlight("London");
        final Flight flight2 = createFlight("London");
        final Flight flight3 = createFlight("New York");
        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> flightsToLondon = flightRepository.findByOrigin("London");
        Assertions.assertThat(flightsToLondon).hasSize(2);
        Assertions.assertThat(flightsToLondon.get(0)).isEqualToComparingFieldByField(flight1);
        Assertions.assertThat(flightsToLondon.get(1)).isEqualToComparingFieldByField(flight2);
    }

    @Test
    public void shouldFindFlightsFromLondonToParis() {
        final Flight flight1 = createFlight("London", "Paris");
        final Flight flight2 = createFlight("London", "New York");
        final Flight flight3 = createFlight("New York", "Paris");
        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> flightsToLondon = flightRepository.findByOriginAndDestination("London", "Paris");
        Assertions.assertThat(flightsToLondon).hasSize(1);
        Assertions.assertThat(flightsToLondon.get(0)).isEqualToComparingFieldByField(flight1);
    }

    @Test
    public void shouldFindFlightsFromLondonOrMadrid() {
        final Flight flight1 = createFlight("London", "New York");
        final Flight flight2 = createFlight("Tokio", "New York");
        final Flight flight3 = createFlight("Madrid", "Paris");
        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> flightsToLondon = flightRepository.findByOriginIn("London", "Madrid");
        Assertions.assertThat(flightsToLondon).hasSize(2);
        Assertions.assertThat(flightsToLondon.get(0)).isEqualToComparingFieldByField(flight1);
        Assertions.assertThat(flightsToLondon.get(1)).isEqualToComparingFieldByField(flight3);
    }

    @Test
    public void shouldFindFlightsFromLondonIgnoringCase() {
        final Flight flight = createFlight("LONDON");
        flightRepository.save(flight);

        final List<Flight> flightsToLondon = flightRepository.findByOriginIgnoreCase("London");
        Assertions.assertThat(flightsToLondon).hasSize(1);
        Assertions.assertThat(flightsToLondon.get(0)).isEqualToComparingFieldByField(flight);
    }

    @Test
    public void shouldSortFlightsByDestination() {
        final Flight madrid = createFlightWithDestination("Madrid");
        final Flight london = createFlightWithDestination("London");
        final Flight paris = createFlightWithDestination("Paris");
        flightRepository.save(madrid);
        flightRepository.save(london);
        flightRepository.save(paris);

        final Iterable<Flight> flights = flightRepository.findAll(Sort.by("destination"));
        Assertions.assertThat(flights).hasSize(3);
        final Iterator<Flight> iterator = flights.iterator();
        Assertions.assertThat(iterator.next().getDestination()).isEqualTo("London");
        Assertions.assertThat(iterator.next().getDestination()).isEqualTo("Madrid");
        Assertions.assertThat(iterator.next().getDestination()).isEqualTo("Paris");
    }

    @Test
    public void shouldSortFlightsByScheduleAndThenName() {
        final LocalDateTime now = LocalDateTime.now();
        final Flight paris1 = createFlight("Paris", now);
        final Flight paris2 = createFlight("Paris", now.plusHours(2));
        final Flight paris3 = createFlight("Paris", now.minusHours(1));
        final Flight london1 = createFlight("London", now.plusHours(1));
        final Flight london2 = createFlight("London", now);
        flightRepository.save(paris1);
        flightRepository.save(paris2);
        flightRepository.save(paris3);
        flightRepository.save(london1);
        flightRepository.save(london2);

        final Iterable<Flight> flights = flightRepository.findAll(Sort.by("destination", "scheduleAt"));
        Assertions.assertThat(flights).hasSize(5);
        final Iterator<Flight> iterator = flights.iterator();
        Assertions.assertThat(iterator.next()).isEqualToComparingFieldByField(london2);
        Assertions.assertThat(iterator.next()).isEqualToComparingFieldByField(london1);
        Assertions.assertThat(iterator.next()).isEqualToComparingFieldByField(paris3);
        Assertions.assertThat(iterator.next()).isEqualToComparingFieldByField(paris1);
        Assertions.assertThat(iterator.next()).isEqualToComparingFieldByField(paris2);
    }

    @Test
    public void shouldPageResults() {
        for (int i = 0; i < 50; i++) {
            flightRepository.save(createFlight(String.valueOf(i)));
        }
        final Page<Flight> page = flightRepository.findAll(PageRequest.of(2, 5));
        Assertions.assertThat(page.getTotalElements()).isEqualTo(50);
        Assertions.assertThat(page.getNumberOfElements()).isEqualTo(5);
        Assertions.assertThat(page.getTotalPages()).isEqualTo(10);
        Assertions.assertThat(page.getContent())
                .extracting(Flight::getOrigin)
                .containsExactly("10", "11", "12", "13", "14");
    }

    @Test
    public void shouldPageAndSortResults() {
        for (int i = 0; i < 50; i++) {
            flightRepository.save(createFlight(String.valueOf(i)));
        }
        final Page<Flight> page = flightRepository.findAll(PageRequest.of(2, 5, Sort.by(Sort.Direction.DESC, "origin")));
        Assertions.assertThat(page.getTotalElements()).isEqualTo(50);
        Assertions.assertThat(page.getNumberOfElements()).isEqualTo(5);
        Assertions.assertThat(page.getTotalPages()).isEqualTo(10);
        Assertions.assertThat(page.getContent())
                .extracting(Flight::getOrigin)
                .containsExactly("44", "43", "42", "41", "40");
    }

    @Test
    public void shouldPageAndSortADeriveQueryResults() {
        for (int i = 0; i < 10; i++) {
            final Flight flight = createFlightWithDestination(String.valueOf(i));
            flight.setOrigin("Paris");
            flightRepository.save(flight);
        }
        for (int i = 0; i < 10; i++) {
            final Flight flight = createFlightWithDestination(String.valueOf(i));
            flight.setOrigin("London");
            flightRepository.save(flight);
        }
        final Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "destination"));
        final Page<Flight> page = flightRepository.findByOrigin("London", pageable);
        Assertions.assertThat(page.getTotalElements()).isEqualTo(10);
        Assertions.assertThat(page.getNumberOfElements()).isEqualTo(5);
        Assertions.assertThat(page.getTotalPages()).isEqualTo(2);
        Assertions.assertThat(page.getContent())
                .extracting(Flight::getDestination)
                .containsExactly("9", "8", "7", "6", "5");
    }

    private Flight createFlight(String origin, String destination) {
        final Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setScheduleAt(LocalDateTime.parse("2021-01-01T12:12:00"));
        return flight;
    }

    private Flight createFlight(String destination, LocalDateTime scheduleAt) {
        final Flight flight = new Flight();
        flight.setOrigin("México");
        flight.setDestination(destination);
        flight.setScheduleAt(scheduleAt);
        return flight;
    }

    private Flight createFlight(String origin) {
        return createFlight(origin, "México");
    }

    private Flight createFlightWithDestination(String destination) {
        return createFlight("México", destination);
    }
}
