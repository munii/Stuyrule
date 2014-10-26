import java.util.ArrayList;
import java.util.Scanner;

public class StuyruleWarriors{
    
    // Main Method
    public static void main(String[] args) {

        // Create world
        World world = new World();

        // Load title screen
        world.titleScreen();

        // Load room one
        world.roomOne();
    }

    // **** INPUT BLOCK ****

    // Receives input from User
    public static String getInput() {

        // Prompt and read input
        System.out.print("> ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        // Format input
        input = formInput(input);

        // Re-prompt if input is empty or gibberish
        while (isInputDumb(input)) {
            System.out.print("> ");
            input = in.nextLine();
            input = formatInput(input);
        }

        // If system command is typed, send to systemCommandResponses method
        if (isGameCommand(input)) {
            gameCommandResponse(input);
        }

        return input;
    }

    public static boolean isInputDumb(String input) {

        // If command is valid, input is not empty or gibberish
        if (input.length() > 0
                && (isValidActionCommand(input) || isGameCommand(input))) {
            return false;
        }
        // Otherwise, provide responses if empty or gibberish
        else if (input.isEmpty()) {
            System.out.println("You mute or something? Type 'help' to cure your condition.");
        } else {
            System.out.println("Are you incapable of rational thought? Type 'help' if not.");
        }

        return true;
    }

    // Corrects erroneous user input
    public static String formInput(String input) {

        // Convert to lower case
        input = input.toLowerCase();

        // Remove extra spaces
        input = input.replaceAll("\\s+", " ");
        input = input.replaceAll("^\\s+|\\s+$", "");

        return input;
    }

    // Tests if a command is an action or game command
    public static boolean isActionCommand(String input) {

        // Extract command from input (all letters before space)
        if (input.contains(" ")) {
            input = input.substring(0, input.indexOf(' '));
        }

        // Define valid action commands
        String[] actionCommands = { "look", "get", "read",
                "talk", "open", "attack","take","pull", "leave" };

        // Check for valid action command
        for (int i = 0; i < actionCommands.length; i++) {
            if (input.equals(actionCommands[i])) {
                return true;
            }
        }

        return false;
    }

    // Game command stuff
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

    // Provides responses to game commands
    public static void systemGameResponses(String input) {

        // Display help information
        if (input.equals("help")) {

            System.out.println("[Help]");
            System.out
                    .println(" Command syntax: <command>(space)<something>, e.g. get book");
            System.out
                    .println(" Action commands: look, get, talk, move, leave, etc.");
            System.out
                    .println(" System commands: help, inventory, menu, load, save, restart, quit");
            System.out
                    .println(" Tips: Typing \"i\" is a shortcut to view your inventory.");
	    System.out.println(" Tips: Typing \"m\" is a shortcut to view your stats.");
        }

        // Display inventory contents
        else if (input.equals("i") || input.equals("inv")
                || input.equals("inventory")) {
            World.inventory.print();
        }

	// Display player stats
	else if ((input.equals("m") || (input.equals("menu")))) {
		World.menu.print();
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

    // ACTUAL GAME STUFF

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
 

    public static class Room {
        private int index;
        private int count = 0;
        private String name;
        private String description;
        private ArrayList<String> items;
        private ArrayList<String> commands;
	private ArrayList<String> foods;
	private ArrayList<String> colors;
	private ArrayList<String> subjects;

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
        String[] foods = { "chicken", "curry", "sushi", "Starbucks" };
	String[] colors = { "red", "blue", "green", "purple" };

        // Print title screen and introduction text
        void titleScreen() {
            System.out.println("+-----------------------------------+");
            System.out.println("| s t u y r u l e | w a r r i o r s |");
            System.out.println("+-----------------------------------+");
            System.out.println();
            System.out
                    .println("Muni | Lucas | Ali | Sean");
            System.out.println("Pro Animis Potestateque Sapientiaque");
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
            roomOne.setName("Homeroom");
            roomOne.setDescription("You're in your homeroom. There are other freshmen in here who are just as stringy looking as you are. Your homeroom teacher sits in her chair, apathetic. The teacher, not the chair. Although if the chair could be bored, it would. Meanwhile the frenzy of new students envelops you, you see your ID and Schedule amidst the chaos.");
            roomOne.setCount(1);
            ArrayList<String> roomOneItems = new ArrayList<String>();
            roomOneItems.add("ID");
            roomOneItems.add("Schedule");
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
                // Get ID
                else if (input.equals("get ID")
                        && roomOneItems.contains("ID")) {
                    roomOneItems.remove("ID");
                    this.inventory.add("ID");
                } else if (input.equals("get ID")
                        && !roomOneItems.contains("ID")) {
                    System.out.println("You already have your ID!");
                }
                // Get Schedule
                else if (input.equals("get schedule")
                        && roomOneItems.contains("schedule")) {
                    roomOneItems.remove("schedule");
                    this.inventory.add("schedule");
                } else if (input.equals("schedule")
                        && !roomOneItems.contains("schedule")) {
                    System.out.println("You already have the schedule.");
                }

				// Read ID
				else if ((input.equals("read ID") || input.equals("look ID") || input.equals("check ID")) 
					&& !roomOneItems.contains("ID")) {
					Scanner info = new Scanner( System.in );
		    
		    
					}
				else if 
					((input.equals("read ID") || input.equals("look ID") || input.equals("check ID") 
					&& roomOneItems.contains("ID"))) {
					System.out.println("You should try getting your ID first...");
					}

                else if (input.equals("leave")) {
                    System.out.println("You exit the room.");
                    System.out.println();
                    this.roomTwo();
                }

                // Catch-all for unavailable actions
                else if (!isValidSystemCommand(input)) {
                    System.out.println("Silly freshman. Try reading your ID or schedule.");
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
}
