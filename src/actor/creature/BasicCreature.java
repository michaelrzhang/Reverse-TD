package src.actor.creature;
import src.shape.*;
import src.map.*;
import src.grid.*;
public class BasicCreature extends Creature{
	// Color color = StdDraw.RED;
	Shape BasicShape = new Square(0.5);
	public BasicCreature(String name, Map map){
		super(name, map);
		this.dg = map.get_start();
		this.x_position = dg.get_x_position();
		this.y_position = dg.get_y_position();
		this.hit_box = new Square(x_position, y_position, 0.5);
		this.cost = 1;
		this.health = 1;
		this.x_velocity = 10;
		this.y_velocity = 0;
		
	}

	public BasicCreature(String name, double x_position, double y_position, Map map, DirectionGrid dg){
		super(name, x_position, y_position, new Square(x_position, y_position, 0.5), 1, 1, map, 1.0, 1.0, dg);
	}
	
	public BasicCreature(String name){
		super(name);
		this.cost = 1;
		this.health = 1;
		this.hit_box = new Square(0.5);
	}

	public void action(double dt){
		move(dt);
		time_alive += dt;
		if (health <= 0){
			remove();
		}
		update_shape();
	}
	private void move(double dt){
		x_position += x_velocity * dt;
		y_position += y_velocity * dt;
		dg.remove_Creature(this);
		dg = (DirectionGrid) map.closestGrid(x_position,y_position);  // grid is null here
		dg.addCreature(this);
	}
}