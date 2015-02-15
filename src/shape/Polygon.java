package src.shape;
public class Polygon{
	double x_position;
	double y_position;
	double apothem;
	String name = "Polygon";

	// needs array of double coordinates to draw
	// write method to convert polygon to double coordinates given center and apothem?
	// should do if we need other polygons
	public Polygon(double x_pos, double y_pos, double apothem){
		x_position = x_pos;
		y_position = y_pos;
		this.apothem = apothem;


	public void draw(){
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledPolygon(x_position, y_position, apothem);
	}
}