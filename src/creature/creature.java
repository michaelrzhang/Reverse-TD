package creature;
import shape.*;
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

	abstract void action();
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