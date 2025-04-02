package org.example.proto.Adapters;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.example.proto.Domain.Data;
import org.springframework.stereotype.Component;

@Component
public class bookingcomAdapter implements VerblijfAdapter {

    @Override
    public Data updateVerblijf(Data data, int aantalReizigers) {
        int id = data.haalJsonNodeOp().findValue("id").asInt();
        System.out.println("Booking.com adapter: Verblijf met id " + id + " geupdate");
        try{
        HttpResponse<JsonNode> response = Unirest.get("https://booking-com15.p.rapidapi.com/api/v1/hotels/getRoomList?hotel_id=5218600&arrival_date=2025-04-02&departure_date=2025-04-05&adults=1&room_qty=1&units=metric&temperature_unit=c&languagecode=nl&currency_code=EUR")
                .header("x-rapidapi-key", "9dbe3ee3bamsh052139ccacb2791p11e045jsn88ed14469705")
                .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                .asJson();
            System.out.println(response);}
        catch (Exception e){
            System.out.println("Error: " + e);
        }

        return data;
    }
}