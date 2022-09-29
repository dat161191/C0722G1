package transport.service.util;

import transport.model.Motorbike;

import java.util.Comparator;

public class SortMotorbike implements Comparator<Motorbike> {
    @Override
    public int compare(Motorbike o1, Motorbike o2) {
        if (o1.getLicensePlate().compareTo(o2.getLicensePlate()) != 0) {
            return o1.getLicensePlate().compareTo(o2.getLicensePlate());
        } else {
            int compare = Integer.compare(o1.getYearManufacture(), o2.getYearManufacture());
            return compare;
        }
    }
}
