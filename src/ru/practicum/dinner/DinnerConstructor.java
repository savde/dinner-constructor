package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerMenu = new HashMap<>();
    void addDish(String type, String name) {
        if (dinnerMenu.containsKey(type)) {
            dinnerMenu.get(type).add(name);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(name);
            dinnerMenu.put(type, dishes);
        }
    }

}
