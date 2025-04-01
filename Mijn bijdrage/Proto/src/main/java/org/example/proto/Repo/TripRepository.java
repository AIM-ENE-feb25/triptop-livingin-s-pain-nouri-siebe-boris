package org.example.proto.Repo;

import org.example.proto.Domain.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TripRepository extends MongoRepository<Trip, String> {
}
