package com.alg.springweb.flight;

import com.alg.springweb.flight.service.FlightService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionalTest {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightService flightService;

    @Test
    public void shouldNotRollBackWhenTheresIsATransaction() {
        flightRepository.deleteAll();
        try {
            flightService.saveFlightTransactional(new Flight());
        } catch (Exception e) {
            // Do nothing
        } finally {
            Assertions.assertThat(flightRepository.findAll()).isEmpty();
        }
    }

    @Test
    public void shouldNotRollBackWhenTheresNoTransaction() {
        flightRepository.deleteAll();
        try {
            flightService.saveFlight(new Flight());
        } catch (Exception e) {
            // Do nothing
        } finally {
            Assertions.assertThat(flightRepository.findAll()).isNotEmpty();
        }
    }
}
