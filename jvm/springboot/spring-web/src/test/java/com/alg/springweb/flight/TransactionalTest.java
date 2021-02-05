package com.alg.springweb.flight;

import com.alg.springweb.flight.service.FlightService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
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

    @Before
    public void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    public void shouldNotRollBackWhenTheresNoTransaction() {
        try {
            flightService.saveFlight(new Flight());
        } catch (Exception e) {
            // Do nothing
        } finally {
            Assertions.assertThat(flightRepository.findAll()).isNotEmpty();
        }
    }

    @Test
    public void shouldNotRollBackWhenTheresIsATransaction() {
        try {
            flightService.saveFlightTransactional(new Flight());
        } catch (Exception e) {
            // Do nothing
        } finally {
            Assertions.assertThat(flightRepository.findAll()).isEmpty();
        }
    }
}
