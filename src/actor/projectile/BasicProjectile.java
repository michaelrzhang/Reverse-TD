package src.actor.projectile;
import src.shape.*;
import src.actor.creature.*;
import src.map.*;
import src.grid.*;
public class BasicProjectile extends Projectile{
	
	// mostly for testing purposes
	public BasicProjectile(String name, Map m){
		super(name, m);
		this.x_velocity = 5;
		this.y_velocity = 5;
		this.x_position = 5;
		this.y_position = 5;
		this.time_alive = 2;
		this.hit_box = new Circle(x_position, y_position, 0.3);
		this.honing = false;
	}
	
	public BasicProjectile(String name, double x_position, double y_position, Shape hit_box, Map map, 
		double x_velocity, double y_velocity, double x_acceleration, double y_acceleration, boolean honing){
		super(name, x_position, y_position, hit_box, 0, 1, map, x_velocity, y_velocity, x_acceleration, y_acceleration, honing);
		this.time_alive = 2;
	}
	
	public void updateCreature(Creature c){
		c.health -= 0.00001;
	}

	public void action(double dt){
		move(dt);
		checkCollision();
		time_alive -= dt;
		if (time_alive <= 0){
			remove();
		}
		update_shape();
	}
	private void move(double dt){
		// System.out.println("david did this");
		x_position += x_velocity * dt;
		y_position += y_velocity * dt;
		x_velocity += x_acceleration * dt;
		y_velocity += y_acceleration * dt;
	}
}