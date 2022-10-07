package case_study_module2.util;

import case_study_module2.model.Booking.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparable, Comparator<Booking> {
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int compare(Booking o1, Booking o2) {
        if (o2.getStartDay().compareTo(o1.getStartDay()) != 0) {
            return o2.getStartDay().compareTo(o1.getStartDay());
        } else {
            return o2.getEndDay().compareTo(o1.getEndDay());
        }

    }

}
