package Ex42movingfigure;

import java.awt.Graphics;
import java.util.ArrayList;

public class CompoundFigure extends Figure {
	private ArrayList<Figure> comFigure;

	public CompoundFigure() {
		super(1, 1);
		this.comFigure = new ArrayList<Figure>();
	}

	public void add(Figure f) {
		this.comFigure.add(f);
	}
	
	@Override
    public void move(int x, int y) {
		for (Figure figure : this.comFigure) {
			figure.move(x, y);
		}
	}
	
	@Override
	public void draw(Graphics graphics) {
		for (Figure figure : this.comFigure) {
			figure.draw(graphics);
		}
	}
}