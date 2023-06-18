package com.example.demo;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HelloController {
    @GetMapping("/")
    public String helloForm(Model model) {
        model.addAttribute("range", "");
        return "random";
    }
    @PostMapping("/")
    public String helloSubmit(@RequestParam("range") String range, Model model) {
        String[] rangeArray = range.split(", ");
        int start = Integer.parseInt(rangeArray[0]);
        int end = Integer.parseInt(rangeArray[1]);
        Random random = new Random();
        int[] numbers = new int[1000];
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            int num = random.nextInt(end - start + 1) + start;
            numbers[i] = num;
            sum += num;
        }
        double average = (double) sum / 1000;
        model.addAttribute("numbers", numbers);
        model.addAttribute("average", average);
        return "random";
    }
}