import.java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StuyruleWarriors {
    
    public static final String filename = "StuyruleWarriors.dat";

    /**
     * Main method.
     * 
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        // Create world
        World world = new World();

        // Load title screen
        world.titleScreen();

        // Load room one
        world.roomOne();
    }

    /**
     * Get input from user.
     * <p>
     * This method gets input from user, checks for validity, and formats text.
     * If input is a system command (help, exit, etc.) then input is sent to the
     * systemCommandResponses method.
     * <p>
     * 
     * @return input
     */
    public static String getInput() {

        // Prompt and read input
        System.out.print("> ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        // Format input
        input = formatInput(input);

        // Re-prompt if input is empty or gibberish
        while (isInputEmptyOrGibberish(input)) {
            System.out.print("> ");
            input = in.nextLine();
            input = formatInput(input);
        }

        // If system command is typed, send to systemCommandResponses method
        if (isValidSystemCommand(input)) {
            systemCommandResponses(input);
        }

        return input;
    }

    /**
     * Check if input is empty or gibberish, if so respond with message.
     * <p>
     * This method checks the input for invalid entries and responds with
     * corresponding error messages.
     * <p>
     * 
     * @param input
     *            user input text
     * @return true if input is empty or gibberish
     */
    public static boolean isInputEmptyOrGibberish(String input) {

        // If command is valid, input is not empty or gibberish
        if (input.length() > 0
                && (isValidActionCommand(input) || isValidSystemCommand(input))) {
            return false;
        }
        // Otherwise, provide responses if empty or gibberish
        else if (input.isEmpty()) {
            System.out.println("Cat got your tongue?");
        } else {
            System.out.println("I don't understand.");
        }

        return true;
    }

    /**
     * Format text from user input.
     * <p>
     * This method formats the user input text by converting to lower case and
     * removing any extra spaces.
     * <p>
     * 
     * @param input
     *            user input text
     * @return modified/formatted input string
     */
    public static String formatInput(String input) {

        // Convert to lower case
        input = input.toLowerCase();

        // Remove extra spaces
        input = input.replaceAll("\\s+", " ");
        input = input.replaceAll("^\\s+|\\s+$", "");

        return input;
    }

    /**
     * Check for valid action command.
     * <p>
     * This method checks that a valid action command (get, open, etc.) was
     * entered by the is analyzed.
     * <p>
     * 
     * @param input
     *            user input text
     * @return true if valid action command
     */
    public static boolean isValidActionCommand(String input) {

        // Extract command from input (all letters before space)
        if (input.contains(" ")) {
            input = input.substring(0, input.indexOf(' '));
        }

        // Define valid action commands
        String[] actionCommands = { "n", "s", "e", "w", "look", "get", "read",
                "talk", "open", "close", "throw", "kill", "lock", "unlock",
                "take", "move", "push", "pull", "turn", "shoot", "leave" };

        // Check for valid action command
        for (int i = 0; i < actionCommands.length; i++) {
            if (input.equals(actionCommands[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check for valid system command, if valid send to system command responses
     * method.
     * <p>
     * This method checks if a valid system command (exit, help, etc.) was
     * entered by the user. The verb is extracted from the command using
     * substring and is analyzed.
     * <p>
     * 
     * @param input
     *            user input text
     * @return true if valid system command
     */
    public static boolean isValidSystemCommand(String input) {

        // Extract command from input (all letters before space)
        if (input.contains(" ")) {
            input = input.substring(0, input.indexOf(' '));
        }

        // Define valid system commands
        String[] systemCommands = { "help", "inventory", "inv", "i", "load",
                "save", "restart", "quit", "exit" };

        // Check for valid system command
        for (int i = 0; i < systemCommands.length; i++) {
            if (input.equals(systemCommands[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * System responses for system commands
     * <p>
     * This method provides system responses when the user enters a system
     * command (such as exit or help).
     * <p>
     * 
     * @param input
     *            user input text
     * @return true if valid system command
     */
    public static void systemCommandResponses(String input) {

        // Display help information
        if (input.equals("help")) {

            System.out.println("[Help]");
            System.out
                    .println(" Command syntax: <command>(space)<something>, e.g. get book");
            System.out
                    .println(" Action commands: look, get, open, close, talk, move, leave, etc.");
            System.out
                    .println(" System commands: help, inventory, load, save, restart, quit");
            System.out
                    .println(" Tips: Typing \"i\" is a shortcut to view your inventory");
        }

        // Display inventory contents
        else if (input.equals("i") || input.equals("inv")
                || input.equals("inventory")) {
            World.inventory.print();
        }

        // Exit game
        else if (input.equals("exit") || input.equals("quit")) {
            System.out.print("Are you sure? (y/n): ");
            Scanner in = new Scanner(System.in);
            String confirmExit = in.nextLine();
            confirmExit = confirmExit.toLowerCase();
            while (!confirmExit.equals("y") && !confirmExit.equals("n")) {
                System.out.println("Invalid response.");
                System.out
                        .print("Are you sure you want to exit the game? (y/n): ");
                confirmExit = in.nextLine();
                confirmExit = confirmExit.toLowerCase();
            }
            if (confirmExit.equals("y")) {
                System.out.println("Thank you for playing!");
                System.exit(0);
            }
        }

        // Add load, save, restart functionality
    }

    // Player inventory class (add and print)
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
    }

    public static class Room {
        private int index;
        private int count = 0;
        private String name;
        private String description;
        private ArrayList<String> items;
        private ArrayList<String> commands;

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int aIndex) {
            this.index = aIndex;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int aCount) {
            this.count = aCount;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String aName) {
            this.name = aName;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String aDescription) {
            this.description = aDescription;
        }

        public ArrayList<String> getItems() {
            return this.items;
        }

        public void setItems(ArrayList<String> aItems) {
            this.items = aItems;
        }

        public ArrayList<String> getCommands() {
            return this.commands;
        }

        public void setCommands(ArrayList<String> aCommands) {
            this.commands = aCommands;
        }

        void printItems(ArrayList<String> roomItems) {
            if (roomItems.size() > 0) {
                System.out.print("You see a ");
                if (roomItems.size() == 1) {
                    System.out.println(roomItems.get(0) + ".");
                }
                if (roomItems.size() == 2) {
                    System.out.println(roomItems.get(0) + " and a "
                            + roomItems.get(1) + ".");
                }
                if (roomItems.size() == 3) {
                    System.out.println(roomItems.get(0) + ", "
                            + roomItems.get(1) + " and a " + roomItems.get(2)
                            + ".");
                }
            }
        }

        void count() {
            this.count++;
        }
    }

    // Class World contains title screen, introduction, and all rooms 
    public static class World {

        // Print title screen and introduction text
        void titleScreen() {
            System.out.println("+-------------------------------+");
            System.out.println("| Text Adventure: Skeleton Code |");
            System.out.println("+-------------------------------+");
            System.out.println();
            System.out
                    .println("This is skeleton code for a text adventure game.");
            System.out.println("Type the introduction to your game here.");
            System.out.println();
        }

        // Special commands

        // Load player inventory
        static Inventory inventory = new Inventory();

        // Start game
        void roomOne() {

            // Load room one
            Room roomOne = new Room();
            roomOne.setIndex(1);
            roomOne.setName("Bedroom");
            roomOne.setDescription("You are in a dark room.");
            roomOne.setCount(1);
            ArrayList<String> roomOneItems = new ArrayList<String>();
            roomOneItems.add("book");
            roomOneItems.add("key");
            roomOne.setItems(roomOneItems);

            // Display room one description and items
            System.out.println(roomOne.getDescription());
            roomOne.printItems(roomOneItems);

            // Get input and play room 1
            String input = getInput();
            while (true) {
                // Look
                if (input.equals("look") || input.equals("look room")
                        || input.equals("look around")) {
                    System.out.println(roomOne.getDescription());
                    roomOne.printItems(roomOneItems);
                }
                // Get book
                else if (input.equals("get book")
                        && roomOneItems.contains("book")) {
                    roomOneItems.remove("book");
                    this.inventory.add("book");
                } else if (input.equals("get book")
                        && !roomOneItems.contains("book")) {
                    System.out.println("You already have the book.");
                }
                // Get key
                else if (input.equals("get key")
                        && roomOneItems.contains("key")) {
                    roomOneItems.remove("key");
                    this.inventory.add("key");
                } else if (input.equals("get key")
                        && !roomOneItems.contains("key")) {
                    System.out.println("You already have the key.");
                }

                else if (input.equals("leave")) {
                    System.out.println("You exit the room.");
                    System.out.println();
                    this.roomTwo();
                }

                // Catch-all for unavailable actions
                else if (!isValidSystemCommand(input)) {
                    System.out.println("You can't do that.");
                }
                input = getInput();
            }

        }

        void roomTwo() {

            // Load room two
            Room roomTwo = new Room();
            roomTwo.setIndex(2);
            roomTwo.setName("Living room");
            roomTwo.setDescription("You are in the living room.");
            roomTwo.setCount(1);
            ArrayList<String> roomTwoItems = new ArrayList<String>();
            roomTwoItems.add("note");
            roomTwoItems.add("cell phone");
            roomTwo.setItems(roomTwoItems);

            // Display room one description and items
            System.out.println(roomTwo.getDescription());
            roomTwo.printItems(roomTwoItems);

            // Get input and play room 2
            String input = getInput();
            while (true) {
                // Look
                if (input.equals("look") || input.equals("look room")
                        || input.equals("look around")) {
                    System.out.println(roomTwo.getDescription());
                    roomTwo.printItems(roomTwoItems);
                }
                // Get note
                else if (input.equals("get note")
                        && roomTwoItems.contains("note")) {
                    roomTwoItems.remove("note");
                    this.inventory.add("note");
                } else if (input.equals("get note")
                        && !roomTwoItems.contains("note")) {
                    System.out.println("You already have the note.");
                }
                // Read note
                else if (input.equals("read note") || input.equals("look note")
                        || input.equals("look at note")) {
                    System.out.println("The note reads \"0614\"");
                }

                // Get cell phone
                else if (input.equals("get cell phone")
                        && roomTwoItems.contains("cell phone")) {
                    roomTwoItems.remove("cell phone");
                    this.inventory.add("cell phone");
                } else if (input.equals("get cell phone")
                        && !roomTwoItems.contains("cell phone")) {
                    System.out.println("You already have the cell phone.");
                }

                // Leave to room 3 code goes here

                // Catch-all for unavailable actions
                else if (!isValidSystemCommand(input)) {
                    System.out.println("You can't do that.");
                }
                input = getInput();
            }

        }

    }
}
