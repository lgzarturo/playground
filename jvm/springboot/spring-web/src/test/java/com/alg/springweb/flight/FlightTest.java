package com.alg.springweb.flight;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
class FlightTest {
    @Autowired
    private EntityManager entityManager;

    @Test
    void verifyFlightCanBeSave() {
        final Flight flight = new Flight();
        flight.setOrigin("Cancún");
        flight.setDestination("México");
        flight.setScheduleAt(LocalDateTime.parse("2021-01-01T12:12:00"));
        entityManager.persist(flight);
        final TypedQuery<Flight> results = entityManager.createQuery("SELECT f FROM Flight f", Flight.class);
        final List<Flight> resultList = results.getResultList();
        Assertions.assertThat(resultList).hasSize(1).first().isEqualTo(flight);
    }
}
