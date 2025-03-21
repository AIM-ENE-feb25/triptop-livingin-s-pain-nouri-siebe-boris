# 1. Betalingen ADR

**Datum:** 21-03-2025  

## Status  

Accepted  

## Context  

Er moet gekozen worden of de aanroep voor de betalings-API om de boeking te betalen via de frontend of via de backend moet lopen. Hierbij worden de boekingen pas geboekt wanneer de betaling is gelukt.  

## Considered Options  

| Forces          | Via backend | Via frontend |
|:--------------:|:----------:|:-----------:|
| Privacy         |   0        |    +        |
| Betrouwbaarheid |   ++       |    -        |
| Complexiteit    |   0        |    0        |

Wat betreft de privacy is de optie om dit direct vanuit de frontend te doen iets beter. Je hebt dan namelijk geen gevoelige betalingsinformatie die je tussen de front- en backend heen en weer stuurt. Vandaar dat er bij de frontend een plusje staat.  

Bij de betrouwbaarheid hebben wij voor de backend twee plusjes en voor de frontend een minnetje. Dit komt omdat wanneer een betaling via de frontend is gelukt, maar er een fout optreedt tussen de frontend en backend, de bevestiging van de betaling niet doorgezet kan worden. Hierdoor wordt de boeking niet verwerkt in de backend. Wanneer dit via de backend gebeurt, kan de boeking direct worden geregistreerd en is er geen risico op fouten tussen de front- en backend.  

Als laatste is de complexiteit in beide gevallen vergelijkbaar. Dit komt omdat bij beide opties ongeveer evenveel moet gebeuren voor de afhandeling van eventuele fouten.  

## Decision  

Onze keuze is dat wij de communicatie bij de betalingen via de backend laten verlopen. Hoewel dit een klein nadeel heeft op het gebied van privacy, vinden wij de betrouwbaarheid van het betalen een stuk belangrijker in onze applicatie.  

## Consequences  

- Er moet meer gevoelige informatie van de gebruiker naar de backend gestuurd worden, zoals betaalgegevens.
