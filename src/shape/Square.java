package shape;
public class Square{
	// To-do Nonstatic method for overlap
	double x_position;
	double y_position;
	double apothem;
	String name = "square";
	
	public Square(double x_pos, double y_pos, double radius){
		x_position = x_pos;
		y_position = y_pos;
		apothem = radius;
	}
}