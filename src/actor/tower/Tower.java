package src.actor.tower;
import src.actor.*;
import src.shape.*;
import src.actor.creature.*;
import src.grid.*;
import src.map.*;
import src.actor.*;
public abstract class Tower extends Actor{
	double velocity; // initial velocity of projectiles fired
	double acceleration; // acceleration of projectiles fired
	double time_alive; // how long projectiles fired last for 
	boolean honing;
	TowerGrid[][] tg;

	public Tower(String name, double x_position, double y_position, Shape hit_box, 
		int cost, int health, Map map, TowerGrid[][] tg, boolean honing, double acceleration){
		super(name, x_position, y_position, hit_box, cost, health, map);
		this.velocity = velocity;
		this.acceleration = acceleration;
		this.honing = honing;
		this.tg = tg;
	}

	public Tower(String name, Map map){
		super(name, map);
	}

	// abstract void level_up(); 
	// abstract void action(Creature[] creatures);  IMPLEMENT for honing
	// 
	
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
	public void select(){}
}