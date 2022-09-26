package bai_giang_JaVa;

import java.util.*;

public class collections {
   /* ++Collections trong java là một khuôn khổ cung cấp một kiến trúc để lưu trữ và thao tác tới nhóm các đối tượng.
        Tất cả các hoạt động mà bạn thực hiện trên một dữ liệu như tìm kiếm, phân loại, chèn, xóa,...
        có thể được thực hiện bởi Java Collections.
        Chứa các phương thức static để thao tác với các tập dữ liệu*/

    /* Collection trong java là một root interface trong hệ thống cấp bậc Collection.
        Java Collection cung cấp nhiều interface (Set, List, Queue, Deque vv)
        và các lớp (ArrayList, Vector, LinkedList, PriorityQueue, HashSet, LinkedHashSet, TreeSet vv).*/
    /* Hệ thống cấp bậc Collection trong java
    Gói java.util chứa tất cả các lớp và interface của Collection.
        * Interface Interable -> Interface Collection->Interface (List + Queue + Set);
                Iterable interface chứa dữ liệu thành viên Iterator interface
                Iterator interface Giao tiếp Iterator cung cấp phương tiện để lặp đi lặp lại các thành phần từ đầu đến cuối của một collection.
        * Interface List bao gồm Class (ArrayList, LinkedList, Vector,Stack) implement List;    (1)
        * Interface Queue -> Interface Deque.Bao gòm Class (LinkedList,ArrayDeque) implement Interface Deque
             Class (Priority,LinkedList,ArrayDeque) implement Queue
        * Interface Set->SortedSet.Bao gồm các class(HashSet,LinkedHashSet,TreeSet) implemet tới Interface Set (3)
            Class TreeSet implement tới Interface SortedSet*/
    List<String> strings = new ArrayList<>();     //(1)
    List<Integer> integers = new LinkedList<>();  //(1)
    List<Character> characters = new Vector<>();  //(1)
    Queue<String> strings1 = new PriorityQueue<>(); //(1)
    Queue<String> string2 = new LinkedList<>();    //(2)
    Queue<String> strings3 = new ArrayDeque<>();    //(2)
    Set<String> strings4=new TreeSet<>();   //(3)
    SortedSet<String>strings5=new TreeSet<>();  //(3)
    /*Interface Map-> Interface SortedMap.Bao gồm các class(HashMap,LinkedHashMap,HashTable,TreeMap
    implement tới Map.Class TreeMap implement đến SortedMap*/
    Map<String, Integer> map = new HashMap<>();
    Map<String, String> map1 = new TreeMap<>();
    SortedMap<String, String> map2 = new TreeMap<>();

}
