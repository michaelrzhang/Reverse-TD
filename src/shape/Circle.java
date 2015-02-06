package shape;
public abstract class Circle{
	double x_position;
	double y_position;
	double apothem;
	String name = "Circle";
	abstract boolean is_overlapped(Shape s);
}