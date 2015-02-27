package src.actor.creature;
import src.actor.*;
import src.shape.*;
import src.map.*;
import src.grid.*;
import src.player.*;
public abstract class Creature extends Actor{  // SHOULD THIS EXTE
	DirectionGrid dg;
	double x_velocity;
	double y_velocity;
	int level = 1;
	double time_alive = 0;
	public Creature(String name, int x_position, int y_position, 
		Shape hit_box, int cost, int health, Map map, double x_velocity, 
		double y_velocity, DirectionGrid dg){
		super(name, x_position, y_position, hit_box, cost, health, map);
		this.dg = dg;
	}
	public abstract void copy(Player p);
	public Creature(String name, Map map){
		super(name, map);
	}
	public Creature(String name){
		super(name);
	}
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
	public void select(){}
	public double get_velocity(){
		return Math.sqrt(x_velocity*x_velocity + y_velocity*y_velocity);
	}
}