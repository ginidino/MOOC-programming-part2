package Ex39clicker.applicationlogic;

public class Exercise39 {
	public static void main(String[] args) {
		Calculator calc = new PersonalCalculator();
        System.out.println("Value: " + calc.giveValue());
        calc.increase();
        System.out.println("Value: " + calc.giveValue());
        calc.increase();
        System.out.println("Value: " + calc.giveValue());
	}
}
