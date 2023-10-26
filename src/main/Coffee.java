package src.main;

public class Coffee {
    private String name;
    private double weight;
    private double price;

    public Coffee(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (вага: " + weight + " г, ціна: " + price + " грн)";
    }
}
