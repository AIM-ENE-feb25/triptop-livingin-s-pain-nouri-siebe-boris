package org.example.proto.Services;

import org.example.proto.Domain.BouwSteen;
import org.example.proto.Domain.Data;
import org.example.proto.Domain.Reiziger;
import org.example.proto.Domain.Trip;
import org.example.proto.Repo.TripRepository;
import org.example.proto.Request.TripRequest;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TripService {
    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip maakTrip(TripRequest aanvraag) {
        Trip trip = new Trip();

        for (Reiziger reiziger : aanvraag.reizigers()) {
            trip.voegReizigerToe(reiziger);
        }

        for (Data data : aanvraag.data()) {
            BouwSteen bouwSteen = new BouwSteen();
            bouwSteen.voegDataToe(data);
            trip.voegBouwSteenToe(bouwSteen);
        }

        return tripRepository.save(trip);
    }



    public void boekTrip(String tripId) {
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        if (optionalTrip.isPresent()) {
            Trip trip = optionalTrip.get();
            // Boekingslogica hier
            tripRepository.save(trip);
        }
    }

    public void wijzigTrip(String tripId) {
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        if (optionalTrip.isPresent()) {
            Trip trip = optionalTrip.get();
            tripRepository.save(trip);
        }
    }

    public void verwijderTrip(String tripId) {
        tripRepository.deleteById(tripId);
    }
}
