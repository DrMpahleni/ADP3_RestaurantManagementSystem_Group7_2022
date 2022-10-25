package za.ac.cput.factory.restaurant;

import za.ac.cput.domain.restaurant.Table;
import za.ac.cput.util.genericHelper;

public class TableFactory {

    public static Table createTable(String tblNum,  String seatAmount) {
        if (genericHelper.isNullOrEmpty(tblNum) || genericHelper.isNullOrEmpty(seatAmount))
            return null;

        int tableId = genericHelper.generateIntId();
        Table table = new Table.Builder()
                .setTblNum(tblNum)
                .setSeatAmount(seatAmount)
                .build();

        return table;

    }

    public static Table createTable(String tblNum) {
        return null;
    }
}


