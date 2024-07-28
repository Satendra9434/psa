package com.example.controller;


import com.example.entity.BusStop;
import com.example.entity.Stop;
import com.example.repository.BusStopRepository;
import com.example.repository.StopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stops")
public class StopController {

    private StopRepository stopRepository;
    private BusStopRepository busStopRepository;

    public StopController(StopRepository stopRepository, BusStopRepository busStopRepository) {
        this.stopRepository = stopRepository;
        this.busStopRepository = busStopRepository;
    }
    @PostMapping("/creates")
    public ResponseEntity<Stop> createBusStop(@RequestBody Stop stop){
        Stop savePost = stopRepository.save(stop);
        return new ResponseEntity<>(savePost, HttpStatus.CREATED);
    }
}
