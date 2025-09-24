package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("book", "quyển sách");
        dictionary.put("computer", "máy tính");
        dictionary.put("dog", "con chó");
        dictionary.put("cat", "con mèo");
    }

    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("index");
    }

    @PostMapping("/translate")
    public ModelAndView translate(@RequestParam("word") String word) {
        String result = dictionary.get(word.toLowerCase());
        ModelAndView mav = new ModelAndView("index");
        if (result != null) {
            mav.addObject("result", "Nghĩa: " + result);
        } else {
            mav.addObject("result", "❌ Không tìm thấy từ");
        }
        return mav;
    }
}
