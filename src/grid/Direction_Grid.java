package src.grid;
import src.creature.Creature;
import src.map.Map;
public class Direction_Grid extends Path_Grid{
	double x_direction; // unit vectors that give direction
	double y_direction;
	boolean isStart = false;
	boolean isEnd = false;
	Creature[] creatures = new Creature[100];
	public Direction_Grid(double x, double y,String nm, double xDirection, double yDirection, Map m){
		super(x, y, nm, m);
		double r = Math.sqrt(xDirection * xDirection + yDirection * yDirection);
		this.x_direction = xDirection / r;
		this.y_direction = yDirection / r;
	}
	public Direction_Grid(Grid g, Grid next){
		super(g.x_position, g.y_position, g.name, g.map);
		this.x_direction = next.x_position - this.x_position;
 		this.y_direction = next.y_position - this.y_position;
		double r = Math.sqrt(x_direction * x_direction + y_direction * y_direction);
		if (r==0){
			this.x_direction = 0;
			this.y_direction = 0;
		}
		else{
			this.x_direction = x_direction / r;
			this.y_direction = y_direction / r;
		}
	}
	public void setDirection(Creature c){
		double x_vel = c.get_x_velocity();
		double y_vel = c.get_y_velocity();
		double velocity = Math.sqrt(x_vel*x_vel + y_vel * y_vel);
		c.set_x_velocity(velocity * x_direction);
		c.set_y_velocity(velocity * y_direction);
	}
	public void setCreaturesDirection(){
		for (Creature c : creatures){
			if (c != null){
				setDirection(c);
			}
		}
	}
	public void setStart(){
		this.isStart = true;
	}
	public void setEnd(){
		this.isEnd = true;
	}
	public void set_Creature(Creature c){
		creatures[0] = c; // WE NEED ARRAYLISTS
	}
	public void remove_Creature(Creature c){
		creatures[0] = null; //WE NEED ARRAYLISTS
	}
	public String type(){
		return "Direction";
	}
	public void addCreature(Creature c){
		creatures[0] = c;
	}
}