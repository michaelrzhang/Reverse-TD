package src.shape;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shape{
	// SHOULD TEST/CONSIDER IMPROVEMENTs to overlap
	// Generic polygon class?
	double x_position;  // these should be the coordinates of the center
	double y_position;
	double apothem;
	String name;
	Color color;

	// no argument constructor (so that it will compile)

	public Shape(double apothem, Color c){
		this.apothem = apothem;
		this.color = c;
	}

	/**
	 * Returns whether or not two shapes overlap
	 */
	// public static boolean overlaps(Shape a, Shape b){
	// // two regular polygons hard
	// 	double distance = getDistance(a, b);
	// 	double delta_x = a.x_position - b.x_position;
	// 	double delta_y = a.y_position - b.y_position;
	// 	// should be the minimum of apothem/cos(theta_x) because
	// 	// the direct distance that is inside the shape is shorter
	// 	// when the ratio between delta_y/delta_x is more extreme
	// 	double theta1 = Math.abs(Math.atan(delta_y/delta_x));
	// 	double theta2 = Math.abs(Math.atan(delta_y/delta_x));
	// 	double cosine_theta = Math.max(Math.cos(theta1), Math.cos(theta2));
	// 	double a_distance, b_distance;
	// 	if (a.name.equals("circle")){
	// 		a_distance = a.apothem;
	// 	}
	// 	else{
	// 		a_distance = a.apothem / cosine_theta;
	// 	}
	// 	if (b.name.equals("circle")){
	// 		b_distance = b.apothem;
	// 	}
	// 	else{
	// 		b_distance = b.apothem / cosine_theta;
	// 	}

	// 	if (a_distance + b_distance >= distance){
	// 		return true;
	// 	}
	// 	return false;
	// }
	// 
	public static boolean overlaps(Shape a, Shape b){
		double distance = getDistance(a, b);
		double a_distance, b_distance;
		if (a.name.equals("circle")){
			a_distance = a.apothem;
		}
		else{
			a_distance = a.apothem * Math.sqrt(2);
		}
		if (b.name.equals("circle")){
			b_distance = b.apothem;
		}
		else{
			b_distance = b.apothem * Math.sqrt(2);
		}
		if (a_distance + b_distance >= distance){
			return true;
		}
		return false;
	}
	

	/**
	 * Returns distance between two different shapes
	 */
	public static double getDistance(Shape a, Shape b){
		double delta_x = a.x_position - b.x_position;
		double delta_y = a.y_position - b.y_position;
		return Math.sqrt(delta_x * delta_x + delta_y * delta_y);
	}
	public void set_X(double x){
		this.x_position = x;
	}
	public void set_Y(double y){
		this.y_position = y;
	}
	public double getX(){
		return this.x_position;
	}
	public double getY(){
		return this.y_position;
	}

	public abstract void draw(Graphics2D g2d);

	// public void setColor(String color){
	// 	if (color.equals("red"))
	// 		StdDraw.setPenColor(new Color(255,   0,   0));   // red
	// 	if (color.equals("green"))
	// 		StdDraw.setPenColor(new Color(  0, 255,   0));   // green
	// 	if (color.equals("blue"))
	// 		StdDraw.setPenColor(new Color(  0,   0, 255));   // blue
	// 	if (color.equals("yellow"))
	// 		StdDraw.setPenColor(new Color(255, 255,   0));   // yellow
	// 	if (color.equals("white"))
	// 		StdDraw.setPenColor(new Color(255, 255, 255));   // white
	// 	if (color.equals("black"))
	// 		StdDraw.setPenColor(new Color(  0,   0,   0));   // black
	// 	if (color.equals("gray"))
	// 		StdDraw.setPenColor(new Color(100, 100, 100));   // gray
	// }
	// // http://www.rapidtables.com/web/color/RGB_Color.htm
	// // Use to determine RGB color
	// public void setColor(int r, int g, int b){
	// 	StdDraw.setPenColor(new Color(r,g,b));   // red		
	// }

}