import java.util.ArrayList;
import java.util.Scanner;

public class StuyruleWarriors {

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
                "talk", "open",, "attack","take","pull", "leave" };

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
	else if ((input.equals("m") || (input.equals("menu"))) {
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
   

   
 

    
