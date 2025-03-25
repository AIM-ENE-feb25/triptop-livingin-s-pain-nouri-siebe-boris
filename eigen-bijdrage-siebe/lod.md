# De Wet van Demeter: Een Design Principe voor Losse Koppeling

## Definitie
De Wet van Demeter (LoD) is een ontwerpprincipe dat stelt dat een methode van een object alleen maar met de volgende objecten mag communiceren:
- Het object zelf
- Objecten die als parameter worden doorgegeven aan de methode
- Objecten die direct worden gecreëerd binnen de methode
- Directe componenten (velden) van het object

## Kernidee: "Praat alleen met je directe buren"

### Voorbeeld van Schending van de Wet van Demeter
```java
public class BadExample {
    public void processOrder(Order order) {
        // Anti-patroon: te veel methodeketens
        double total = order.getCustomer().getCart().calculateTotal();
    }
}
```

### Correcte Toepassing van de Wet van Demeter
```java
public class GoodExample {
    public void processOrder(Order order) {
        // Betere benadering: beperkte communicatie
        double total = order.calculateOrderTotal();
    }

    // Order klasse neemt verantwoordelijkheid voor eigen berekeningen
    public class Order {
        private Customer customer;

        public double calculateOrderTotal() {
            return customer.getCartTotal();
        }
    }
}
```

## Consequenties van Toepassing

### Voordelen:
- Verminderde afhankelijkheden tussen klassen
- Verhoogde onderhoudbaarheid van code
- Betere encapsulatie
- Eenvoudiger testen van individuele componenten

### Mogelijke Nadelen:
- Kan leiden tot meer wrapper-methoden
- Soms extra abstractielagen nodig
- Kan initieel meer code vereisen

## Design Properties

De Wet van Demeter is gebaseerd op:
1. **Encapsulatie**: Verbergen van interne implementatiedetails
2. **Losse Koppeling**: Minimaliseren van afhankelijkheden tussen objecten
3. **Scheiding van Verantwoordelijkheden**: Elke klasse is verantwoordelijk voor zijn eigen gedrag
