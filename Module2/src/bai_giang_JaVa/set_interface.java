package bai_giang_JaVa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class set_interface {
    /*  Set là một interface kế thừa Collection interface trong java. Set trong java là một Collection không thể chứa các phần tử trùng lặp.
        +Set được triển khai bởi Hashset, LinkedHashset, Treeset hoặc EnumSet.
        +HashSet lưu trữ các phần tử của nó trong bảng băm, là cách thực hiện tốt nhất,
         tuy nhiên nó không đảm bảo về thứ tự các phần tử được chèn vào.
        +TreeSet lưu trữ các phần tử của nó trong một cây, sắp xếp các phần tử của nó dựa trên các giá trị của chúng,
         về cơ bản là chậm hơn HashSet.
        +LinkedHashSet được triển khai dưới dạng bảng băm với có cấu trúc dữ liệu danh sách liên kết,
         sắp xếp các phần tử của nó dựa trên thứ tự chúng được chèn vào tập hợp (thứ tự chèn).
        +EnumSet là một cài đặt chuyên biệt để sử dụng với các kiểu enum.
     * Các phương thức của interface Set trong java
        boolean add(Object element)     :Nó được sử dụng để chèn các phần tử vào set.
        boolean addAll(Collection c)	:Nó được sử dụng để chèn tất cả các phần tử của c vào set.
        boolean contains(Object element)	:Trả về true nếu tập hợp này chứa phần tử đã chỉ định.
        boolean equals(Object o)	So sánh các đối tượng được chỉ định với set.
        boolean isEmpty()	Trả về true nếu set không chứa phần tử.
        int hashCode()	:Trả về giá trị mã băm
        Iterator iterator()	:Trả về một trình vòng lặp iterator để duyệt qua các phần tử của set.
        boolean remove(Object o)	:Xóa phần tử đã chỉ định khỏi set.
        boolean removeAll(Collection c)	    :Xóa khỏi set tất cả các phần tử của nó được chứa trong collection c đã chỉ định.
        boolean retainAll(Collection c)	    :Chỉ giữ lại các phần tử trong set được chứa trong collection c đã chỉ định.
        int size()	:Trả về số lượng các phần tử của set.
        Object[] toArray()	:Trả về một mảng chứa tất cả các phần tử trong set.
        T[] toArray(T[] a)	:Trả về một mảng chứa tất cả các phần tử trong set, kiểu run-time của mảng trả về là kiểu đã chỉ định.*/
    public static void main(String[] args) {
        Set<String> setA = new HashSet<>();
        setA.add("Java");
        setA.add("Python");
        setA.add("Java");
        setA.add("PHP");
        System.out.println("Số phần tử của setA: " + setA.size());
        System.out.println("Các phần tử của setA: " + setA);
        System.out.println("setA có chứa Java không? " + setA.contains("Java"));
        System.out.println("setA có chứa C++ không? " + setA.contains("C++"));
        Set<String> setB = new HashSet<String>();
        setB.add("abc");
        setB.add("xyz");
        setB.add("Java");
        // Thêm các phần tử setB khác vào setA trong Java
        setA.addAll(setB);
        System.out.println("Các phần tử của setA: " + setA);
        System.out.println("setA có trống không? " + setA.isEmpty());
        List<String> listA = new ArrayList<String>();
        listA.addAll(setA);// chuyển đổi setA thành listA
        System.out.println(listA);
    }
}
