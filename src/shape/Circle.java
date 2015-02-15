package src.shape;
import lib.*;
public class Circle extends Shape{
	String name = "Circle";

	public Circle(double x_pos, double y_pos, double radius){
		x_position = x_pos;
		y_position = y_pos;
		apothem = radius;
	}

	public void draw(){
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledCircle(x_position, y_position, apothem);
	}


}
