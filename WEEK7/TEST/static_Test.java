package TEST;

public class static_Test {
	public static void main(String[] args) {
		StaticVar obj = new StaticVar(); // 클래스를 찾아 객체를 생성 
		obj.pr(); 
		
		obj = new StaticVar(); 
		obj.pr(); // 객체 생성을 할 때마다 su1은 다시 메모리 할당을 한다
		
		obj = new StaticVar();
		obj.pr();
	}
}

class StaticVar {
	int su1 = 100; // 객체를 생성을 할 때마다 메모리 할당을 다시 한다.
	static int su2 = 100; // 객체 생성과는 관련 없다.
	
	public void pr() {
		System.out.println("su1(non-static) = " + su1++ + "\t" + "su2(static) = " + su2++);
	}
}
