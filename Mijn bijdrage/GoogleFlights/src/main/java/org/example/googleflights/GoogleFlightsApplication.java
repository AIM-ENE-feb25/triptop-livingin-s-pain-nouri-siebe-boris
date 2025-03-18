package org.example.googleflights;

import kong.unirest.Unirest;
import kong.unirest.HttpResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GoogleFlightsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleFlightsApplication.class, args);

        HttpResponse<String> response = Unirest.get("https://google-flights2.p.rapidapi.com/api/v1/searchAirport?query=lax&language_code=en-US&country_code=US")
                .header("x-rapidapi-key", "f205ee9e87msh1fafeafc5204665p1cbdb5jsn9a964849b041")
                .header("x-rapidapi-host", "google-flights2.p.rapidapi.com")
                .asString();

                System.out.println(response.getBody());
            }
        }

