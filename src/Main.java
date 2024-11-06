import animal.Animal;
import commands.SelectActions;
import commands.SelectAnimals;
import menu.Addanimal;
import utils.ValidationLine;
import utils.ValidationNumber;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
        SelectActions selectActions;
        ValidationNumber validationNumber = new ValidationNumber();
        ValidationLine validationLine = new ValidationLine();

        while (true) {
            ArrayList<String> actionForEnum = new ArrayList<>();
            for (SelectActions selectActions1 : SelectActions.values()) {
                actionForEnum.add(selectActions1.name().toUpperCase());
            }
            System.out.println("Введите введите команду: " + String.join("/", actionForEnum));                      // Вывод команд через Enum
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine().toUpperCase().trim();
            try {
                selectActions = SelectActions.valueOf(line);
            } catch (Exception exception) {
                System.out.println("Такой команды нет, повторите попытку еще раз");
                continue;
            }
            switch (selectActions) {
                case ADD:
                    ArrayList<String> animalsForEnum = new ArrayList<>();
                    for (SelectAnimals selectAnimals1 : SelectAnimals.values()) {
                        animalsForEnum.add(selectAnimals1.name().toUpperCase());
                    }
                    while (true) {
                        System.out.println("Введите название животного: " + String.join("/", animalsForEnum));          // Вывод животных через Enum
                        String typeAnimal = scanner.nextLine().toUpperCase().trim();

                        if (!animalsForEnum.contains(typeAnimal)) {                                                             // Сравнение строки с элементами массива, полученных из Enum
                            System.out.println("Такого животного нет, повторите попытку еще раз");
                        } else {
                            System.out.println("Введите имя");
                            String name = validationLine.validateLine(line);

                            System.out.println("Введите возраст");
                            int age = validationNumber.validateNumber(line);

                            System.out.println("Введите вес");
                            int weight = validationNumber.validateNumber(line);

                            System.out.println("Введите цвет");
                            String color = validationLine.validateLine(line);

                            Animal animal = new Addanimal(name, age, weight, color).createAnimal(SelectAnimals.valueOf(typeAnimal));
                            animals.add(animal);
                            System.out.println(animal.say());
                            break;
                        }
                    }
                    break;

                case LIST:
                    if (animals.size() == 0) {
                        System.out.println("На данный момент список пуст");
                        continue;
                    } else {
                        for (Animal an : animals)
                            System.out.println(an.toString());
                    }
                    break;

                case EXIT:
                    scanner.close();
                    System.out.println("Выход");
                    System.exit(0);
            }

        }

    }
}