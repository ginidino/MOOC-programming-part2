package TEST;

import java.util.HashMap;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String, String> num = new HashMap<String, String>();
		num.put("one", "일");
		num.put("two", "이");
		num.put("one", "하나");
		
		String translation = num.get("one");
		System.out.println(translation);
		
		System.out.println(num.get("two"));
		System.out.println(num.get("three"));
		System.out.println(num.get("four"));
	}
}
