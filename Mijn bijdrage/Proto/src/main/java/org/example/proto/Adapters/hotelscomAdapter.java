package org.example.proto.Adapters;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.example.proto.Domain.Data;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class hotelscomAdapter implements VerblijfAdapter {

    @Override
    public Data updateVerblijf(Data data) {

        String propertyId = data.haalJsonNodeOp().findValue("id").asText();
        String checkinDate = data.haalJsonNodeOp().findValue("checkin").asText();
        String checkoutDate = data.haalJsonNodeOp().findValue("checkout").asText();

        System.out.println("Hotels.com adapter: Verblijf met propertyId " + propertyId + " geüpdatet");
        System.out.println("Check-in datum: " + checkinDate);
        System.out.println("Check-out datum: " + checkoutDate);

        try {
            HttpResponse<JsonNode> response = Unirest.get("https://hotels-com6.p.rapidapi.com/hotels/details-offers?propertyId=" + propertyId +
                            "&checkinDate=" + checkinDate + "&checkoutDate=" + checkoutDate)
                    .header("x-rapidapi-key", "9dbe3ee3bamsh052139ccacb2791p11e045jsn88ed14469705")
                    .header("x-rapidapi-host", "hotels-com6.p.rapidapi.com")
                    .asJson();

            JsonNode responseBody = response.getBody();
            com.fasterxml.jackson.databind.JsonNode root = new ObjectMapper().readTree(responseBody.toString());

            com.fasterxml.jackson.databind.JsonNode offerDetailsNode = root.path("offerDetails");
            if (!offerDetailsNode.isMissingNode()) {
                com.fasterxml.jackson.databind.JsonNode priceNode = offerDetailsNode.path("price");
                if (!priceNode.isMissingNode()) {
                    String formattedPrice = priceNode.path("formatted").asText(); // Haal de prijs op
                    System.out.println("Prijs voor verblijf: " + formattedPrice);
                } else {
                    System.out.println("Prijsinformatie niet gevonden.");
                }
            } else {
                System.out.println("Geen offerDetails gevonden.");
            }

        } catch (Exception e) {
            System.out.println("Error tijdens de API-aanroep naar Hotels.com: " + e);
        }

        return data;
    }


}

