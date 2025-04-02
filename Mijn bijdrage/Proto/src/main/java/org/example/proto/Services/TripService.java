package org.example.proto.Services;

import org.example.proto.Adapters.VerblijfAdapter;
import org.example.proto.Domain.BouwSteen;
import org.example.proto.Domain.Data;
import org.example.proto.Domain.Reiziger;
import org.example.proto.Domain.Trip;
import org.example.proto.Repo.TripRepository;
import org.example.proto.Request.TripRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TripService {
    private final TripRepository tripRepository;

    @Autowired
    @Qualifier("airbnbAdapter")
    private VerblijfAdapter airbnbAdapter;

    @Autowired
    @Qualifier("bookingcomAdapter")
    private VerblijfAdapter bookingcomAdapter;

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

    public Trip bekijkTrip(String tripId) {
        return updateTrip(Integer.parseInt(tripId));
    }

    public Trip updateTrip(int tripid) {
//        Trip trip = tripRepository.findById(String.valueOf(tripid)).get();
//        List<BouwSteen> bouwStenen = trip.getBouwStenen();
//        for (BouwSteen bouwSteen : bouwStenen) {
//            Data data = bouwSteen.getData();
//                switch (data.haalJsonNodeOp().findValues("provider").get(0).asText()) {
//                    case "airbnb":
//                        bouwSteen.setData(airbnbAdapter.updateVerblijf(bouwSteen.getData()));
//                        break;
//                    case "bookingcom":
//                        bouwSteen.setData(bookingcomAdapter.updateVerblijf(bouwSteen.getData()));
//                        break;
//                }
//            }
//        return null;

        Data mockData = new Data("{\"id\": 123 }");
        bookingcomAdapter.updateVerblijf(mockData, 2);
       return new Trip();
    }
}
