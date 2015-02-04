public abstract class Creature{
	String name;
	int health;
	double x_velocity;
	double y_velocity;
	double x_position;
	double y_position;
	int cost;
	int level;
	Shape hit_box;

	abstract void action();
	abstract void draw();

}