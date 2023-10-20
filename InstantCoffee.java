import java.util.Scanner;

// Клас, який представляє розчинну каву в банках
class InstantCoffee extends Coffee {
    private int jarsCount;

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
        System.out.print("Введіть назву кави: ");
        String coffeeName = coffeeScanner.nextLine();

        System.out.print("Введіть вагу кави в грамах: ");
        double coffeeWeight = coffeeScanner.nextDouble();

        System.out.print("Введіть ціну кави: ");
        double coffeePrice = coffeeScanner.nextDouble();

        System.out.print("Введіть кількість банок: ");
        int jarsCount = coffeeScanner.nextInt();
        coffeeVan.addCoffee(new InstantCoffee(coffeeName, coffeeWeight, coffeePrice, jarsCount));
    }
}