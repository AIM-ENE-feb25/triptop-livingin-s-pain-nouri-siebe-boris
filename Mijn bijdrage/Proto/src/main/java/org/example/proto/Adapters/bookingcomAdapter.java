package org.example.proto.Adapters;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.example.proto.Domain.Data;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class bookingcomAdapter implements VerblijfAdapter {

    @Override
    public Data updateVerblijf(Data data) {
        int id = data.haalJsonNodeOp().findValue("id").asInt();
        String checkinDate = data.haalJsonNodeOp().findValue("checkin").asText();
        String checkoutDate = data.haalJsonNodeOp().findValue("checkout").asText();

        System.out.println("Booking.com adapter: Verblijf met id " + id + " geüpdatet");
        System.out.println("Check-in datum: " + checkinDate);
        System.out.println("Check-out datum: " + checkoutDate);

        try {
            HttpResponse<JsonNode> response = Unirest.get("https://booking-com.p.rapidapi.com/v2/hotels/details?checkout_date=" + checkoutDate + "&hotel_id=" + id + "&currency=EUR&checkin_date=" + checkinDate + "&locale=nl")
                    .header("x-rapidapi-key", "9dbe3ee3bamsh052139ccacb2791p11e045jsn88ed14469705")
                    .header("x-rapidapi-host", "booking-com.p.rapidapi.com")
                    .asJson();


            JsonNode responseBody = response.getBody();
            com.fasterxml.jackson.databind.JsonNode root = new ObjectMapper().readTree(responseBody.toString());


            com.fasterxml.jackson.databind.JsonNode blockArray = root.get("block");
            if (blockArray != null && blockArray.isArray() && blockArray.size() > 0) {
                com.fasterxml.jackson.databind.JsonNode firstBlock = blockArray.get(0);
                com.fasterxml.jackson.databind.JsonNode priceBreakdown = firstBlock.get("product_price_breakdown");
                if (priceBreakdown != null) {
                    com.fasterxml.jackson.databind.JsonNode allInclusive = priceBreakdown.get("all_inclusive_amount_hotel_currency");
                    if (allInclusive != null) {
                        double value = allInclusive.get("value").asDouble();
                        System.out.println("All inclusive prijs (hotel currency): €" + value);
                    } else {
                        System.out.println("Waarde 'all_inclusive_amount_hotel_currency' niet gevonden.");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return data;
    }
}
