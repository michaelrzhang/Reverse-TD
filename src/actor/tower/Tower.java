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
	double range;
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

	public Creature getClosestCreature(){
		ArrayList<Creature> creatures = map.getCreatures();
		if (creatures.isEmpty()){
			return null;
		}
		Creature closest_creature = creatures.get(0);
		double closest_distance = Shape.getDistance(closest_creature.hit_box, this.hit_box);
		double temp_distance;
		for (Creature c : creatures){
			temp_distance = Shape.getDistance(c.hit_box, this.hit_box);
			if (temp_distance < closest_distance){
				closest_distance = temp_distance;
				closest_creature = c;
			}
		}
		return closest_creature;
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