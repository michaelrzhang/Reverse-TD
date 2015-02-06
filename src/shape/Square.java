package shape;
public abstract class Square{
	double x_position;
	double y_position;
	double apothem;
	String name = "square";
	abstract boolean is_overlapped(Shape s);
}