package de.rkrish.rkpizzakiosk.logic.data;

import de.rkrish.rkpizzakiosk.model.Extra;
import de.rkrish.rkpizzakiosk.model.Extras;
import de.rkrish.rkpizzakiosk.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    private DummyData() {
    }

    public static synchronized List<Pizza> getDummyPizza() {
        List<Pizza> pizza = new ArrayList<>();
        pizza.add(new Pizza(
                1,
                "Margherita - 7 EUR",
                0,
                7)
        );
        pizza.add(new Pizza(
                2,
                "Pesto - 8 EUR",
                0,
                8)
        );
        pizza.add(new Pizza(
                3,
                "Salami - 9 EUR",
                0,
                9)
        );
        pizza.add(new Pizza(
                4,
                "Funghi - 10 EUR",
                0,
                10)
        );
        pizza.add(new Pizza(
                5,
                "Piezzeria Special - 15 EUR",
                0,
                15)
        );

        return pizza;
    }

    public static synchronized List<String> getNames() {
        List<String> pizzaNames = new ArrayList<>();

        for (Pizza pizza : getDummyPizza()) {
            pizzaNames.add(pizza.getName());
        }

        return pizzaNames;
    }


    public static Pizza getPizzaByName(String name) {
        for (Pizza pizza : getDummyPizza()) {
            if (pizza.getName().equals(name)) {
                return pizza;
            }
        }
        return null;
    }


    public static Extra getExtraByName(String name) {
        for (Extra extra : getDummyExtras()) {
            if (extra.name().equals(name)) {
                return extra;
            }
        }
        return null;
    }


    // Toppings Menu Database
    public static synchronized Extras getDummyExtras() {
        Extras extras = new Extras();

        extras.add(new Extra(
                1,
                "Cheese - 3 EUR",
                3,
                0)
        );
        extras.add(new Extra(
                2,
                "Pepperoni - 4 EUR",
                4,
                0)
        );
        extras.add(new Extra(
                3,
                "Mushrooms - 2 EUR",
                2,
                0)
        );
        extras.add(new Extra(
                4,
                "Olives - 3 EUR",
                3,
                0)
        );
        extras.add(new Extra(
                5,
                "Onions - 3 EUR",
                3,
                0)
        );

        return extras;
    }


}
