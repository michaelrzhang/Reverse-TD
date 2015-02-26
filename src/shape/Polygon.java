package src.shape;
import lib.*;
import java.awt.Color;
import java.awt.Graphics2D;
public class Polygon extends Shape{
	double x_position;
	double y_position;
	double[] x; // filler coordinates
	double[] y;
	double apothem;
	String name = "Polygon";

	// needs array of double coordinates to draw
	// write method to convert polygon to double coordinates given center and apothem?
	// should do if we need other polygons
	// 
	public Polygon(double x_pos, double y_pos, double apothem, Color c){
		super(apothem, c);
		x_position = x_pos;
		y_position = y_pos;
		x = new double[]{3, 4};// filler
		y = new double[]{2, 5};
	}

	public void draw(Graphics2D g2d){
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledPolygon(x, y);
	}
}