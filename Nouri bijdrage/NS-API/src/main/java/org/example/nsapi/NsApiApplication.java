package org.example.nsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import kong.unirest.Unirest;
import kong.unirest.HttpResponse;


@SpringBootApplication
public class NsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NsApiApplication.class, args);
		getReisPrijs();

	}
	public static void getReisPrijs() {
		String url = String.format(
				"https://gateway.apiportal.ns.nl/reisinformatie-api/api/v2/price?fromStation=NM&toStation=NMH&travelClass=2&travelType=single&adults=1");

		HttpResponse<String> response = Unirest.get(url)
				.header("Ocp-Apim-Subscription-Key", "18b80989d7d04ff9bd4bf066b8a8659a")
				.asString();

		System.out.println(response.getBody());
	}




}
