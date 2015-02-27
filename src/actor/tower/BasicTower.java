package src.actor.tower;
import src.shape.*;
import src.actor.creature.*;
import src.map.*;
import src.grid.*;
import src.actor.projectile.*;
import java.awt.Color;

public class BasicTower extends Tower{
	// tower that fires nonhoning projectiles
	public double fire_time = 0.5;
	public double next_fire_time;
	// tower that fires nonhoning projectiles
	public BasicTower(String name, Map m){
		super(name, m);
		this.x_position = 5;
		this.y_position = 5;
		this.velocity = 10;
		this.acceleration = 2;
		this.time_alive = 5;
		this.hit_box = new Square(x_position, y_position, 3, Color.GREEN);
		this.honing = false;
		this.cost = 10;
		this.health = 100;
		this.next_fire_time = fire_time;
	}
	public BasicTower(String name, Map m, int x_position, int y_position){
		super(name, m);
		this.x_position = x_position;
		this.y_position = y_position;
		this.velocity = 10;
		this.acceleration = 2;
		this.time_alive = 5;
		this.hit_box = new Square(x_position, y_position, 3, Color.GREEN);
		this.honing = false;
		this.cost = 10;
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
		double actual_acceleration = this.acceleration / Math.sqrt(2);
		map.addActor(new BasicProjectile("basic", x_position, y_position, new Circle(x_position, y_position, 0.4), 
			map, actual_velocity, actual_velocity, actual_acceleration, actual_acceleration, false));
		map.addActor(new BasicProjectile("basic", x_position, y_position, new Circle(x_position, y_position, 0.4), 
			map, -1*actual_velocity, actual_velocity, actual_acceleration, actual_acceleration, false));
		map.addActor(new BasicProjectile("basic", x_position, y_position, new Circle(x_position, y_position, 0.4), 
			map, actual_velocity, -1*actual_velocity, actual_acceleration, actual_acceleration, false));
		map.addActor(new BasicProjectile("basic", x_position, y_position, new Circle(x_position, y_position, 0.4), 
			map, -1*actual_velocity, -1*actual_velocity, actual_acceleration, actual_acceleration, false));

	
	// public void draw(){
	// 	((Square) hit_box).drawTower(); // CASTING here for testing purposes
	// }
}	