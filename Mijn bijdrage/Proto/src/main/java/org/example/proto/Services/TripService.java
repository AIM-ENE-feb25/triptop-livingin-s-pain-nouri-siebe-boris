package org.example.proto.Services;

import com.fasterxml.jackson.databind.JsonNode;
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
    @Qualifier("hotelscomAdapter")
    private VerblijfAdapter hotelscomAdapter;

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
        // Maak een mock van de data die je zou ontvangen (deze kan vervangen worden door echte data)
        Data mockData = new Data("{\n" +
                "  \"gebruikersnaam\": \"JJ\",\n" +
                "  \"reizigers\": [\n" +
                "    {\n" +
                "      \"voornaam\": \"Jan\",\n" +
                "      \"achternaam\": \"Jansen\",\n" +
                "      \"geboortedatum\": \"1985-06-15\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"voornaam\": \"Piet\",\n" +
                "      \"achternaam\": \"Pietersen\",\n" +
                "      \"geboortedatum\": \"1990-11-25\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"bouwstenen\": {\n" +
                "    \"accommodatie\": [\n" +
                "      {\n" +
                "        \"provider\": \"bookingcom\",\n" +
                "        \"data\": [\n" +
                "          {\n" +
                "            \"hotel\": \"Grand Hotel\",\n" +
                "            \"id\": 340569,\n" +
                "            \"adres\": \"123 Hotelstraat, Amsterdam\",\n" +
                "            \"aantalNachten\": 3,\n" +
                "            \"checkin\": \"2025-05-01\",\n" +
                "            \"checkout\": \"2025-05-05\"\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"provider\": \"hotelscom\",\n" +
                "        \"data\": [\n" +
                "          {\n" +
                "            \"hotel\": \"Cozy Loft\",\n" +
                "            \"id\": \"2621_17117062\",\n" +
                "            \"adres\": \"789 Grachtenstraat, Utrecht\",\n" +
                "            \"aantalNachten\": 4, \n" +
                "            \"checkin\": \"2025-05-01\",\n" +
                "            \"checkout\": \"2025-05-05\"\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}");

        JsonNode bouwstenen = mockData.haalJsonNodeOp().path("bouwstenen").path("accommodatie");

        for (JsonNode bouwSteen : bouwstenen) {
            String provider = bouwSteen.path("provider").asText();

            switch (provider) {
                case "bookingcom":
                    JsonNode bookingComData = bouwSteen.path("data");
                    Data bookingComDataObject = new Data(bookingComData.toString());
                    bookingcomAdapter.updateVerblijf(bookingComDataObject);
                    break;

                case "hotelscom":
                    JsonNode hotelComData = bouwSteen.path("data");
                    Data hotelComDataObject = new Data(hotelComData.toString());
                    hotelscomAdapter.updateVerblijf(hotelComDataObject);
                    break;

            }
        }


        return new Trip();
    }

}
