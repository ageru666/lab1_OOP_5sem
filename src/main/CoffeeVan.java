package src.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class CoffeeVan {
    private double maxWeight;
    private double maxPrice;
    private List<Coffee> coffeeList = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(CoffeeVan.class.getName());

    public CoffeeVan(double maxWeight, double maxPrice) {
        this.maxWeight = maxWeight;
        this.maxPrice = maxPrice;
    }

    public void addCoffee(Coffee coffee) {
        if (calculateTotalWeight() + coffee.getWeight() <= maxWeight
                && calculateTotalPrice() + coffee.getPrice() <= maxPrice) {
            coffeeList.add(coffee);
        } else {
            logger.warning("Неможливо додати " + coffee.getName() + " до фургона.");
        }
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public double calculateTotalWeight() {
        double totalWeight = 0;
        for (Coffee coffee : coffeeList) {
            totalWeight += coffee.getWeight();
        }
        return totalWeight;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Coffee coffee : coffeeList) {
            totalPrice += coffee.getPrice();
        }
        return totalPrice;
    }

    public void sortCoffeeByPricePerKg() {
        coffeeList.sort(Comparator.comparingDouble(coffee -> coffee.getPrice() / (coffee.getWeight() / 1000)));
    }

    public List<Coffee> findCoffeeByQuality(double minQuality, double maxQuality) {
        coffeeList.sort(Comparator.comparingDouble(coffee -> coffee.getPrice() / (coffee.getWeight() / 1000)));
        List<Coffee> result = coffeeList.stream()
                .filter(coffee -> {
                    double quality = coffee.getPrice() / (coffee.getWeight() / 1000);
                    return quality >= minQuality && quality <= maxQuality;
                })
                .toList();

        return result;
    }
}
