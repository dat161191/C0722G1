package transport.service.util;

import transport.model.Truck;

import java.util.Comparator;

public class SortTruck implements Comparator<Truck> {
    @Override
    public int compare(Truck o1, Truck o2) {
        if (o1.getLicensePlate().compareTo(o2.getLicensePlate()) != 0) {
            return o1.getLicensePlate().compareTo(o2.getLicensePlate());
        } else {
            int compare = Integer.compare(o1.getYearManufacture(), o2.getYearManufacture());
            return compare;
        }
    }
}

