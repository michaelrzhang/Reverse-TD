package src.shape;
import lib.*;
public class Circle extends Shape{

	public Circle(double apothem){
		super(apothem);
	}

	public Circle(double x_pos, double y_pos, double radius){
		x_position = x_pos;
		y_position = y_pos;
		apothem = radius;
		name = "Circle";
	}

	public void draw(){
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledCircle(x_position, y_position, apothem);
	}
	
	public void draw(String color){
		super.setColor(color);
		StdDraw.filledSquare(x_position, y_position, apothem);
	}


}
