package za.ac.cput.factory.restaurant;

import za.ac.cput.domain.restaurant.Reservation;
import za.ac.cput.util.genericHelper;

public class ReservationFactory {

    public static Reservation createReservation(String name, String date, String amount, String peoplePax, String tblNum) {
        if (genericHelper.isNullOrEmpty(name) || genericHelper.isNullOrEmpty(date))
            return null;

        int reservationId = genericHelper.generateIntId();
        Reservation reservation = new Reservation.Builder()
                .setName(name)
                .setDate(date)
                .setAmount(amount)
                .setPeoplePax(peoplePax)
                .setTblNum(tblNum)
                .build();

        return reservation;

    }

    public static Reservation createReservation (String name) {

        return null;
    }
}


