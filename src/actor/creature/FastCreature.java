package src.actor.creature;
import src.shape.*;
import src.map.*;
import src.grid.*;
import src.player.*;
import java.awt.Color;
public class FastCreature extends Creature{
	// Color color = StdDraw.RED;
	public FastCreature(String name, Map map){
		super(name, map);
		this.dg = map.get_start();
		this.x_position = dg.get_x_position();
		this.y_position = dg.get_y_position();
		hit_box = new Square(x_position, y_position, 10, Color.ORANGE);
		cost = 2;
		health = 2;
		velocity = 120;
	}

	public FastCreature(String name, int x_position, int y_position, Map map, DirectionGrid dg){
		super(name, x_position, y_position, new Square(x_position, y_position, 10, Color.ORANGE), 1, 1, map, 1.0, 1.0, dg);
		cost = 2;
		health = 2;
		velocity = 120;
	}
	
	public FastCreature(String name){
		super(name);
		hit_box = new Square(x_position, y_position, 10, Color.ORANGE);
		cost = 2;
		health = 2;
		velocity = 120;
	}
	public void copy(Player p){
		p.buyActor(new FastCreature("testcreature", p.map));
	}

	public void action(double dt){
		move(dt);
		time_alive += dt;
		if (health == 0){
			remove();
		}
		update_shape();
	}
	private void move(double dt){
		// x_position += x_velocity * dt;
		// y_position += y_velocity * dt;
		// dg.remove_Creature(this);
		// dg = (DirectionGrid) map.closestGrid(x_position,y_position);  // grid is null here
		// dg.addCreature(this);
		timeOnPath = path.setPosition(this, dt, timeOnPath);
	}
}