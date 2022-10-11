package until;

import school_manager.model.Student;

import java.time.LocalDate;
import java.util.Comparator;

public class SortNameStudent implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getName().compareTo(o2.getName()) != 0) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return o1.getCode().compareTo(o2.getCode());
        }
    }
}
