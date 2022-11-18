package com.example.service.impl;

import com.example.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    private static Map<String, String> dictionary = new HashMap<String, String>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("Tấn", "Tệ Nạn");
        dictionary.put("Bảo", "Ma bư");
        dictionary.put("dictionary", "từ diển");
        dictionary.put("Sang", "Sumo");
        dictionary.put("Phương", "Chơi Chữ");
        dictionary.put("Huy", "Nghiện bida");
    }

    @Override
    public String getViWord(String enWord) {
        String result;
        result = dictionary.get(enWord);
        return result == null ? "Không có kết quả" : result;
    }
}
