package org.example.proto.Adapters;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.example.proto.Domain.Data;
import org.springframework.stereotype.Component;

@Component
public class hotelscomAdapter implements VerblijfAdapter {

    @Override
    public Data updateVerblijf(Data data, int aantalReizigers) {
        HttpResponse<String> response = Unirest.get("https://hotels-com6.p.rapidapi.com/hotels/details-offers?propertyId=2621_17117062&checkinDate=2025-04-11&checkoutDate=2025-04-18")
                .header("x-rapidapi-key", "9dbe3ee3bamsh052139ccacb2791p11e045jsn88ed14469705")
                .header("x-rapidapi-host", "hotels-com6.p.rapidapi.com")
                .asString();
        return null;
    }
}
