package src.creature;
import src.shape.*;
import src.map.*;
import src.grid.*;
public abstract class Creature{
	String name;
	int health;
	double x_velocity;
	double y_velocity;
	double x_position;
	double y_position;
	double time_alive;
	int cost;
	int level;
	Shape hit_box;
	DirectionGrid grid;  // grid is used to move correctly
	Map map;
	public Creature(double x_pos, double y_pos, DirectionGrid dg, Map m, String nm){
		this.x_position = x_pos;
		this.y_position = y_pos;
		this.name = nm;
		this.grid = dg;
		this.map = m;
		this.grid.set_Creature(this);
	}
	public Creature(Map m, String nm){
		this.map = m;
		this.name = nm;
		this.grid = m.get_start();
		this.x_position = grid.get_x_position();
		this.y_position = grid.get_y_position();
	}
	public abstract void action(double dt);
	public abstract void draw();
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