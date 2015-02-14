package src.creature;
import src.shape.*;
import src.map.*;
import src.grid.*;
// import Color.*;
public class Basic_Creature extends Creature{
	int health = 1;
	double time_alive = 0;
	int cost = 1;
	int level = 1;
	// Color color = StdDraw.RED;
	public Basic_Creature(Map m, String nm){
		super(m,nm);
		this.hit_box = new Square(x_position, y_position, 0.5);
		this.x_velocity = 20;
		this.y_velocity = 0;
	}

	public Basic_Creature(double x_pos, double y_pos, Direction_Grid dg, Map m, String nm){
		super(x_pos, y_pos, dg, m, nm);
		this.hit_box = new Square(x_pos, y_pos, 0.5);
		this.x_velocity = 1;
		this.y_velocity = 1;
	}
	
	public void action(double dt){
		move(dt);
		time_alive += dt;
		if (health == 0){
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
		grid.remove_Creature(this);
		grid = (Direction_Grid) map.closestGrid(x_position,y_position);  // grid is null here
		grid.addCreature(this);
	}
	private void remove(){
		map.remove(this);
	}
	private void update_shape(){
		hit_box.set_X(this.x_position);
		hit_box.set_Y(this.y_position);
	}
}