# Design pattern (ADR-02)

## Status

_Accepted_
## Context

Voor de Triptop-applicatie is de volgende ontwerpvraag geformuleerd:  
**Hoe maken we de applicatie uitbreidbaar met nieuwe bouwstenen?**

## Considered options

| **Forces**                   | Factory Pattern |
| ---------------------------- | :-------------: |
| Encapsulatie                 |        +        |
| Schaalbaarheid               |       ++        |
| Onderhoudbaarheid            |        0        |
| flexibiliteit voor de client |       --        |
### Toelichting

#### Voordelen

- **Encapsulatie:** De creatie van objecten wordt afgeschermd, wat aanpassingen eenvoudiger maakt.

- **Schaalbaarheid:** Nieuwe objecttypen kunnen worden toegevoegd zonder wijzigingen in de clientcode.

#### Nadelen

- **Onderhoudbaarheid:** Bij eenvoudige objecten kan het gebruik van een factory onnodige complexiteit toevoegen.

- **Beperkte flexibiliteit:** De client heeft minder controle over de configuratie van objecten.

### Decision
Uit de lijst van de voorgesteld patterns lijkt ons deze het best bij de ontwerp vraag te passen. Het gaat namelijk over het aanmaken van meerdere types van een object
### Consequences
Het gebruik van het Factory Pattern brengt zowel voordelen als uitdagingen met zich mee:

- **Voordeel:** Dankzij encapsulatie kunnen we diverse typen data opslaan in een bouwsteen, waardoor verschillende soorten bouwstenen mogelijk worden. Dit is ideaal voor de backend-architectuur.

- **Uitdaging:** De front-end moet expliciet data meegeven voor welk type data-object moet worden aangemaakt, wat de implementatie aan de front-end complexer kan maken. Dit vraagt om een heldere strategie voor typebepaling en configuratie.

###### Bron:
https://refactoring.guru/design-patterns/factory-method
  
