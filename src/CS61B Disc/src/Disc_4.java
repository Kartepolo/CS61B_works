


public class Disc_4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Disc_4 a = new Disc_4();
		a.AnimalLauncher();
	}
	public void AnimalLauncher(){
		Animal K  = new Cat("LOLO",10);
		K.makeNoise();
	}
	public class Animal {
		protected String name, noise;
		protected int age;
		
		public Animal(String name, int age) {
		this.name = name;
		this.age = age;
		this.noise = "Huh?";
		}
		
		 public String makeNoise() {
		 if (age < 5) {
		 return noise.toUpperCase();
		} else {
		return noise;
		}
		}
		
		public void greet() {
		System.out.println("Animal " + name + " says: " + makeNoise());
		}
		}
		public class Cat extends Animal {
			public Cat(String name,int age){
				super(name,age);
				this.name = name;
				this.age = age;
				this.noise = "Meow";
			}
			public void greet() {
				System.out.println("Cats " + name + " says: " + makeNoise());
				}
		}
}
