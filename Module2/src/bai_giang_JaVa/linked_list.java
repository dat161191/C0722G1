package bai_giang_JaVa;

import java.util.Iterator;
import java.util.LinkedList;

public class linked_list {
    /*Lớp LinkedList trong java là một lớp kế thừa lớp AbstractSequentialList và triển khai của List, Queue Interface trong Collections Framework
        nên nó sẽ có một vài đặc điểm và phương thức tương đồng với List, Queue.
        Lớp LinkedList trong java sử dụng cấu trúc danh sách liên kết kép Doubly để lưu trữ các phần tử.Những điểm cần ghi nhớ về lớp LinkedList:
        + Lớp LinkedList trong java có thể chứa các phần tử trùng lặp.
        + Lớp LinkedList duy trì thứ tự của phần tử được thêm vào.
        + Lớp LinkedList là không đồng bộ (non-synchronized).
        Trong java lớp LinkList, thao tác nhanh vì không cần phải dịch chuyển nếu bất kỳ phần tử nào bị xoá khỏi danh sách.
        Lớp LinkedList trong java có thể được sử dụng như list (danh sách), stack (ngăn xếp) hoặc queue (hàng đợi).
     * Hierarchy của lớp LinkedList trong java:
        +Class LinkedList implement List,Deque,Queue,Collection,Interable.
     * Constructor: LinkedList()    :Nó được sử dụng để xay dựng một danh sách trống.
                    LinkedList(Collection c)	:Nó được sử dụng để xây dựng một danh sách chứa các phần tử của collection được chỉ định,
                    theo thứ tự chúng được trả về bởi iterator của collection.
     *Phương thức của lớp ArrayList:
             +boolean add(Object o)	    :Nó được sử dụng để nối thêm phần tử được chỉ định vào cuối một danh sách.
             +void add(int index, Object element)	:Nó được sử dụng để chèn phần tử element tại vị trí index vào danh sách.
             +void addFirst(Object o)	: Nó được sử dụng để chèn phần tử được chỉ định vào đầu danh sách.
             +void addLast(Object o)	:Nó được sử dụng để chèn phần tử được chỉ định vào cuối danh sách.
             +int size()	            :Nó được sử dụng để trả lại số lượng các phần tử trong một danh sách
             +boolean contains(Object o)	: Nó được sử dụng để trở về true nếu danh sách có chứa một phần tử được chỉ định.
             +boolean contains(element)	    :Kết quả trả về là true nếu tìm thấy element trong danh sách, ngược lại trả về false.
             +void removeAll(Collection c)	:Nó được sử dụng để xóa những phần tử thuộc collection c ra khỏi danh sách.
             +int indexOf(Object o)	   :Nó được sử dụng để trả về chỉ mục trong danh sách với sự xuất hiện đầu tiên của phần tử được chỉ định
                                              hoặc -1 nếu danh sách không chứa phần tử này.
             +int lastIndexOf(Object o)	:Nó được sử dụng để trả về chỉ mục trong danh sách với sự xuất hiện cuối cùng của phần tử được chỉ định
                                              hoặc -1 nếu danh sách không chứa phần tử này.
             +Object getFirst()	        :Nó được sử dụng để trả về phần tử đầu tiên trong một danh sách.
             +Object getLast()	        :Nó được sử dụng để trả lại phần tử cuối cùng trong một danh sách.
             ++void retainAll(Collection c)	:Nó được sử dụng để xóa những phần tử không thuộc collection c ra khỏi danh sách.
        */
    public static void main(String[] args) {
        // khai báo 1 LinkedList có tên là listString
        // có kiểu là String
        LinkedList<String> list = new LinkedList<>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        list.add("Java");

        // sử dụng vòng lặp foreach- hiển thị các phần tử của list
        System.out.println("Các phần tử có trong list là: ");
        for (String str : list) {
            System.out.println(str);
        }

        // sử dụng Iterator - hiển thị các phần tử của list
        Iterator<String> iterator = list.iterator();
        System.out.println("Các phần tử có trong list là: ");
        while (iterator.hasNext()) {
            System.out.println((String) iterator.next());
        }
        // thêm các phần tử của list vào listA
        LinkedList<String> listA = new LinkedList<String>();
        listA.addAll(list);
        System.out.println("listA:" + listA);

        LinkedList<String> listB = new LinkedList<String>();
        listB.add("Java");
        // xóa những phần tử không thuộc listB khỏi listA sử dụng retainAll
        listA.retainAll(listB);
        System.out.println("listA:" + listA);

        // xóa những phần tử thuộc listB  khỏi list
        list.removeAll(listB);
        System.out.println("list:" + list);
        System.out.println(list.get(1));    // truy cập phần tử có chỉ số 1 của list
        System.out.println(list.contains("PHP")); // kiểm tra xem PHP có tồn tại trong list hay không?
        System.out.println(listA.indexOf("Java"));// kiểm tra xem Java có tồn tại trong list hay không?
        System.out.println(listA.lastIndexOf("Java"));  // kiểm tra xem Java có tồn tại trong list hay không?
        Object[] arr = list.toArray();// sử dụng phương thức toArray() chuyển list thành mảng

    }

}
