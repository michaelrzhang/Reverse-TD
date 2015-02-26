package src.shape;
import java.awt.Graphics2D;
import java.awt.Color;
public class Circle extends Shape{

	public Circle(double apothem, Color c){
		super(apothem, c);
	}

	public Circle(double x_pos, double y_pos, double apothem, Color c){
		super(apothem, c);
		x_position = x_pos;
		y_position = y_pos;
		name = "Circle";
	}

	public void draw(Graphics2D g2d){
		g2d.setColor(color);
		g2d.fillOval((int)x_position, (int)y_position,(int) (2*apothem), (int)(2*apothem));
	}
	// public void draw(String color){
	// 	super.setColor(color);
	// 	StdDraw.filledSquare(x_position, y_position, apothem);
	// }


}
