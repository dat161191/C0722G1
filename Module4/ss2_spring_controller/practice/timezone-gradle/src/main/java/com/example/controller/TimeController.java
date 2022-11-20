package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("")
    public String display(){
        return "index";
    }

    /*@GetMapping("world-clock")  ánh xạ request lên phương thức xử lý.*/
    /*@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh")
     khai báo tham số của phương thức xử lý, ràng buộc với tham số từ request*/
    @GetMapping("/world-clock")
    public String getTimeByTimezoneGet(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // Lấy ra thời gian hiện tại
        Date date = new Date();
    /* Lấy ra time zone hiện tại*/
        TimeZone local = TimeZone.getDefault();
    /* Lấy ra time zone của 1 thành phố cụ thể*/
        TimeZone locale = TimeZone.getTimeZone(city);
    /*  Tính thời gian hiện tại của một thành phố cụ thể*/
    /*Hàm getRawOffset()trả về lượng thời gian tính bằng mili giây để thêm vào UTC để có thời gian chuẩn trong múi giờ này.*/
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        // Chuyển dữ liệu va gửi qua view
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
    @PostMapping("/world-clock")
    public String getTimeByTimezonePost(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // Lấy ra thời gian hiện tại
        Date date = new Date();
        /* Lấy ra time zone hiện tại*/
        TimeZone local = TimeZone.getDefault();
        /* Lấy ra time zone của 1 thành phố cụ thể*/
        TimeZone locale = TimeZone.getTimeZone(city);
        /*  Tính thời gian hiện tại của một thành phố cụ thể*/
        /*Hàm getRawOffset()trả về lượng thời gian tính bằng mili giây để thêm vào UTC để có thời gian chuẩn trong múi giờ này.*/
        long locale_time = date.getTime() +
                (locale.getRawOffset() - local.getRawOffset());
        // Chuyển dữ liệu va gửi qua view
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
