package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerMenu = new HashMap<>();
    Random rand = new Random();

    void addDish(String type, String name) { //Добавление блюд
        if (dinnerMenu.containsKey(type)) {
            dinnerMenu.get(type).add(name);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(name);
            dinnerMenu.put(type, dishes);
        }
    }

    void generateDishes(int count, ArrayList<String> types) { //генерация комбинаций блюд
        for (int i = 0; i < count; i++) {
            System.out.println("Комбо " + (i+1));
            ArrayList<String> combo = new ArrayList<>();
            for (String type : types) {
                if (dinnerMenu.containsKey(type)) {
                    ArrayList<String> dishes = dinnerMenu.get(type);
                    String dishName = dishes.get(rand.nextInt(dishes.size() - 1));
                    combo.add(dishName);
                }
            }
            System.out.println(combo);
        }
    }

}
