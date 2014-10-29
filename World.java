import java.util.ArrayList;
import java.util.Scanner;

public class World {

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
         void roomOne(String name, int Linkcolor) {
			Battle b = new Battle();
			//Chair chair = new Chair();
			Link l = new Link(name, Linkcolor);
			Chair chair = new Chair();
			//Teacher teacher = new Teacher();
            // Load room one
            Room roomOne = new Room();
            roomOne.setIndex(1);
            roomOne.setName("Homeroom");
            roomOne.setDescription("You're in your homeroom. There are other freshmen in here who are just as stringy looking as you are. Your homeroom teacher sits in her chair, apathetic. The teacher, not the chair. Although if the chair could be bored, it would.");
            roomOne.setCount(1);
            ArrayList<String> roomOneItems = new ArrayList<String>();
			ArrayList<String> roomOneEnemies = new ArrayList<String>();
            roomOneItems.add("Sword");
            roomOneItems.add("Red Bull");
			roomOneEnemies.add("chair");
			roomOneEnemies.add("teacher");
			roomOne.setEnemies(roomOneEnemies);
            roomOne.setItems(roomOneItems);

            // Display room one description and items
            System.out.println(roomOne.getDescription());
            roomOne.printItems(roomOneItems);
			System.out.println("The following entities seem prime for battle: Chair,  Teacher");

            // Get input and play room 1
            String input = StuyruleWarriors.getInput();
            while (true) {
                // Look
                if (input.equals("look") || input.equals("look room")
                        || input.equals("look around")) {
                    System.out.println(roomOne.getDescription());
                    roomOne.printItems(roomOneItems);
                }
                // Get ID
                else if (input.equals("get sword")
                        && roomOneItems.contains("Sword")) {
                    roomOneItems.remove("Sword");
                    this.inventory.add("Sword");
                } else if (input.equals("get sword")
                        && !roomOneItems.contains("Sword")) {
                    System.out.println("You already have a sword!");
                }
                // Get Schedule
                else if (input.equals("get red bull")
                        && roomOneItems.contains("Red Bull")) {
                    roomOneItems.remove("Red Bull");
                    this.inventory.add("Red Bull");
                } else if (input.equals("get red bull")
                        && !roomOneItems.contains("Red Bull")) {
                    System.out.println("You already have Red Bull...");
                }

                else if (input.equals("leave")) {
                    System.out.println("You exit the room.");
                    System.out.println();
                    this.roomTwo();
                }
	       
		else if (input.equals("fight chair")) {
			if ( !roomOneEnemies.contains ("chair")) {
				System.out.println("You have already defeated chair!");
					}
			//Chair chair = new Chair();
				else {
					b.battle(l, chair);
					roomOneEnemies.remove("chair");
				}
			}
					
		
		
	       
		else if (input.equals("fight teacher")) {
			if (!roomOneEnemies.contains ("teacher")) {
				System.out.println("You have already defeated teacher!");
					}
				else {
					Teacher teacher = new Teacher();
					b.battle(l, teacher);
					roomOneEnemies.remove("teacher");
		}
	}
		 
                // Catch-all for unavailable actions
                else if (!StuyruleWarriors.isGameCommand(input)) {
                    System.out.println("Silly freshman.");
                }
                input = StuyruleWarriors.getInput();
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
            String input = StuyruleWarriors.getInput();
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
                else if (!StuyruleWarriors.isGameCommand(input)) {
                    System.out.println("You can't do that.");
                }




                input = StuyruleWarriors.getInput();
            }

        } 

}
