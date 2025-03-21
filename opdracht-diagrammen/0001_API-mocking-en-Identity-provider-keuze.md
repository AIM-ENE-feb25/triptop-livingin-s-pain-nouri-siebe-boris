# 1. API Mocking en Identity Provider Keuze

Date: 2025-21-03

## Status

Proposed

## Context

Voor de Triptop applicatie willen we gebruikers de mogelijkheid bieden om hun reisstatus op te slaan zonder dat ze een apart account hoeven aan te maken. Dit vereist een identity provider waarmee gebruikers kunnen inloggen via bestaande accounts zoals Google, Microsoft en Airbnb. We moeten een keuze maken tussen verschillende identity provider oplossingen.

## Considered Options


| Criteria        | Optie 1: Auth0                | Optie 2: Firebase Authentication       | Optie 3: WireMock (Gekozen Optie)    |
|:---------------:|:-----------------------------:|:--------------------------------------:|:------------------------------------:|
| Gebruiksgemak   | ++ Eenvoudige setup           | ++ Directe Google/Microsoft-integratie | ++ Flexibel & simpel te configureren |
| Onderhoud       | ++ Weinig onderhoud           | ++ Automatische updates                | ++ Geen afhankelijkheid van externe providers               |
| Kosten          | + Betalend boven gratis quota | ++ Gratis tot hoge limieten            | ++ Open-source en gratis te gebruiken    |
| Schaalbaarheid  | ++ Hoge schaalbaarheid        | ++ Hoge schaalbaarheid                 | ++ Lokaal en cloud-based inzetbaar            |
| Aanpasbaarheid  | + Beperkte configuratie       | + Basisaanpassingen mogelijk           | ++ Volledig aanpasbaar en scriptbaar               |


## Decision

We kiezen voor WireMock als onze oplossing voor API-mocking en authenticatie-simulatie. WireMock biedt flexibiliteit, vereist geen afhankelijkheid van externe providers en stelt ons in staat om betrouwbare tests uit te voeren zonder reële API-verzoeken. Dit past goed binnen de doelstellingen van Triptop om gebruikers volledige controle over hun reisplanning te geven zonder een complex identity management systeem op te zetten.

## Consequences

Pros:
- Geen afhankelijkheid van externe identity providers.
- Volledig configureerbare API-simulaties voor testdoeleinden.
- Open-source en eenvoudig te integreren in de ontwikkelworkflow.
- Ondersteuning voor lokale en cloud-gebaseerde implementaties.

Cons:
- Geen directe integratie met Google, Microsoft of Airbnb..
- Vereist configuratie en onderhoud van de gesimuleerde API’s.

Door deze keuze kan Triptop een robuuste, flexibele en kostenefficiënte oplossing implementeren zonder afhankelijk te zijn van externe identity providers.