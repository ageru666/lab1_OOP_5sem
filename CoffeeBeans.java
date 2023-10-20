import java.util.Scanner;

// Клас, який представляє каву в зернах
class CoffeeBeans extends Coffee {
    private int bagsCount;

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
        System.out.print("Введіть назву кави: ");
        String coffeeName = coffeeScanner.nextLine();

        System.out.print("Введіть вагу кави в грамах: ");
        double coffeeWeight = coffeeScanner.nextDouble();

        System.out.print("Введіть ціну кави: ");
        double coffeePrice = coffeeScanner.nextDouble();

        System.out.print("Введіть кількість мішків: ");
        int bagsCount = coffeeScanner.nextInt();
        coffeeVan.addCoffee(new CoffeeBeans(coffeeName, coffeeWeight, coffeePrice, bagsCount));
    }
}