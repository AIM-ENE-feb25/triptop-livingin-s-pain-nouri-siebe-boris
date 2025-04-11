package org.example.proto.Adapters;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.example.proto.Domain.Data;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AirbnbAdapter implements VerblijfAdapter {

    @Override
    public Data boekVerblijf(Data data) {
        String id = data.haalJsonNodeOp().findValue("id").asText();
        System.out.println(id);
        System.out.println(data.haalJsonNodeOp().toString());
        String checkinDate = data.haalJsonNodeOp().findValue("checkin").asText();
        String checkoutDate = data.haalJsonNodeOp().findValue("checkout").asText();

        System.out.println("Airbnb adapter: Verblijf met id " + id + " geüpdatet");
        System.out.println("Check-in datum: " + checkinDate);
        System.out.println("Check-out datum: " + checkoutDate);

        try {
            // Stuur de request naar de Airbnb API
            HttpResponse<String> response = Unirest.get("https://airbnb13.p.rapidapi.com/room?listing_id=" + id + "&checkin=" + checkinDate + "&checkout=" + checkoutDate + "&locale=en&currency=USD")
                    .header("x-rapidapi-key", "9dbe3ee3bamsh052139ccacb2791p11e045jsn88ed14469705")
                    .header("x-rapidapi-host", "airbnb13.p.rapidapi.com")
                    .asString();

            // Log de response body om te controleren wat we terug krijgen
            System.out.println("Response body: " + response.getBody());

            // Controleer of de API geen fouten heeft en er geldige resultaten zijn
            if (response.getBody().contains("error") && response.getBody().contains("source currently unavailable")) {
                System.out.println("API fout: De bron is momenteel niet beschikbaar.");
                return data;  // Retourneer de data zonder verdere verwerking
            }

            // Converteer de string response naar een Jackson JsonNode
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response.getBody());

            // Check of er een "results" node is en de prijs ophalen
            if (root.has("results")) {
                JsonNode resultsNode = root.get("results");

                if (resultsNode.has("price")) {
                    JsonNode priceNode = resultsNode.get("price");

                    // Haal de 'total' prijs uit de JSON en print deze
                    if (priceNode.has("total")) {
                        double totalPrice = priceNode.get("total").asDouble();
                        System.out.println("Total price: " + totalPrice);
                    } else {
                        System.out.println("Total price niet gevonden in de response.");
                    }
                } else {
                    System.out.println("Prijs informatie niet gevonden.");
                }
            } else {
                System.out.println("Geen resultaten gevonden in de response.");
            }

        } catch (Exception e) {
            System.out.println("Error tijdens ophalen Airbnb data: " + e.getMessage());
            e.printStackTrace();
        }

        return data;
    }
}
