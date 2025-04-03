package org.example.proto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.example.proto.Domain.Reiziger;
import java.util.List;
import java.util.Map;

public record TripRequest(
        @JsonProperty("gebruikersnaam") String gebruikersnaam,
        @JsonProperty("reizigers") List<Reiziger> reizigers,
        @JsonProperty("bouwstenen") Map<String, List<JsonNode>> bouwstenen // Map instead of List
) {}

