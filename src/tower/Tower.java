package src.tower;
import src.shape.*;
import src.creature.*;
public abstract class Tower{
	String name;
	double x_position;
	double y_position;
	double velocity; // initial velocity of projectiles fired
	double acceleration; // acceleration of projectiles fired
	double time_alive; // how long projectiles fired last for
	Shape hit_box; // for size of projectiles
	boolean honing;
	int cost;
	int health;
	Map map;

	public Tower(String name, double x_position, double y_position, Shape hit_box, 
		boolean honing, int cost, int health, Map map){
		this.name = name;
		this.x_position = x_pos;
		this.y_position = y_pos;
		this.velocity = velocity;
		this.acceleration = acceleration;
		this.time_alive = time_alive;
		this.hit_box = hit_box;
		this.honing = honing;
		this.cost = cost;
		this.health = health;
		this.map = m;
	}

	public Tower(String name, Map m){
		this.name = name;
		this.map = m;
	}

	abstract void level_up();
	abstract void action(Creature[] creatures);
	abstract void draw();
	
	public double get_x_position(){
		return x_position;
	}
	public double get_y_position(){
		return y_position;
	}
	public void set_x_position(double x){
		this.x_position = x;
	}
	public void set_y_position(double y){
		this.y_position = y;
	}
}