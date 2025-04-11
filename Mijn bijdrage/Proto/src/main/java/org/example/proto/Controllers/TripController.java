package org.example.proto.Controllers;

import org.example.proto.Domain.Trip;
import org.example.proto.Request.TripRequest;
import org.example.proto.Services.TripService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
public class TripController {
    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/maak")
    public Trip maakTrip(@RequestBody TripRequest aanvraag) {
        return tripService.maakTrip(aanvraag);
    }

    @PostMapping("/boek/{tripId}")
    public Trip boekTrip(@PathVariable String tripId) {
        return tripService.boekTrip(tripId);
    }

    @PutMapping("/wijzig/{tripId}")
    public void wijzigTrip(@PathVariable String tripId) {
        tripService.wijzigTrip(tripId);
    }

    @DeleteMapping("/verwijder/{tripId}")
    public void verwijderTrip(@PathVariable String tripId) {
        tripService.verwijderTrip(tripId);
    }

    @GetMapping("/bekijk/{tripId}")
    public Trip bekijkTrip(@PathVariable String tripId) {
        return null;
    }
}
