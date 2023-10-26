package src.main;

import java.util.Scanner;
import java.util.logging.Logger;

public class GroundCoffee extends Coffee {
    private int packsCount;
    private static final Logger logger = Logger.getLogger(GroundCoffee.class.getName());

    public GroundCoffee(String name, double weight, double price, int packsCount) {
        super(name, weight, price);
        this.packsCount = packsCount;
    }

    public int getPacksCount() {
        return packsCount;
    }

    @Override
    public String toString() {
        return super.toString() + " (пачок: " + packsCount + ")";
    }

    public static void addGroundCoffee(CoffeeVan coffeeVan) {
        Scanner coffeeScanner = new Scanner(System.in);
        logger.info("Введіть назву кави: ");
        String coffeeName = coffeeScanner.nextLine();

        logger.info("Введіть вагу кави в грамах: ");
        double coffeeWeight = coffeeScanner.nextDouble();

        logger.info("Введіть ціну кави: ");
        double coffeePrice = coffeeScanner.nextDouble();

        logger.info("Введіть кількість пачок: ");
        int packsCount = coffeeScanner.nextInt();
        coffeeVan.addCoffee(new GroundCoffee(coffeeName, coffeeWeight, coffeePrice, packsCount));
    }
}
