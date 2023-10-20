import java.util.Scanner;

// Клас, який представляє каву в пакетиках
class PacketCoffee extends Coffee {
    private int packetsCount;

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
        System.out.print("Введіть назву кави: ");
        String coffeeName = coffeeScanner.nextLine();

        System.out.print("Введіть вагу кави в грамах: ");
        double coffeeWeight = coffeeScanner.nextDouble();

        System.out.print("Введіть ціну кави: ");
        double coffeePrice = coffeeScanner.nextDouble();

        System.out.print("Введіть кількість пакетиків: ");
        int packetsCount = coffeeScanner.nextInt();
        coffeeVan.addCoffee(new PacketCoffee(coffeeName, coffeeWeight, coffeePrice, packetsCount));
    }
}
