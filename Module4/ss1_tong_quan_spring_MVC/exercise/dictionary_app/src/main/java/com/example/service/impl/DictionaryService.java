package com.example.service.impl;

import com.example.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    private static final Map<String, String> dictionary = new HashMap<String, String>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("apple", "Táo");
        dictionary.put("red", "Màu đỏ");
        dictionary.put("grenn", "Màu xanh");
        dictionary.put("chicken", "Gà");
    }
    @Override
    public String getViWord(String enWord) {
        String result;
        result = dictionary.get(enWord);
        return result == null ? "Không có kết quả" : result;
    }
}
