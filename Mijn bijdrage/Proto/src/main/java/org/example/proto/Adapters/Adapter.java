package org.example.proto.Adapters;

import org.example.proto.Domain.Data;

public interface Adapter {
    void boek(Data data);
    void annuleer(Data data);
    void wijzig(Data data);
}
