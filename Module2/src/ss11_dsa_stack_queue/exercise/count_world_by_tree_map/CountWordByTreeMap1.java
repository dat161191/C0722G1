package ss11_dsa_stack_queue.exercise.count_world_by_tree_map;

import java.util.*;

public class CountWordByTreeMap1 {
    public static void main(String[] args) {
        String str = "Hello Hello hello";
        String[] str1 = str.toLowerCase().split("");
        Map<String, Integer> map = new TreeMap<>();
        for (String key : str1) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        System.out.println(map);
    }
}
