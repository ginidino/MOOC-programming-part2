package Week12;

// Exercise 48: String builder
public class Exercise48 {
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(build(num));
	}

	public static String build(int[] num) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < num.length; i++) {
			if (i % 4 == 0) {
				sb.append("\n");
			}
			
			sb.append(num[i]);
			
			if (i != (num.length - 1)) {
				sb.append(", ");
			}
		}
		return sb.append("\n}").toString();
	}
}
