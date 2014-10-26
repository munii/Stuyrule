public static class Inventory {

        // Create inventory
        ArrayList<String> inv = new ArrayList<String>();

        // Add item to inventory (and print message)
        void add(String item) {
            System.out.println("You pick up the " + item + ".");
            this.inv.add(item);
        }

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

        // Check if item is already in inventory
        boolean isInInventory(String item) {

            return false;
        }
    };; This buffer is for notes you don't want to save, and for Lisp evaluation.
;; If you want to create a file, visit that file with C-x C-f,
;; then enter the text in that file's own buffer.

