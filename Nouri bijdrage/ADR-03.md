# Data-structuur voor verschillende providers (Dynamisch vs Statische)
**Status**: Accepted  
**Datum**: 31 maart 2025  
**Auteur**: Nouri el Akel Rahhali
### Context

Triptop moet gegevens opslaan en verwerken van verschillende aanbieders, zoals **Booking.com** en **Airbnb** maar ook van providers van andere categorieen. Elke aanbieder hanteert een ander datamodel, waardoor er verschillen kunnen ontstaan in de beschikbare velden. De uitdaging is om een **flexibele en uitbreidbare** oplossing te vinden waarmee we gegevens van verschillende aanbieders kunnen verwerken.

## Considered Options

| Forces                     | Unieke data object per provider(booking.comData...) | Generaal data object(stayData) | JSON-opslag (data) |
| -------------------------- | --------------------------------------------------- | ------------------------------ | ------------------ |
| Onderhoudbaarheid          | -                                                   | +                              | ++                 |
| Flexibiliteit              | -                                                   | +                              | ++                 |
| Voorkomen DRY-code         | -                                                   | ++                             | ++                 |
| Extra validatie nodig vars | ++                                                  | -                              | --                 |
| Extra methodes nodig       | ++                                                  | --                             | --                 |

### Toelichting

- **Uniek data object per provider**
    - Voordeel:
        - Geen extra validatie
        - Erg overzichtelijk
    - Nadeel:
        - Veel klassen
        - Dubbele code
- **Generaal data object**
    - Voordeel:
        - Minder aantal klassen
        - Biedt flexibiliteit
    - Nadeel:
        - API contract moet strak afgesteld zijn
        - Meer validatie nodig
- **JSON direct in data object**
    - Voordeel:
        - Slechts één klasse nodig
        - Enorme flexibiliteit, elke provider kan er gebruik van maken
    - Nadeel:
        - API contract moet strak afgesteld zijn
        - Meer validatie nodig
        - Database keuze beperkt, werkt alleen met document-georiënteerde NoSQL databases

### Decision
Er is gekozen voor de **JSON-opslag** aanpak om mee te experimenteren. Deze oplossing lijkt erg aantrekkelijk vanwege de flexibiliteit en eenvoud, maar we willen graag potentiële risico's identificeren tijdens de implementatie.
### Consequences

#### Positieve gevolgen
- Maximale flexibiliteit bij het toevoegen van nieuwe providers zonder codewijzigingen
- Eenvoudig datamodel met minimale overhead
- Minder code om te onderhouden en minder dubbele code
#### Negatieve gevolgen
- Als de JSON niet correct is geformatteerd zoals de backend verwacht, kunnen er fouten optreden
- Strikte validatie is essentieel.
- Query's op geneste velden kunnen complexer worden

#### Mitigatie van risico's
Niet uitgewerkt in ons prototype omdat dit buiten de scope valt maar wel interresant om over te hebben.

- Implementeren van een validatiemechanisme voor inkomende gegevens
- Opstellen van uitgebreide documentatie over de verwachte JSON-structuur