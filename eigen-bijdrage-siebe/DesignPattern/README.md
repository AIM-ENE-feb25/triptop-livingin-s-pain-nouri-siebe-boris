# Design Patterns huiswerk les 3 week 2

## Ontwerpvraag
**Hoe kunnen verschillende boekingsservices (zoals Booking.com en eigen beheer in Triptop) worden geïntegreerd?**

### Voorbereiding

[Uitwerking gedeelte concept diagram](../../opdracht-diagrammen/Groeps-diagram/component-backend.puml)

### Componenten

- VerblijfsService (interface)
  - Verantwoordelijkheid: Definiëren van een gestandaardiseerd contract voor alle boekingsservices
- BookingComAdapter
  - Verantwoordelijkheid: Vertalen van Booking.com API-specificaties naar gestandaardiseerde interface
- AirbnbAdapter
  - Verantwoordelijkheid: Vertalen van Airbnb API-specificaties naar gestandaardiseerde interface

### Interface

- Boeking boekAccommodatie(accommodatieId: string, klantGegevens: object, aankomstDatum: Date, vertrekDatum: Date)
- boolean annuleerBoeking(boekingsId: string)
- Boeking ophaalBoekingsDetails(boekingsId: string)
- Boeking wijzigBoeking(boekingsId: string, nieuweGegevens: object)
