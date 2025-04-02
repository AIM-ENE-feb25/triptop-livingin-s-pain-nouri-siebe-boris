package org.example.proto.Adapters;

import org.example.proto.Domain.BouwSteen;
import org.example.proto.Domain.Data;
import org.springframework.stereotype.Component;

@Component
public class airbnbAdapter implements VerblijfAdapter {

    @Override
    public Data updateVerblijf(Data data, int aantalReizigers) {
        return null;
    }
}
