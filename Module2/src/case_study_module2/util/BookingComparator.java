package case_study_module2.util;

import case_study_module2.model.Booking.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getStartDay().compareTo(o2.getStartDay()) != 0) {
            return o1.getStartDay().compareTo(o2.getStartDay());
        } else {
            return o1.getEndDay().compareTo(o2.getEndDay());
        }

    }

}
