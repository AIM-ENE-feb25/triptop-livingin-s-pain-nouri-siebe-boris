package org.example.googleflights;

import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.HttpResponse;
import kong.unirest.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class API {

    public static void main(String[] args) {
//        SpringApplication.run(API.class, args);
//        String token = loginTest("edevries", "3g2Rw9sT1x");
//        checkAppAccess(token, "edevries", "triptop");

        getReisPrijs();
        }


    public static void googleFlights(){
        HttpResponse<String> response = Unirest.get("https://google-flights2.p.rapidapi.com/api/v1/searchAirport?query=lax&language_code=en-US&country_code=US")
                .header("x-rapidapi-key", "f205ee9e87msh1fafeafc5204665p1cbdb5jsn9a964849b041")
                .header("x-rapidapi-host", "google-flights2.p.rapidapi.com")
                .asString();

        System.out.println(response.getBody());
    }

    public static String loginTest(String username, String password) {
        String jsonBody = "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";

        HttpResponse<JsonNode> response = Unirest.post("https://triptop-identity.wiremockapi.cloud/login")
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .asJson();

        if (response.isSuccess() && response.getBody() != null) {
            JSONObject responseBody = response.getBody().getObject();
            String firstName = responseBody.optString("first-name", "Unknown");
            String lastName = responseBody.optString("last-name", "Unknown");

            JSONObject tokenObject = responseBody.optJSONObject("token");
            String tokenValue = tokenObject != null ? tokenObject.optString("value", "No Token") : "No Token";

            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Token: " + tokenValue);

            return tokenValue;
        } else {
            System.err.println("Login request failed or response body is null");
            return null;
        }
    }

    public static void checkAppAccess(String token, String username, String application) {
        String jsonBody = "{\"username\": \"" + username + "\", \"application\": \"" + application + "\"}";

        HttpResponse<JsonNode> response = Unirest.post("https://triptop-identity.wiremockapi.cloud/checkAppAccess?token=" + token)
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .asJson();

            JSONObject responseBody = response.getBody().getObject();
            String role = responseBody.optString("role", "No Role");

            System.out.println("Username: " + username);
            System.out.println("Application: " + application);
            System.out.println("Role: " + role);

        }
    }



public static void getReisPrijs() {
    String url = String.format(
            "https://gateway.apiportal.ns.nl/reisinformatie-api/api/v2/price?fromStation=NM&toStation=NMH&travelClass=2&travelType=single&adults=1")

    HttpResponse<String> response = Unirest.get(url)
            .header("Ocp-Apim-Subscription-Key", "18b80989d7d04ff9bd4bf066b8a8659a")
            .asString();

    System.out.println(response.getBody());
}


