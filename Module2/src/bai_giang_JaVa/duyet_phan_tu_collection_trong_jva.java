package bai_giang_JaVa;

import java.util.ArrayList;
import java.util.Iterator;

public class duyet_phan_tu_collection_trong_jva {
    /*Có 3 cách để duyệt các phần tử của collection trong java.
        Sử dụng Iterator interface.
        Sử dụng vòng lặp for-each.
        Sử dụng  vòng lặp for index.
     */
    public static void main(String[] args) {
        //Tạo mảng ArrayList;
        ArrayList<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        list.add("Java");
        //Chuyển về Interator để sử dụng phương thức hasNext() duyệt phần tử;
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        // Sử dụng vòng lặp for-each.
        System.out.println();
        for (String obj : list) {
            System.out.print(obj + ", ");
        }
        // Sử dụng  vòng lặp for index.
        System.out.println();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.print(list.get(i) + ", ");
        }
    }
}
