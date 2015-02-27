package src.actor.creature;
import src.actor.*;
import src.shape.*;
import src.map.*;
import src.grid.*;
import src.player.*;
import src.path.*;
public abstract class Creature extends Actor{  // SHOULD THIS EXTE
	double velocity;
	int level = 1;
	double time_alive = 0;
	double timeOnPath = 0;
	Path path;
	public Creature(String name, int x_position, int y_position, 
		Shape hit_box, int cost, int health, Map map, double velocity, Path p){
		super(name, x_position, y_position, hit_box, cost, health, map);
		this.velocity = velocity;
		this.path = p;
	}
	public abstract void copy(Player p);
	public Creature(String name, Map map){
		super(name, map);
	}
	public Creature(String name){
		super(name);
	}
	// public double get_x_velocity(){
	// 	return x_velocity;
	// }
	// public double get_y_velocity(){
	// 	return y_velocity;
	// }
	// public void set_x_velocity(double x){
	// 	this.x_velocity = x;
	// }
	// public void set_y_velocity(double y){
	// 	this.y_velocity = y;
	// }
	// public void set_x_position(int x){
	// 	this.x_position = x;
	// }
	// public void set_y_velocity(int y){
	// 	this.y_position = y;
	// }
	public void set_velocity(double v){
		velocity = v;
	}
	public double get_velocity(){
		return velocity;
	}
	public void set_path(Path p){
		this.path = p;
	}
	public void set_y_position(int y){
		y_position = y;
	}	
	public void set_x_position(int x){
		x_position = x;
	}
	public void select(){}
	// public double get_velocity(){
	// 	return Math.sqrt(x_velocity*x_velocity + y_velocity*y_velocity);
	// }
}