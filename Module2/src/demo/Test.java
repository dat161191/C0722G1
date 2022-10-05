package demo;

import java.util.*;

public class Test {
    //    public static void main(String[] args) {
//        Map denoIntegerMap = new LinkedHashMap<>();
//        Deno deno = new Deno(15, "kaka");
//        denoIntegerMap.put(deno, 0);
//        Set set = denoIntegerMap.keySet();
//        for (Deno ignored : denoIntegerMap){
//            System.out.println(ignored + " "+denoIntegerMap.get(ignored));
//        }
//    }
    public static void main(String[] args) {
        List<Deno> list = new ArrayList<>();
        Deno deno = new Deno(15, "kaka");
        Deno deno1 = new Deno(15, "kaka");
        Deno deno2 = new Deno(15, "kuku");
        Deni deni = new Deni(15, "koko",100);
        Deni deni1 = new Deni(15, "kukuw",100);
        list.add(deno);
        list.add(deno1);
        list.add(deno2);
        list.add(deno2);
        list.add(deno2);
        list.add(deni1);
        list.add(deni);
        System.out.println(list);
        Map<Deno, Integer> map = new LinkedHashMap<>();
        for (Deno i : list) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        System.out.println(map);
    }
}
