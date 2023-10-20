import java.util.Scanner;

// Клас, який представляє мелену каву
class GroundCoffee extends Coffee {
    private int packsCount;

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
        System.out.print("Введіть назву кави: ");
        String coffeeName = coffeeScanner.nextLine();

        System.out.print("Введіть вагу кави в грамах: ");
        double coffeeWeight = coffeeScanner.nextDouble();

        System.out.print("Введіть ціну кави: ");
        double coffeePrice = coffeeScanner.nextDouble();

        System.out.print("Введіть кількість пачок: ");
        int packsCount = coffeeScanner.nextInt();
        coffeeVan.addCoffee(new GroundCoffee(coffeeName, coffeeWeight, coffeePrice, packsCount));
    }
}