package bai_giang_JaVa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class list {
    /*List là một interface trong java. Nó chứa các phương thức để chèn và xóa các phần tử dựa trên chỉ số index.
        Khai báo interface List trong java:     public interface List<E> extends Collection<E>
    * Các phương thức của interface List trong java:
        void add(int index,Object element): Nó được sử dụng để chèn các phần tử vào list tại chỉ số index.
        boolean addAll(int index,Collection c): Nó được sử dụng để chèn tất cả các yếu tố của c vào danh sách tại chỉ số index.
        object get(int index): Nó được sử dụng để trả về đối tượng được lưu trữ tại chỉ số index trong list.
        object set(int index,Object element): Nó được sử dụng để gán phần tử cho vị trí được chỉ định index trong list.
        object remove(int index): Nó được sử dụng để xóa các phần tử tại vị trí có chỉ số index và trả về phần tử đã xóa.
        ListIterator listIterator(): Nó được sử dụng để trả về một Iterator mà bắt đầu từ phần tử đầu tiên của list.
        ListIterator listIterator(int index): Nó được sử dụng để trả về một Iterator mà phần tử bắt đầu từ chỉ số index chỉ định.
     */
    public static void main(String[] args) {
        //Sử dụng Arrays.asList(): để chuyển mảng về list.
        String[] arr = {"Java", "C++", "PHP", "Python"};
        List<String> list = Arrays.asList(arr);
        /*ListIterator là một interface được sử dụng để duyệt các phần tử của List trong java.
        * Các phương thức của interface ListIterator trong java
            boolean hasNext(): Phương pháp này trả về true nếu list interator có tồn tại phần tử kế tiếp phần tử hiện tại.
            Object next(): Phương thức này trả về phần tử kế tiếp trong danh sách và vị trí con trỏ tăng lên 1.
            boolean hasPrevious(): Phương pháp này trả về true nếu list interator có tồn tại phần tử kề trước phần tử hiện tại.
            Object previous(): Phương thức này trả về phần tử kề trước trong danh sách và vị trí con trỏ giảm đi 1
        */
        //Sử dụng ListIterator để duyệt phần tử trong java;
        List<String> list1 = new ArrayList<String>();
        list1.add("Java");
        list1.add("C++");
        list1.add("PHP");
        list1.add(1, "Python");
        ListIterator<String> itr = list.listIterator(); // chuyển list về listIterator để sử dụng hasNext(),hasprevious();
        System.out.println("Duyet cac phan tu tu dau den cuoi:");
        while (itr.hasNext()) {
            System.out.println("\t" + itr.next());
        }
        System.out.println("Duyet cac phan tu tu cuoi ve dau:");
        while (itr.hasPrevious()) {
            System.out.println("\t" + itr.previous());
        }
    }

}
