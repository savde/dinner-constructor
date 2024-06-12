package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Завершение работы программы.");
                    return;
                default: // если введена неверная команда
                    System.out.println("Введена несуществующая команда");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        // добавьте новое блюдо
        dc.addDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        ArrayList<String> types = new ArrayList<>();
        if(!dc.dinnerMenu.isEmpty()) { // проверка, что список не пустой
            System.out.println("Начинаем конструировать обед...");

            System.out.println("Введите количество наборов, которые нужно сгенерировать:");
            int numberOfCombos = scanner.nextInt();
            while (numberOfCombos <= 0) { // проверка, что число наборов больше нуля
                System.out.println("Количество наборов должно быть больше нуля, введите корректное значение");
                numberOfCombos = scanner.nextInt();
            }
            scanner.nextLine();

            System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
            String nextItem = scanner.nextLine();

            //реализуйте ввод типов блюд
            while (!nextItem.isEmpty()) {
                if (dc.dinnerMenu.containsKey(nextItem)) {
                    types.add(nextItem);
                } else System.out.println("Типа блюда " + nextItem + " нет в меню, введите другой.");
                nextItem = scanner.nextLine();
            }

            // сгенерируйте комбинации блюд и выведите на экран
            dc.generateDishes(numberOfCombos, types);
        } else System.out.println("Список продуктов пуст");

    }
}
