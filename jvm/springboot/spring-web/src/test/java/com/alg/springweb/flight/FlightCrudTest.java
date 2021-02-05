package com.alg.springweb.flight;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
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
        final Flight flight1 = createFlight("London", "México");
        final Flight flight2 = createFlight("London", "México");
        final Flight flight3 = createFlight("New York", "México");
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

    private Flight createFlight(String origin, String destination) {
        final Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setScheduleAt(LocalDateTime.parse("2021-01-01T12:12:00"));
        return flight;
    }

    private Flight createFlight(String origin) {
        return createFlight(origin, "México");
    }
}
