package src.actor.projectile;
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
		this.hit_box = new Circle(x_position, y_position, 0.3);
		this.honing = false;
	}
	
	public BasicProjectile(String name, double x_position, double y_position, Shape hit_box, Map map, 
		double x_velocity, double y_velocity, boolean honing){
		super(name, x_position, y_position, hit_box, 0, 1, map, x_velocity, y_velocity, honing);
	}
	
	public void action(double dt){
		move(dt);
		time_alive -= dt;
		if (time_alive == 0){
			remove();
		}
		update_shape();
	}
	private void move(double dt){
		x_position += x_velocity * dt;
		y_position += y_velocity * dt;
	}
}