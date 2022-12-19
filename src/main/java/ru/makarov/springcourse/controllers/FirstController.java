package ru.makarov.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "operation", required = false) String operation,
                            Model model) {
        model.addAttribute("message", "Result of " + String.valueOf(a) + " " + operation+ " " + String.valueOf(b) + " is ");
        //?a=2&b=7&operation=multiplication
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator (@RequestParam(value = "a", required = false) int a,
                              @RequestParam(value = "b", required = false) int b,
                              @RequestParam(value = "operation", required = false) String operation,
                              Model model) {
            double result;
            switch (operation) {
                case ("multiplication"):
                    result = a * b;
                    break;
                case ("addition"):
                    result = a + b;
                    break;
                case ("substraction"):
                    result = a - b;
                    break;
                case ("division"):
                    result = a / (double) b;
                    break;
                default:
                    result = 0;
                    break;
            }
            model.addAttribute("result", "Result of " + String.valueOf(a) + " " + operation + " " + String.valueOf(b) + " is " + String.valueOf(result));
            //?a=2&b=7&operation=multiplication
            return "first/calculator";
    }
}
