package ss12_library_java.pratice.sort_with_comparable_Ccmparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int compare = Integer.compare(o1.getAge(), o2.getAge());
        //nếu bằng tuổi thì xếp theo tên
        if (compare != 0) {
            return compare;
        }
        else{
            return o1.getName().compareTo(o2.getName());
        }
//        if (o1.getAge() > o2.getAge()) {
//            return 1;
//        } else if (o1.getAge().equals(o2.getAge())) {
//            return 0;
//        } else {
//            return -1;
//        }
    }
}
