package src.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import src.main.CoffeeVan;
import src.main.Coffee;
import src.main.CoffeeBeans;
import src.main.GroundCoffee;
import src.main.PacketCoffee;
import src.main.InstantCoffee;


public class CoffeeTest {
    private CoffeeVan coffeeVan;

    @Before
    public void setUp() {
        coffeeVan = new CoffeeVan(10000, 10000);
    }

    @Test
    public void testAddCoffee() {
        InstantCoffee instantCoffee = new InstantCoffee("TestCoffee", 200, 150, 5);
        coffeeVan.addCoffee(instantCoffee);
        assertTrue(coffeeVan.getCoffeeList().contains(instantCoffee));
    }

    @Test
    public void testCalculateTotalWeight() {
        InstantCoffee instantCoffee1 = new InstantCoffee("Coffee1", 200, 150, 5);
        InstantCoffee instantCoffee2 = new InstantCoffee("Coffee2", 300, 200, 5);
        coffeeVan.addCoffee(instantCoffee1);
        coffeeVan.addCoffee(instantCoffee2);
        double totalWeight = coffeeVan.calculateTotalWeight();
        assertEquals(500, totalWeight, 0.01);
    }

    @Test
    public void testCalculateTotalPrice() {
        PacketCoffee packetCoffee1 = new PacketCoffee("Coffee1", 200, 150, 5);
        PacketCoffee packetCoffee2 = new PacketCoffee("Coffee2", 300, 200, 5);
        coffeeVan.addCoffee(packetCoffee1);
        coffeeVan.addCoffee(packetCoffee2);
        double totalPrice = coffeeVan.calculateTotalPrice();
        assertEquals(350, totalPrice, 0.01);
    }

    @Test
    public void testInstantCoffeeToString() {
        InstantCoffee instantCoffee = new InstantCoffee("Nescafe", 200, 150, 5);
        String expected = "Nescafe (вага: 200.0 г, ціна: 150.0 грн) (банок: 5)";
        String actual = instantCoffee.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testPacketCoffeeToString() {
        PacketCoffee packetCoffee = new PacketCoffee("Arabica", 300, 300, 10);
        String expected = "Arabica (вага: 300.0 г, ціна: 300.0 грн) (пакетиків: 10)";
        String actual = packetCoffee.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testCoffeeBeansToString() {
        CoffeeBeans coffeeBeans = new CoffeeBeans("Uganda", 200, 180, 5);
        String expected = "Uganda (вага: 200.0 г, ціна: 180.0 грн) (мішків: 5)";
        String actual = coffeeBeans.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testGroundCoffeeToString() {
        GroundCoffee groundCoffee = new GroundCoffee("Gwatemala", 300, 200, 7);
        String expected = "Gwatemala (вага: 300.0 г, ціна: 200.0 грн) (пачок: 7)";
        String actual = groundCoffee.toString();
        assertEquals(expected, actual);
    }
}
