# Uitbreidbaarheid met Nieuwe Bouwstenen (ADR-02)

## Status
_Accepted_

## Context

De Triptop webapplicatie biedt de mogelijkheid om verschillende bouwstenen zoals overnachtingen, vervoer, activiteiten, etc., samen te stellen voor het plannen van reizen. De uitdaging is om de applicatie op een manier te ontwerpen zodat nieuwe bouwstenen (zoals bijvoorbeeld nieuwe vervoersopties of activiteitenaanbieders) eenvoudig kunnen worden toegevoegd zonder ingrijpende wijzigingen in de bestaande codebase of architectuur. Het doel is om de applicatie flexibel te houden en makkelijk uit te breiden, zelfs als het aantal beschikbare bouwstenen in de toekomst groeit.


## Considered options

| **Forces**        | 1 Monolithisch model | 2 Microservices model |
| ----------------- |:----------------------------:|:-----------------------------:|
| Flexibiliteit    |              +               |               ++               |
| Beheer van Bouwstenen |              ++              |               +               |
| Onderhoudbaarheid      |              ++               |               +               |
| Complexiteit      |              +              |               ++               |


### Toelichting
##### 1. **Flexibiliteit**

- **1 Monolithisch model:**

    - Voordeel: Met een monolithische architectuur is het relatief makkelijk om kleine wijzigingen door te voeren, zoals het toevoegen van een nieuwe bouwsteen. Het vereist minder infrastructuur om te onderhouden.

    - Nadelen: Naarmate de applicatie groeit, kan het toevoegen van nieuwe bouwstenen leiden tot complexere afhankelijkheden binnen de codebase, wat de flexibiliteit in de toekomst kan beperken.

- **2 Microservices model:**

    - Voordeel: Elk van de bouwstenen kan als een aparte service worden beheerd. Nieuwe bouwstenen kunnen snel en onafhankelijk van andere bouwstenen worden toegevoegd, wat de flexibiliteit vergroot.

    - Nadelen: Het vereist meer infrastructuur en integratie-inspanningen om alles goed te laten samenwerken.

##### 2. **Beheer van Bouwstenen**

- **1 Monolithisch model:**

    - Voordeel: In een monolithische architectuur kunnen bouwstenen relatief eenvoudig worden beheerd in één codebase, wat het beheer van kleine uitbreidingen makkelijker maakt.

    - Nadelen: Als de applicatie in de toekomst groeit en meer bouwstenen heeft, kunnen de afhankelijkheden binnen de codebase zich opstapelen en de applicatie moeilijker beheersbaar maken.

- **2 Microservices model:**

    - Voordeel: Elke bouwsteen kan een zelfstandige service zijn die gemakkelijk onderhouden kan worden, wat zorgt voor meer isolatie en onafhankelijkheid van andere bouwstenen.

    - Nadelen: Het beheer van meerdere microservices vereist uitgebreide monitoring, logging en infrastructuur om de verschillende services effectief te beheren.

##### 3. **Onderhoudbaarheid**

- **1 Monolithisch model:**

    - Voordeel: Eén enkele codebase betekent dat het onderhoud centraal kan worden beheerd. Kleine uitbreidingen kunnen sneller worden doorgevoerd zonder dat er veel infrastructuur of coördinatie nodig is.

    - Nadelen: Naarmate de applicatie groter wordt, kunnen veranderingen in één bouwsteen grote gevolgen hebben voor andere delen van de applicatie.

- **2 Microservices model:**

    - Voordeel: Elke bouwsteen kan onafhankelijk worden aangepast en onderhouden, zonder de rest van de applicatie te beïnvloeden. Dit bevordert lange termijn onderhoudbaarheid.

    - Nadelen: Het onderhoud van meerdere microservices is complexer en vereist meer coördinatie tussen de verschillende onderdelen van de applicatie.

##### 4. **Complexiteit**

- **1 Monolithisch model:**

    - Voordeel: De structuur van een monolithische applicatie is eenvoudiger, met minder infrastructuur om te beheren. Het ontwikkelen van nieuwe bouwstenen is makkelijker voor kleinere teams.

    - Nadelen: Naarmate de applicatie groeit, kan de complexiteit van de codebase toenemen, vooral als er veel verschillende bouwstenen en afhankelijkheden zijn.

- **2 Microservices model:**

    - Voordeel: Microservices bieden een duidelijke scheiding tussen bouwstenen, wat de ontwikkeling eenvoudiger maakt wanneer elke bouwsteen onafhankelijk van elkaar wordt ontwikkeld.

    - Nadelen: De complexiteit van integratie, communicatie tussen microservices en de coördinatie van meerdere teams maakt het moeilijker om het systeem efficiënt te beheren.

### Decision

We kiezen voor een modulaire monolithische benadering voor het uitbreiden van de applicatie met nieuwe bouwstenen. Deze benadering biedt het beste van beide werelden: het is eenvoudig te implementeren en het stelt ons in staat om nieuwe bouwstenen toe te voegen via een goed gedefinieerd uitbreidingsmechanisme zonder de bestaande applicatie te verstoren.


### Consequences

Nieuwe bouwstenen kunnen snel worden toegevoegd door simpelweg een nieuwe implementatie van de gestandaardiseerde bouwsteeninterface te creëren. Dit zullen we reiscomponent noemen zodat dit makkelijker te achterhalen is wat voor soort relatie dit heeft met de TripTop reisapplicatie.

De infrastructuur blijft relatief eenvoudig te beheren, maar de applicatie blijft flexibel genoeg om met toekomstige uitbreidingen om te gaan.

We moeten echter waken voor complexiteit die kan ontstaan naarmate er steeds meer bouwstenen worden toegevoegd. Er moeten best practices voor codebeheer en modularisatie strikt worden nageleefd om technische schulden te voorkomen.


### Bronnen

- https://martinfowler.com/articles/microservices.html
- https://techbeacon.com/app-dev-testing/monolithic-vs-microservices-architecture
- https://martinfowler.com/articles/microservices.html

