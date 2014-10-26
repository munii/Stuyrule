public class Link extends Character {
    public String location;
    public String favoriteSubject;
    public String favoriteFood;
   
    //Constructors
    public Link() {
	super();
	name = "Link";
	favoriteSubject = "Computer Science ";
	favoriteFood = "Sushi ";
        accuracy = 95;
	multiplier = 2.0;
    }
    public Link(String n,String s,String f) {
	super();
	name = n;
	favoriteSubject = s; //Should we account for the case where someone puts in string like "xxx"?
	favoriteFood = f;
	accuracy = 95;
	multiplier = 2.0;
    }
    //ToString
    //Just to make sure the code actually works
    //is there a more efficient way to do this?
    public String toString () {
	String s = super.toString();
	s += "\n" + "Defense =" + " " + defense + " ";
	s += "\n" + "Location is" + " " + location + " ";
	s += "\n" + Favorite Food is" + " " + favoriteFood + " ";
	s += "\n" + "Favorite Subject is" + " " + favoriteSubject + " ";
	return s;
    }
    //Methods
    //Are there any Link Specific Methods?
}
