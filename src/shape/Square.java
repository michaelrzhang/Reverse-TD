package src.shape;
// import Color.*;
import lib.*;
public class Square extends Shape{
	// To-do Nonstatic method for overlap
	public Square(){
	}
	
	public Square(double x_pos, double y_pos, double radius){
		x_position = x_pos;
		y_position = y_pos;
		apothem = radius;
		name = "square";
	}
	
	public void draw(){
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledSquare(x_position, y_position, apothem);
	}

	public void drawTower(){
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledSquare(x_position, y_position, apothem);
	}
}