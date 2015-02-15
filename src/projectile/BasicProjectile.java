package src.projectile;
import src.shape.*;
import src.map.*;
import src.grid.*;
// import Color.*;
public class BasicProjectile extends Projectile{
	
	// mostly for testing purposes
	public BasicProjectile(String name, Map m){
		super(name, m);
		this.x_velocity = 5;
		this.y_velocity = 5;
		this.x_position = 5;
		this.y_position = 5;
		this.time_alive = 5;
		this.hit_box = new Circle(x_position, y_position, 0.5);
		this.honing = false;
	}
	
	public BasicProjectile(String name, double x_velocity, double y_velocity, double x_pos, double y_pos, double time_alive, boolean honing, Shape hit_box, Map m){
		super(name, x_velocity, y_velocity, x_pos, y_pos, time_alive, honing, hit_box, m);
	}
	
	public void action(double dt){
		move(dt);
		time_alive -= dt;
		if (time_alive == 0){
			remove();
		}
		update_shape();
	}
	public void draw(){
		hit_box.draw();
	}
	private void move(double dt){
		x_position += x_velocity * dt;
		y_position += y_velocity * dt;
	}
	private void remove(){
		map.remove(this);
	}
	private void update_shape(){
		hit_box.set_X(this.x_position);
		hit_box.set_Y(this.y_position);
	}
}