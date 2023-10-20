import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class CoffeeVan {
    private double maxWeight;
    private double maxPrice;
    private List<Coffee> coffeeList = new ArrayList<>();

    public CoffeeVan(double maxWeight, double maxPrice) {
        this.maxWeight = maxWeight;
        this.maxPrice = maxPrice;
    }

    public void addCoffee(Coffee coffee) {
        if (calculateTotalWeight() + coffee.getWeight() <= maxWeight
                && calculateTotalPrice() + coffee.getPrice() <= maxPrice) {
            coffeeList.add(coffee);
        } else {
            System.out.println("Неможливо додати " + coffee.getName() + " до фургона.");
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
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffeeList) {
            double quality = coffee.getPrice() / (coffee.getWeight() / 1000);
            if (quality >= minQuality && quality <= maxQuality) {
                result.add(coffee);
            }
        }
        return result;
    }
}