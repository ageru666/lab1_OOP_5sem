package src.main;

import java.util.Scanner;
import java.util.logging.Logger;

public class PacketCoffee extends Coffee {
    private int packetsCount;
    private static final Logger logger = Logger.getLogger(PacketCoffee.class.getName());

    public PacketCoffee(String name, double weight, double price, int packetsCount) {
        super(name, weight, price);
        this.packetsCount = packetsCount;
    }

    public int getPacketsCount() {
        return packetsCount;
    }

    @Override
    public String toString() {
        return super.toString() + " (пакетиків: " + packetsCount + ")";
    }

    public static void addPacketCoffee(CoffeeVan coffeeVan) {
        Scanner coffeeScanner = new Scanner(System.in);
        logger.info("Введіть назву кави: ");
        String coffeeName = coffeeScanner.nextLine();

        logger.info("Введіть вагу кави в грамах: ");
        double coffeeWeight = coffeeScanner.nextDouble();

        logger.info("Введіть ціну кави: ");
        double coffeePrice = coffeeScanner.nextDouble();

        logger.info("Введіть кількість пакетиків: ");
        int packetsCount = coffeeScanner.nextInt();
        coffeeVan.addCoffee(new PacketCoffee(coffeeName, coffeeWeight, coffeePrice, packetsCount));
    }
}
