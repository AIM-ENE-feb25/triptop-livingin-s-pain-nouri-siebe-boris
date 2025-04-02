package org.example.proto.Adapters;

import org.example.proto.Domain.BouwSteen;
import org.example.proto.Domain.Data;
import org.example.proto.Domain.Trip;

public interface VerblijfAdapter {

    Data updateVerblijf(Data data, int aantalReizigers);
    
}
