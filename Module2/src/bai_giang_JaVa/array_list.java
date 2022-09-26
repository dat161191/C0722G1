package bai_giang_JaVa;

import java.util.ArrayList;
import java.util.Arrays;

public class array_list {
    /* Lớp ArrayList trong java là một lớp kế thừa lớp AbstractList và triển khai của List Interface
         trong Collections Framework nên nó sẽ có một vài đặc điểm và phương thức tương đồng với List.
         ArrayList được sử dụng như một mảng động để lưu trữ các phần tử.
             * Những điểm cần ghi nhớ về ArrayList:
                 +Lớp ArrayList trong java có thể chứa các phần tử trùng lặp.
                 +Lớp ArrayList duy trì thứ tự của phần tử được thêm vào.
                 +Lớp ArrayList là không đồng bộ (non-synchronized).
                 +Lớp ArrayList cho phép truy cập ngẫu nhiên vì nó lưu dữ liệu theo chỉ mục.
                 +Lớp ArrayList trong java, thao tác chậm vì cần nhiều sự dịch chuyển nếu bất kỳ phần tử nào bị xoá khỏi danh sách.
           Hierarchy (hệ thống cấp bậc) trong java collection: Array List implement interface List-> infterface Collection->Interable
          * Khởi tạo ArrayList trong java: ArrayList<String> list = new ArrayList<String>();
          * Constructor của lớp ArrayList
             +ArrayList():   	Nó được sử dụng để khởi tạo một danh sách mảng trống.
             +ArrayList(Collection c)	:Nó được sử dụng để xây dựng một danh sách mảng được khởi tạo với các phần tử của collection c.
             +ArrayList(int capacity)	:Nó được sử dụng để xây dựng một danh sách mảng mà có dung lượng ban đầu được chỉ định.
         *Phương thức của lớp ArrayList:
             +boolean add(Object o)	    :Nó được sử dụng để nối thêm phần tử được chỉ định vào cuối một danh sách.
             +void add(int index, Object element)	:Nó được sử dụng để chèn phần tử element tại vị trí index vào danh sách.
             +boolean addAll(Collection c)	:Nó được sử dụng để nối tất cả các phần tử trong collection c vào cuối của danh sách,
                                                theo thứ tự chúng được trả về bởi bộ lặp iterator.
             +boolean addAll(int index, Collection c)	:Nó được sử dụng để chèn tất cả các phần tử trong collection c vào danh sách,
                                                          bắt đầu từ vị trí index.
             +void retainAll(Collection c)	:Nó được sử dụng để xóa những phần tử không thuộc collection c ra khỏi danh sách.
             +void removeAll(Collection c)	:Nó được sử dụng để xóa những phần tử thuộc collection c ra khỏi danh sách.
             +int indexOf(Object o)	        :Nó được sử dụng để trả về chỉ mục trong danh sách với sự xuất hiện đầu tiên của phần tử được chỉ định
                                              hoặc -1 nếu danh sách không chứa phần tử này.
             +int lastIndexOf(Object o)	:Nó được sử dụng để trả về chỉ mục trong danh sách với sự xuất hiện cuối cùng của phần tử được chỉ định
                                              hoặc -1 nếu danh sách không chứa phần tử này.
             +Object[] toArray()     :Nó được sử dụng để trả về một mảng chứa tất cả các phần tử trong danh sách này theo đúng thứ tự.
             +Object[] toArray(Object[] a)	:Nó được sử dụng để trả về một mảng chứa tất cả các phần tử trong danh sách này theo đúng thứ tự.
             +Object clone()	        :Nó được sử dụng để trả về một bản sao của ArrayList.
             +void clear()	        :Nó được sử dụng để xóa tất cả các phần tử từ danh sách này.
             +void trimToSize()	    :Nó được sử dụng để cắt dung lượng của thể hiện ArrayList này là kích thước danh sách hiện tại.
             +boolean contains(element)	:Kết quả trả về là true nếu tìm thấy element trong danh sách, ngược lại trả về false.
               */
    public static void main(String[] args) {
        // khai báo 1 ArrayList có tên là listString
        ArrayList<String> list = new ArrayList<>();
        // thêm các phần tử vào list
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        list.add("Java");
        
        // sử dụng vòng lặp for each - hiển thị các phần tử của list
        System.out.println("Các phần tử có trong list là: ");
        for (String str : list) {
            System.out.println(str);
        }// thêm các phần tử của list vào listA
        ArrayList<String> listA = new ArrayList<>();
        listA.addAll(list);
        System.out.println(listA.add("test"));
        System.out.print("listA:");
        showList(listA);

        // khởi tạo listB
        ArrayList<String> listB = new ArrayList<>();
        listB.add("Java");

        // xóa những phần tử không thuộc listB khỏi listA
        listA.retainAll(listB);
        System.out.print("listA:");
        showList(listA);

        // xóa những phần tử thuộc listB  khỏi list
        list.removeAll(listB);
        System.out.print("list:");
        showList(list);
        list.removeAll(listB);
        System.out.print("list:");
        showList(list);

        // cập nhật giá trị cho phần tử có chỉ số là 1 (Java)
        listA.set(1, "Python");
        System.out.println("list sau khi cập nhật: ");
        System.out.println(listA);

        // clear list
        listA.clear();
        System.out.println("\nSố phần tử của list sau khi clear: " + listA);
        System.out.println("Các phần tử của list sau khi clear: " + listA.size());

        // kiểm tra xem PHP có tồn tại trong list hay không?
        System.out.println(listB.contains("Java"));

        // kiểm tra xem Java có tồn tại trong listB hay không?
        listB.add(0, "abc");
        listB.add(0, "xyz");
        System.out.println(listB.indexOf("Java"));

        // kiểm tra xem ANDROID có tồn tại trong listB hay không?
        System.out.println(listB.indexOf("ANDROID"));

        // sử dụng phương thức toArray() chuyển listB thành mảng
        Object[] arr = listB.toArray();
        System.out.println(Arrays.toString(arr));
    }

    private static void showList(ArrayList<String> list) {
        // Show list through for-each
        for (String obj : list) {
            System.out.print(obj + ", ");
        }
        System.out.println();
    }

}
