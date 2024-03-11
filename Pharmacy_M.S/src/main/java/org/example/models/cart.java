package org.example.models;
import java.util.ArrayList;
import java.util.List;
public class cart {
        private List<drugs> cartItems;

        public cart() {
            cartItems = new ArrayList<>();
        }

        // Add a drug to the cart
        public void addToCart(drugs drug) {
            cartItems.add(drug);
        }

        // Calculate the total price of the cart
        public double calculateTotal() {
            double total = 0;
            for (drugs drug : cartItems) {
                total += drug.getPrice();
            }
            return total;
        }

    public drugs[] getcartItems() {
        return new drugs[0];
    }
}

