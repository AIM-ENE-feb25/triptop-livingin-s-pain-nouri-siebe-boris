package org.example.proto.Adapters;

import org.example.proto.Domain.Data;

public class bookingAdapter implements Adapter{

    @Override
    public void boek(Data data) {
        // Implement booking logic here
        System.out.println("Booking data: " + data);
    }

    @Override
    public void annuleer(Data data) {
        // Implement cancellation logic here
        System.out.println("Cancelling data: " + data);
    }

    @Override
    public void wijzig(Data data) {
        // Implement modification logic here
        System.out.println("Modifying data: " + data);
    }
}
