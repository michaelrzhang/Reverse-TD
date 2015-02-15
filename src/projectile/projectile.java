package projectile;
public abstract class Projectile{
	String name;
	double x_velocity;
	double y_velocity;
	double x_position;
	double y_position;
	double time_alive;
	boolean honing;
	Shape hit_box;
	Direction_Grid grid;
	Map map;

	public Projectile(double x_pos, double y_pos, Direction_Grid dg, Map m, String name, boolean honing){
		this.x_position = x_pos;
		this.y_position = y_pos;
		this.name = name;
		this.grid = dg;
		this.map = m;
		this.grid.set_Creature(this);
		this.honing = honing;
	}

	public Projectile(Map m, String name){
		this.map = m;
		this.name = name;
		this.grid = m.get_start();
		this.x_position = grid.get_x_position();
		this.y_position = grid.get_y_position();
	}

	abstract void action(double dt);
	abstract void draw();
	public double get_x_velocity(){
		return x_velocity;
	}
	public double get_y_velocity(){
		return y_velocity;
	}
	public void set_x_velocity(double x){
		this.x_velocity = x;
	}
	public void set_y_velocity(double y){
		this.y_velocity = y;
	}

}