package ss10_list.exercise.arraylist;

import java.util.Arrays;
import java.util.Scanner;

public class MyArrayTestList {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(10);
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.add(25);
        System.out.println("Giá trị phần tử ở vị trí 2 là:" + myArrayList.get(2));
        myArrayList.addIndex(2, 50);
        System.out.println("Giá trị phần tử ở vị trí 2 là:" + myArrayList.get(2));
        System.out.println(myArrayList.get(3));
        System.out.println(myArrayList.contain(10));
        System.out.println(myArrayList.indexof(50));
        System.out.println(myArrayList.indexof(500));
        myArrayList.showList();
        myArrayList.remove(2);
        myArrayList.showList();
        System.out.println("Size của mảng là: " + myArrayList.size());
        myArrayList.clear();
        System.out.println(myArrayList.clone());

    }
}
