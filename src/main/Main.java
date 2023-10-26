package src.main;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeVan coffeeVan = new CoffeeVan(10000, 10000);

        coffeeVan.addCoffee(new InstantCoffee("Nescafe", 200, 150, 5));
        coffeeVan.addCoffee(new PacketCoffee("Arabica", 300, 300, 10));
        coffeeVan.addCoffee(new PacketCoffee("Robusta", 250, 200, 8));
        coffeeVan.addCoffee(new InstantCoffee("Maxwell House", 150, 180, 6));
        coffeeVan.addCoffee(new GroundCoffee("Gwatemala", 300, 200, 7));
        coffeeVan.addCoffee(new CoffeeBeans("Uganda", 200, 180, 5));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Додати розчинну каву в банках");
            System.out.println("2. Додати каву в пакетиках");
            System.out.println("3. Додати зернову каву");
            System.out.println("4. Додати мелену каву");
            System.out.println("5. Вивести список кави у фургоні");
            System.out.println("6. Вивести загальну вагу та ціну");
            System.out.println("7. Сортування за ціною за кілограм");
            System.out.println("8. Пошук за якістю (ціна за кілограм)");
            System.out.println("9. Вийти");
            System.out.print("Виберіть опцію: ");

            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    InstantCoffee.addInstantCoffee(coffeeVan);
                    break;
                case 2:
                    PacketCoffee.addPacketCoffee(coffeeVan);
                    break;
                case 3:
                    CoffeeBeans.addCoffeeBeans(coffeeVan);
                    break;
                case 4:
                    GroundCoffee .addGroundCoffee(coffeeVan);
                    break;
                case 5:
                    System.out.println("Список товарів у фургоні:");
                    for (Coffee coffee : coffeeVan.getCoffeeList()) {
                        System.out.println(coffee);
                    }
                    break;
                case 6:
                    System.out.println("\nЗагальна вага товарів у фургоні: " + coffeeVan.calculateTotalWeight() + " г");
                    System.out.println("Загальна ціна товарів у фургоні: " + coffeeVan.calculateTotalPrice() + " грн");
                    break;
                case 7:
                    coffeeVan.sortCoffeeByPricePerKg();
                    System.out.println("\nСортування товарів за ціною за кілограм:");
                    List<Coffee> sortedCoffee = coffeeVan.getCoffeeList();
                    for (Coffee coffee : sortedCoffee) {
                        System.out.println(coffee);
                    }
                    break;
                case 8:
                    System.out.println("\nПошук товарів за якістю (ціна за кілограм):");
                    System.out.print("Введіть мінімальну якість (ціна за кілограм, грн/кг): ");
                    double minQuality = scanner.nextDouble();
                    System.out.print("Введіть максимальну якість (ціна за кілограм, грн/кг): ");
                    double maxQuality = scanner.nextDouble();

                    List<Coffee> foundCoffee = coffeeVan.findCoffeeByQuality(minQuality, maxQuality);
                    if (foundCoffee.isEmpty()) {
                        System.out.println("Товари з такою якістю не знайдено.");
                    } else {
                        for (Coffee coffee : foundCoffee) {
                            System.out.println(coffee);
                        }
                    }
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}

