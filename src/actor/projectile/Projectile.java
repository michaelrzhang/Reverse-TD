package src.actor.projectile;
import src.actor.*;
import src.actor.creature.*;
import src.shape.*;
import src.map.*;
import src.grid.*;

import java.util.ArrayList;

public abstract class Projectile extends Actor{
	double x_velocity;
	double y_velocity;
	double time_alive;
	boolean honing;

	// potentially create a constructor based on tower launched from

	public Projectile(String name, double x_position, double y_position, 
		Shape hit_box, int cost, int health, Map map, double x_velocity, double y_velocity, boolean honing){
		super(name, x_position, y_position, hit_box, cost, health, map);
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
		this.honing = honing;
	}

	public void checkCollision(){
	// makes sure projectile dies
		ArrayList<Creature> creatures = map.getCreatures();
		for (Creature c : creatures){
			if (Shape.overlaps(c.hit_box, this.hit_box)){
				System.out.println("found creature");
				updateCreature(c);
				remove();
				break;
			}
		}
	}

	// creature dies when health is 0
	public void updateCreature(Creature c){
	}

	// potentially destroys creature when its life is 0
	public void updateCreature(){
	}


	public Projectile(String name, Map map){
		super(name, map);
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
}