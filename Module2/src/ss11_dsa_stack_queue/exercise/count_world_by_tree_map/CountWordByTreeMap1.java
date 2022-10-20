package ss11_dsa_stack_queue.exercise.count_world_by_tree_map;

import java.util.*;

public class CountWordByTreeMap1 {
    public static void main(String[] args) {
        String str = "Hello Hello hello aa";
        String[] str1 = str.toLowerCase().split("");
        Map<String, Integer> map = new TreeMap<>();
        for (String i : str1) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        System.out.println(map);
    }
}
