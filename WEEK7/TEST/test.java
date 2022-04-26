package TEST;

public class test {
	public static void main(String[] args) {
		double a = 0.39;
		double b = 0.35;
		System.out.println(a - b);
		System.out.println();
		
		double distance = 0.04 - (a - b);
		System.out.println(distance);
		System.out.println(Math.abs(distance));
		System.out.println();
		
		if(Math.abs(distance) < 0.0001) {
			System.out.println("Successful comparison!");
		} else {
			System.out.println("Failed comparison!");
		}
	}
}
