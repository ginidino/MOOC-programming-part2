package TEST;

public class Exercise04_8Test {
	public static void main(String[] args) {
		Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
	}
	
	public static void addSuitcasesFullOfBricks(Container containers) {
		for (int i = 1; i <= 100; i++) {
			Thing brick = new Thing("Brick", i);
			Suitcase brickCase = new Suitcase(i + 1);
			
			brickCase.addThing(brick);
			containers.addSuitcase(brickCase);
		}
	}
}
