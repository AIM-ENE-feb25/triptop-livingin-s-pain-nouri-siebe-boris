package org.example.rapidapibooking;


import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RapidApiBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RapidApiBookingApplication.class, args);

		HttpResponse<String> response = Unirest.get("https://booking-com15.p.rapidapi.com/api/v1/hotels/searchHotels?dest_id=20014181&search_type=CITY&arrival_date=2025-03-24&departure_date=2025-03-30&adults=1&children_age=0%2C17&room_qty=1&page_number=1&units=metric&temperature_unit=c&languagecode=nl&currency_code=EUR")
				.header("x-rapidapi-key", "9dbe3ee3bamsh052139ccacb2791p11e045jsn88ed14469705")
				.header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
				.asString();

		System.out.println(response.getBody());
	}

}
