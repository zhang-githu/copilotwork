package com.example.copilotdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("message", "Hello, World!ss");


        return "hello";
    }

    //生成一个冒泡排序函数
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    //交换元素
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
        
    }

}