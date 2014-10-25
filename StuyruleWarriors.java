import java.util.*;

public class StuyruleWarriors {
    public String[] subjectArray;
    public String[] foodArray;
    public String[] colorArray;
    public String[] attackArray;
    public String[] locationArray;
    public String[] optionArray;

    voidPopulate


    subjectArray = new String[5];

    //subjectArray
    subjectArray[0] = "null";
    subjectArray[1] = "Math";
    subjectArray[2] = "English";
    subjectArray[3] = "Computer Science";
    subjectArray[4] = "History";

    foodArray = new String[5];

    //foodArray
    foodArray[0] = "null";
    foodArray[1] = "Sushi";
    foodArray[2] = "Starbucks";
    foodArray[3] = "Curry";
    foodArray[4] = "Popcorn Chicken";

    colorArray = new String[5];
    //colorArray
    colorArray[0] = "null";
    colorArray[1] = "Green";
    colorArray[2] = "Red";
    colorArray[3] = "Blue";
    colorArray[4] = "Purple";


    //***INITIALISE***
    public static void main ( String[] args ){
	Scanner s = new Scanner( System.in );
        String n;
	int subject;
	int food;
	int color;
	System.out.println("LumuSeal Inc. Presents: Stuyrule Warriors");
	System.out.println("Please enter your name: ");
	n = s.nextLine();
	System.out.println("Welcome to Stuyvesant, " + n + ", what's your most favorite subject out of these four? \n (1) Math \n (2) English \n (3) Computer Science \n (4) History");
        subject = s.nextInt();
	System.out.println("So you're a " + subjectArray[subject] + " buff. But whaddya like to eat while you're studying? \n (1) Sushi \n (2) Starbucks \n (3) Curry \n (4) Popcorn Chicken");
	food = s.nextInt();
	System.out.println("Too bad they're not serving " + foodArray[food] + " in the cafeteria. Last question before you go to homeroom- what's your favorite color out of these four? \n (1) Green \n (2) Red \n (3) Blue \n (4) Purple");
	color = s.nextInt();
    }
}
