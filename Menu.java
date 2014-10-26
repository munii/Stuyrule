public static class Menu {

        // Create inventory
        ArrayList<String> menu = new ArrayList<String>();

        // Print inventory
        void print() {
            System.out.println("[Inventory]");
            if (this.inv.size() == 0) {
                System.out.println("You have nothing.");
            }

            // Capitalize first letter of each item and print
            for (String itemName : this.inv) {
                itemName = itemName.substring(0, 1).toUpperCase()
                        + itemName.substring(1);
                System.out.println(" " + itemName);
            }
        }

