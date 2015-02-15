package src.projectile;
import src.shape.*;
import src.map.*;
import src.grid.*;
public abstract class Projectile{
	String name;
	double x_velocity;
	double y_velocity;
	double x_position;
	double y_position;
	double time_alive;
	boolean honing;
	Shape hit_box;
	Map map;

	// potentially create a constructor based on tower launched from

	public Projectile(String name, double x_velocity, double y_velocity, double x_pos, 
		double y_pos, double time_alive, boolean honing, Shape hit_box, Map m){
		this.name = name;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
		this.x_position = x_pos;
		this.y_position = y_pos;
		this.time_alive = time_alive;
		this.honing = honing;
		this.hit_box = hit_box;
		this.map = m;
	}

	public Projectile(String name, Map m){
		this.name = name;
		this.map = m;
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