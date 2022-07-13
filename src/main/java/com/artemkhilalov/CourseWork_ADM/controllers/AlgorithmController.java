package com.artemkhilalov.CourseWork_ADM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Random;

@Controller
public class AlgorithmController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/description")   //аннотация @GetMapping, чтобы отслеживать URL адреса
    public String descriptionPage(Model model) {   //функция, которая возвращает строку. Также эта функция принимает объект на основе класса Model
        return "description";
    }

    @GetMapping("/realization")
    public String realizationPage(Model model) {   //функция, которая возвращает строку. Также эта функция принимает объект на основе класса Model
        return "realization";
    }

    @GetMapping("/error")
    public String errorPage(Model model) {
        return "error";
    }

    @GetMapping("/process")
    public String processPage(Model model) {
        return "process";
    }

    @GetMapping("/examples")
    public String examplesPage(Model model) {
        return "process";
    }

    @GetMapping("/generatedNumbers")
    public String generatedNumbersPage(@RequestParam(value = "array_size") int array_size, Model model) {
        String sourceArray = getSourceArray(array_size);
        String shuffleArray = getShuffleOfNumber(array_size);
        model.addAttribute("sourceArray", sourceArray);
        model.addAttribute("shuffleArray", shuffleArray);
        return "generatedNumbers";
    }

    //сначала вводим размер массива
    //из размера делаем элементы с помощью цикла
    //и его уже генерируем

    // метод для генерации случайной перестанвки
    public String getShuffleOfNumber(int array_size) {
        //создаем массива
        int[] array_elements = new int[array_size];
        for (int i = 0; i < array_size; i++){
            //заполнение массива числами от 1 до array_size
            array_elements[i] = i + 1;
        }
        //создания объекта r для класса Random
        Random r = new Random();
        // Цикл for начинаем с последнего элемента и меняем местами один за другим.
        // Нам не нужно запускать для первого элемента, поэтому i > 0
        for(int i = array_size - 1; i > 0; i--){
            //Выбераем случайный индекс от 0 до i
            int j = r.nextInt(i+1);
            //Меняем местами array_elements[i] с элементом со случайным индексом
            int add_array = array_elements[i];
            array_elements[i] = array_elements[j];
            array_elements[j] = add_array;
        }
        String shuffleArray = Arrays.toString(array_elements);
        return shuffleArray;
    }

    //метод для получения исходного массива
    public String getSourceArray(int array_size) {
        int[] array_elements = new int[array_size];
        for (int i = 0; i < array_size; i++){
            array_elements[i] = i + 1;
        }
        String sourceArray = Arrays.toString(array_elements);
        return sourceArray;
    }

}


