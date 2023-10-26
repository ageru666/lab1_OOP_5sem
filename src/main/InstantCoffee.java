package src.main;

import java.util.Scanner;
import java.util.logging.Logger;

public class InstantCoffee extends Coffee {
    private int jarsCount;
    private static final Logger logger = Logger.getLogger(InstantCoffee.class.getName());

    public InstantCoffee(String name, double weight, double price, int jarsCount) {
        super(name, weight, price);
        this.jarsCount = jarsCount;
    }

    public int getJarsCount() {
        return jarsCount;
    }

    @Override
    public String toString() {
        return super.toString() + " (банок: " + jarsCount + ")";
    }

    public static void addInstantCoffee(CoffeeVan coffeeVan) {
        Scanner coffeeScanner = new Scanner(System.in);
        logger.info("Введіть назву кави: ");
        String coffeeName = coffeeScanner.nextLine();

        logger.info("Введіть вагу кави в грамах: ");
        double coffeeWeight = coffeeScanner.nextDouble();

        logger.info("Введіть ціну кави: ");
        double coffeePrice = coffeeScanner.nextDouble();

        logger.info("Введіть кількість банок: ");
        int jarsCount = coffeeScanner.nextInt();
        coffeeVan.addCoffee(new InstantCoffee(coffeeName, coffeeWeight, coffeePrice, jarsCount));
    }
}
