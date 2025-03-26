# Componentenlijst

### Backend 
- **TripController (Spring Boot Controller)** – Ontvangt HTTP-verzoeken van de frontend en stuurt deze door naar de service-laag.  
- **TripService (Spring Boot Service)** – Verwerkt de bedrijfslogica en regelt boekingen en betalingen.  

### Adapters (Externe API-integraties)
- **VluchtAdapter (Spring Boot Adapter)** – Boekt vluchten bij externe vluchtproviders zoals Google Flights of Skyscanner.  
- **TreinAdapter (Spring Boot Adapter)** – Boekt treintickets via de NS API.  
- **OvernachtingAdapter (Spring Boot Adapter)** – Regelt accommodatieboekingen via platforms zoals Booking.com en Airbnb.  
- **BetalingAdapter (Spring Boot Adapter)** – Initieert en verwerkt betalingen via betaalproviders zoals Stripe, Adyen of Mollie.  

### Data-opslag
- **TripRepository (Spring Boot Repository)** – Voert CRUD acties uit op de boekingsgegevens in de database.  
- **Database (SQL of NOSQL)** – Beheert de opslag van reis-, boekingsgegevens.  

### Externe Systemen
- **NS API** – Ontvangt boekingsverzoeken voor treinen.  
- **Accommodatie API (Booking.com, Airbnb, etc.)** – Ontvangt reserveringen voor accommodaties.  
- **Vlucht API (Google Flights, Skyscanner, etc.)** – Ontvangt vluchtboekingen.  
- **Betaalprovider (Stripe, Adyen, Mollie, etc.)** – Verwerkt betalingen en retourneert transactiestatussen.  



# Interface lijst

### **1. TripController**

- **`bookTrip(TripRequest request) -> ResponseEntity<TripResponse>`**

### **2. TripService**

- **`createTrip(TripRequest request) -> Trip`**

### **3. FlightAdapter**

- **`bookFlight(FlightBookingRequest request) -> FlightBookingResponse`**


### **4. TrainAdapter**

- **`bookTrain(TrainBookingRequest request) -> TrainBookingResponse`**


### **5. StayAdapter**

- **`bookStay(StayBookingRequest request) -> StayBookingResponse`**


### **6. PaymentAdapter**

- **`processPayment(PaymentRequest request) -> PaymentResponse`**


### **7. TripRepository**

- **`saveTrip(Trip trip) -> void`**
- **`getTripById(UUID tripId) -> Optional<Trip>`**
- **`getAllTrips() -> List<Trip>`**
- **`updateTrip(Trip trip) -> void`**
- **`deleteTrip(UUID tripId) -> void`**



## Wat als een bouwsteen niet geboekt kan worden

- 2 end points aanroepen 1 om data te versturen krijgt token terug.
- met token 1 end point aanroepen om te boeken.
