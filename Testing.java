public class Testing{
    public static void main(String[] args){
	Guy x = new Guy();
	Link l = new Link();
	l.attack(x);
	x.attack(l);
    }
}
