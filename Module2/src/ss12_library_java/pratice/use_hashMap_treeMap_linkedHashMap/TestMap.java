package ss12_library_java.pratice.use_hashMap_treeMap_linkedHashMap;

import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> hashMap = new HashMap<>();
        loop:
        while (true) {
            System.out.println("1.Nhập thông tin");
            System.out.println("2.Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên");
                    String name = scanner.nextLine();
                    System.out.println("Nhập tuổi");
                    Integer age = Integer.parseInt(scanner.nextLine());
                    hashMap.put(age, name);
                    break;
                case 2:
                    break loop;
                default:
                    System.out.println("nhập sai rồi vui lòng nhập lại");
            }
        }
        System.out.println("Hiển thị các mục trong HashMap");
        System.out.println(hashMap);
//        Map<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("Smith", 30);
//        hashMap.put("Anderson", 31);
//        hashMap.put("Lewis", 29);
//        hashMap.put("Cook", 29);
//        System.out.println("Display entries in HashMap");
//        System.out.println(hashMap + "\n");
//        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
//        System.out.println("Display entries in ascending order of key");
//        System.out.println(treeMap);
//        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
//        linkedHashMap.put("Smith", 30);
//        linkedHashMap.put("Anderson", 31);
//        linkedHashMap.put("Lewis", 29);
//        linkedHashMap.put("Cook", 29);
//        System.out.println(linkedHashMap);
//        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
//    }
    }
}
