package src.tower;
import src.shape.*;
import src.creature.*;
import src.map.*;
import src.grid.*;

public class BasicTower extends Tower{
	// tower that fires nonhoming projectiles
	public BasicTower(String name, Map m){
		super(name, m);
		this.x_position = 3;
		this.y_position = 3;
		this.velocity = 2;
		this.acceleration = 2;
		this.time_alive = 5;
		this.hit_box = new Square(x_position, y_position, 0.3);
		this.honing = false;
		this.cost = 0;
		this.health = 100;
	}
	
	public void action(double dt){
		// move(dt);
		// time_alive -= dt;
		// if (time_alive == 0){
		// 	remove();
		// }
		update_shape();
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