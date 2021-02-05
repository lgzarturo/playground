package com.alg.springweb.flight.service;

import com.alg.springweb.flight.Flight;
import com.alg.springweb.flight.FlightRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
        throw new RuntimeException("I failed");
    }

    @Transactional
    public void saveFlightTransactional(Flight flight) {
        flightRepository.save(flight);
        throw new RuntimeException("I failed");
    }
}
