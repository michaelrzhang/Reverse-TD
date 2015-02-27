package src.actor.projectile;
import src.shape.*;
import src.actor.creature.*;
import src.map.*;
import src.grid.*;
public class HoningProjectile extends Projectile{
	
	// mostly for testing purposes
	public HoningProjectile(String name, Map m){
		super(name, m);
		this.x_velocity = 10;
		this.y_velocity = 10;
		this.x_position = 5;
		this.y_position = 5;
		this.time_alive = 2;
		this.hit_box = new Circle(x_position, y_position, 0.3);
		this.honing = true;
	}
	
	public HoningProjectile(String name, double x_position, double y_position, Shape hit_box, Map map, 
		double x_velocity, double y_velocity, double x_acceleration, double y_acceleration, boolean honing){
		super(name, x_position, y_position, hit_box, 0, 1, map, x_velocity, y_velocity, x_acceleration, y_acceleration, true);
		this.time_alive = 2;
	}
	
	public void updateCreature(Creature c){
		c.health -= 0.00001;
	}

	public void action(double dt){
		update_velocity();
		move(dt);
		checkCollision();
		time_alive -= dt;
		if (time_alive <= 0){
			remove();
		}
		update_shape();
	}

	public void update_velocity(){ //cats are so cool i don't even know man what huh haha yes. -ako
		Creature target = super.getClosestCreature();
		if (target == null){
			return;
		}
		System.out.println("honing");
		double x_direction = target.hit_box.getX() - this.hit_box.getX();
		double y_direction = target.hit_box.getY() - this.hit_box.getY();
		double curr_velocity = super.getOverallVelocity();

		// ***For debugging
		// System.out.println(target.hit_box.getX());
		// System.out.println(this.hit_box.getX());
		// System.out.println(x_direction);
		// System.out.println(target.hit_box.getY());
		// System.out.println(this.hit_box.getY());
		// System.out.println(y_direction);
		// System.out.println(curr_velocity);
		
		// set_x_velocity(curr_velocity * x_direction / (x_direction * x_direction + y_direction * y_direction));
		// set_y_velocity(curr_velocity * y_direction / (x_direction * x_direction + y_direction * y_direction));
		// trying to get direction working
		set_x_velocity(curr_velocity * x_direction / Math.sqrt((x_direction * x_direction + y_direction * y_direction)));
		set_y_velocity(curr_velocity * y_direction / Math.sqrt((x_direction * x_direction + y_direction * y_direction)));
	}

	private void move(double dt){
		// System.out.println("angela is cool");
		x_position += x_velocity * dt;
		y_position += y_velocity * dt;
	}
}