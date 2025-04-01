package org.example.proto.Adapters;

import org.example.proto.Domain.BouwSteen;
import org.example.proto.Domain.Data;
import org.springframework.stereotype.Component;

@Component
public class bookingcomAdapter implements VerblijfAdapter {

    @Override
    public Data updateVerblijf(Data data) {
        String bouwsteenData = data.haalJsonDataOp();
        return new Data(bouwsteenData);
    }
}
