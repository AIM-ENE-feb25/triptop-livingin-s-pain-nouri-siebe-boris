package org.example.proto.Services;

import com.fasterxml.jackson.databind.JsonNode;
import org.example.proto.Domain.*;
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
        Status status = Status.GEPLAND;
        List<BouwSteen> bouwSteenList = new ArrayList<>();


        for (Reiziger reiziger : aanvraag.reizigers()) {
            Reiziger nieuwReiziger = new Reiziger(reiziger.getVoornaam(), reiziger.getAchternaam(), reiziger.getGeboortedatum());
            trip.voegReizigerToe(nieuwReiziger);
        }

        for (Map.Entry<String, List<JsonNode>> entry : aanvraag.bouwstenen().entrySet()) {
            String categorie = entry.getKey();
            List<JsonNode> bouwsteenList = entry.getValue();

            for (JsonNode jsonNode : bouwsteenList) {
                String provider = jsonNode.has("provider") ? jsonNode.get("provider").asText() : "";
                JsonNode dataNode = jsonNode.has("data") ? jsonNode.get("data") : null;

                if (dataNode != null && dataNode.isArray()) {
                    for (JsonNode dataItem : dataNode) {
                        bouwSteenList.add(new BouwSteen(status, categorie, provider, dataItem));
                    }
                }
            }
        }
        trip.setBouwStenen(bouwSteenList);
        tripRepository.save(trip);
        return trip;
    }


    public void boekTrip(String tripId) {
        Optional<Trip> optionalTrip = tripRepository.findById(tripId);
        if (optionalTrip.isPresent()) {
            Trip trip = optionalTrip.get();
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
