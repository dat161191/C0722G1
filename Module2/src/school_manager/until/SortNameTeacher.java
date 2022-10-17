package school_manager.until;

import school_manager.model.Teacher;

import java.util.Comparator;

public class SortNameTeacher implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        if (o1.getName().compareTo(o2.getName()) != 0) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return o1.getCode().compareTo(o2.getCode());
        }
    }
}
