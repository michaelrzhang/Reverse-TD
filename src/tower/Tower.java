public abstract class Tower{
	double x_position;
	double y_position;
	String name;
	Shape hit_box;
	int cost;
	int health;
	abstract void level_up();
	abstract void action(Creature[] creatures);
	abstract void draw();
}