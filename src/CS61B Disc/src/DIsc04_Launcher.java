
public class DIsc04_Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal k = new Cat("aaa",10);
		k.greet();
		Animal a = new Animal("Pluto", 10);
		Cat c = new Cat("Garfield", 6);

	    a.greet(); // (A) Animal Pluto says Huh?
		c.greet(); // (B) Cat Garfield says Meow!
		           //     Dog Fido says WOOF!
		a = c;
		a.greet(); // (D) Cat Garfield says Meow!
		((Cat) a).greet(); // (E) Cat Garfield says Meow!
}
}