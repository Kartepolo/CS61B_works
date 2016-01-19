		public class Cat extends Animal {
			public Cat(String name,int age){
				super(name,age);
				this.noise = "Meow!";
			}
			public void greet() {
				System.out.println("Cats " + name + " says: " + makeNoise());
				}
		}
