package src.shape;
// import Color.*;
import java.awt.Graphics2D;
import java.awt.Color;
public class Square extends Shape{
	// To-do Nonstatic method for overlap
	public Square(double apothem, Color color){
		super(apothem, color);
	}
	
	public Square(double x_pos, double y_pos, double apothem, Color color){
		super(apothem, color);
		x_position = x_pos;
		y_position = y_pos;
		name = "square";
	}
	
	public void draw(Graphics2D g2d){
		g2d.setColor(color);
		g2d.fillRect((int) x_position, (int) y_position, (int) (2*apothem),(int) (2*apothem));
	}

	// public void draw(String color){
	// 	super.setColor(color);
	// 	StdDraw.filledSquare(x_position, y_position, apothem);
	// }

	// public void drawTower(){
	// 	StdDraw.setPenColor(StdDraw.YELLOW);
	// 	StdDraw.filledSquare(x_position, y_position, apothem);
	// }
}