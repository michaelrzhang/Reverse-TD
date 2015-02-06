package projectile;
public abstract class projectile{
	String name;
	double x_velocity;
	double y_velocity;
	double x_position;
	double y_position;
	double time_alive;
	boolean honing;
	Shape hit_box;

	abstract void action();
	abstract void draw();

}