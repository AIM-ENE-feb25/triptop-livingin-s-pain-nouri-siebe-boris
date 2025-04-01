package org.example.proto.Request;
import org.example.proto.Domain.Data;
import org.example.proto.Domain.Reiziger;

import java.util.List;

public record TripRequest(List<Reiziger> reizigers, List<Data> data) {
}
