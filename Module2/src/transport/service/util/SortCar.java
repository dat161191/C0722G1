package transport.service.util;

import transport.model.Car;

import java.util.Comparator;

public class SortCar implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getLicensePlate().compareTo(o2.getLicensePlate()) != 0) {
            return o1.getLicensePlate().compareTo(o2.getLicensePlate());
        } else {
            int compare = Integer.compare(o1.getYearManufacture(), o2.getYearManufacture());
            return compare;
        }
    }
}
