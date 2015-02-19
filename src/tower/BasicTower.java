package src.tower;
import src.shape.*;
import src.creature.*;
import src.map.*;
import src.grid.*;
import src.projectile.*;

public class BasicTower extends Tower{
	// tower that fires nonhoning projectiles
	public double fire_time = 0.5;
	public double next_fire_time;
	// tower that fires nonhoning projectiles
	public BasicTower(String name, Map m){
		super(name, m);
		this.x_position = 5;
		this.y_position = 5;
		this.velocity = 4;
		this.acceleration = 2;
		this.time_alive = 5;
		this.hit_box = new Square(x_position, y_position, 0.3);
		this.honing = false;
		this.cost = 0;
		this.health = 100;
		this.next_fire_time = fire_time;
	}
	
	public void action(double dt){
		next_fire_time -= dt;
		if (next_fire_time < 0){
			next_fire_time = fire_time;
			shoot_projectile();
		}
		update_shape();
	}

	public void shoot_projectile(){
		double actual_velocity = this.velocity / Math.sqrt(2);
		map.addProjectile(new BasicProjectile("basic", actual_velocity, actual_velocity, x_position, y_position,
			time_alive, false, new Circle(x_position, y_position, 0.1), map));
		map.addProjectile(new BasicProjectile("basic", -1*actual_velocity, actual_velocity, x_position, y_position,
			time_alive, false, new Circle(x_position, y_position, 0.1), map));		
		map.addProjectile(new BasicProjectile("basic", actual_velocity, -1*actual_velocity, x_position, y_position,
			time_alive, false, new Circle(x_position, y_position, 0.1), map));	
		map.addProjectile(new BasicProjectile("basic", -1*actual_velocity, -1*actual_velocity, x_position, y_position,
			time_alive, false, new Circle(x_position, y_position, 0.1), map));
	}
	
	public void draw(){
		((Square) hit_box).drawTower(); // CASTING here for testing purposes
	}

	private void remove(){
		map.remove(this);
	}
	private void update_shape(){
		hit_box.set_X(this.x_position);
		hit_box.set_Y(this.y_position);
	}
}	