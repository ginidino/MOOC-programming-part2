package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive {
	private String name;
	private int udder;
	private double amountOfMilk;
	private Random random = new Random();
	private static final String[] NAMES = new String[] {
	        "Anu", "Arpa", "Essi", "Heluna", "Hely",
	        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
	        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
	        "Mainikki", "Mella", "Mimmi", "Naatti",
	        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
	        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
	
	public Cow() {
		// creates a new cow with a random name
		this.udder = 15 + this.random.nextInt(40 - 15 + 1);
		int nameIndex = new Random().nextInt(NAMES.length);
		this.name = NAMES[nameIndex];
	}
	
	public Cow(String name) {
		// creates a new cow with its given name
		this.name = name;
		this.udder = 15 + this.random.nextInt(40 - 15 + 1);
	}
	
	public String getName() {
		// returns the cow's name
		return this.name;
	}
	
	public double getCapacity() {
		// returns the udder capacity
		return this.udder;
	}
	
	public double getAmount() {
		// returns the amount on milk available in the cow's udders
		return this.amountOfMilk;
	}
	
	public String toString() {
		return this.name + " " + this.amountOfMilk + "/" + this.udder;
	}
	
	@Override
	public double milk() {
		double milkAmount = this.amountOfMilk;
		this.amountOfMilk = 0;
		return milkAmount;
	}

	@Override
	public void liveHour() {
		double milk = Math.ceil((0.7 + (2 - 0.7)) * this.random.nextDouble());
		if (this.amountOfMilk + milk <= this.udder) {
			this.amountOfMilk += milk;
		}
	}
}
