public abstract class Tower{
	double x_pos;
	double y_pos;
	String name;
	Shape hit_box;
	int cost;
	int health;
	abstract void level_up();
	abstract void action(Creature[] creatures);
	abstract void draw();
}