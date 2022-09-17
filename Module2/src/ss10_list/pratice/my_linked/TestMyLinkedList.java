package ss10_list.pratice.my_linked;

import ss10_list.pratice.my_linked.MyLinkedList;

public class TestMyLinkedList { public static void main(String[] args) {
    MyLinkedList myList = new MyLinkedList(10);
    myList.addFirst(11);
    myList.addFirst(12);
    myList.addFirst(13);
    myList.printList();
    System.out.println(myList.get(0));
}
}
