package src.main;

import java.util.Scanner;
import java.util.logging.Logger;

public class CoffeeBeans extends Coffee {
    private int bagsCount;
    private static final Logger logger = Logger.getLogger(CoffeeBeans.class.getName());

    public CoffeeBeans(String name, double weight, double price, int bagsCount) {
        super(name, weight, price);
        this.bagsCount = bagsCount;
    }
    public int getBagsCount() {
        return bagsCount;
    }

    @Override
    public String toString() {
        return super.toString() + " (мішків: " + bagsCount + ")";
    }

    public static void addCoffeeBeans(CoffeeVan coffeeVan) {
        Scanner coffeeScanner = new Scanner(System.in);
        logger.info("Введіть назву кави: ");
        String coffeeName = coffeeScanner.nextLine();

        logger.info("Введіть вагу кави в грамах: ");
        double coffeeWeight = coffeeScanner.nextDouble();

        logger.info("Введіть ціну кави: ");
        double coffeePrice = coffeeScanner.nextDouble();

        logger.info("Введіть кількість мішків: ");
        int bagsCount = coffeeScanner.nextInt();
        coffeeVan.addCoffee(new CoffeeBeans(coffeeName, coffeeWeight, coffeePrice, bagsCount));
    }
}
