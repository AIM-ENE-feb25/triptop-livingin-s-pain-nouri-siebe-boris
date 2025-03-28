# Architectural Decision Record (ADR)

## Status

_Accepted_
## Context

Bij het ontwikkelen van de Triptop webapplicatie willen we twee verschillende gebruikersrollen ondersteunen: de reiziger en de reisagent. De reiziger heeft toegang tot de belangrijkste functionaliteiten van de webapplicatie, zoals het zoeken naar reizen, boeken van vluchten, hotels, en het beheren van persoonlijke gegevens.

De reisagent daarentegen heeft extra functionaliteit, zoals het beheer van boekingen, het toewijzen van reizen aan reizigers, en mogelijk toegang tot een dashboard voor het beheren van reisgerelateerde gegevens.

We willen de codebase onderhoudbaar houden en overzichtelijke houden. Kort gezegd makkelijk in gebruik.

## Considered options

| **Forces**        | 1 Webapplicatie (1 back-end) | 2 webapplicaties (2-back-end) |
| ----------------- |:----------------------------:|:-----------------------------:|
| Schaalbaarheid    |              +               |               -               |
| Onderhoudbaarheid |              ++              |               O               |
| Complexiteit      |              0               |               +               |
### Toelichting
##### 1. **Schaalbaarheid**

- **1 Webapplicatie (1 back-end):**

    - Voordeel: Eén back-end maakt het makkelijker om te schalen en te beheren.

    - Nadelen: Bij groei kunnen performanceproblemen optreden als beide gebruikersrollen dezelfde back-end delen.

- **2 Webapplicaties (2 back-ends):**

    - Voordeel: Aparte back-ends kunnen beter geschaald worden.

    - Nadelen: Meer resources en complexere infrastructuur zijn nodig.

##### 2. **Onderhoudbaarheid**

- **1 Webapplicatie (1 back-end):**

    - Voordeel: Eenvoudiger onderhoud met één codebase. Code zit op een plek.

    - Nadelen: Grotere kans op technische schuld en moeilijker uitbreiden naarmate de applicatie groeit.

- **2 Webapplicaties (2 back-ends):**

    - Voordeel: Duidelijke scheiding tussen rollen maakt onderhoud makkelijker.

    - Nadelen: Twee systemen onderhouden is duur en complex, met mogelijke synchronisatieproblemen.

##### 3. **Complexiteit**

- **1 Webapplicatie (1 back-end):**

    - Voordeel: Minder complexe architectuur en makkelijker te ontwikkelen.

    - Nadelen: De logica wordt ingewikkelder naarmate functionaliteit toeneemt.

- **2 Webapplicaties (2 back-ends):**

    - Voordeel: Duidelijkere architectuur met focus op specifieke rollen.

    - Nadelen: Meer complexiteit bij integratie en data-uitwisseling tussen systemen.




### Decision

We kiezen voor **1 Webapplicatie (1 back-end)**. Deze benadering biedt betere schaalbaarheid, eenvoudigere onderhoudbaarheid en een simpelere ontwikkelproces, wat in lijn is met ons doel om de codebase onderhoudbaar te houden, terwijl we de nodige functionaliteiten voor beide gebruikersrollen ondersteunen.
### Consequences

Er kunnen prestatieproblemen optreden doordat beide rollen dezelfde back-end delen. Wat betreft onderhoudbaarheid is een enkele codebase eenvoudiger te beheren, maar het is belangrijk om de rol gebaseerde functionaliteit duidelijk te scheiden om verwarring te voorkomen en toekomstige uitbreidingen makkelijker te maken. 
