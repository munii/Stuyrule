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
                else if (input.equals("get key")
                        && roomOneItems.contains("key")) {
                    roomOneItems.remove("key");
                    this.inventory.add("key");
                } else if (input.equals("get key")
                        && !roomOneItems.contains("key")) {
                    System.out.println("You already have the key.");
                }

		// Read ID
		else if ((input.equals("read ID") || input.equals("look ID") || input.equals("check ID")) 
			 && !roomOneItems.contains("ID")) {
		    Scanner info = new Scanner( System.in );
		    
		    
			 }
			 else if {
			     ((input.equals("read ID") || input.equals("look ID") || input.equals("check ID") 
			       && roomOneItems.contains("ID")) {
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
