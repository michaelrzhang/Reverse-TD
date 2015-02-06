public class Movable_Grid extends Grid{
	double x_direction;
	double y_direction;
	boolean isStart = false;
	boolean isEnd = false;
	Creature[] creatures = new Creature[100];
	public Movable_Grid(double x, double y,String nm, double xDirection, double yDirection){
		super(x, y, nm);
		this.x_direction = xDirection;
		this.y_direction = yDirection;
		this.can_place = false;
	}
	public Movable_Grid(Grid g, Grid next){
		super(g.x_position, g.y_position, g.name);
		this.x_direction = this.x_position - next.x_position;
		this.y_direction = this.y_position - next.y_position;
		this.can_place = false;
	}
	public void setDirection(Creature c){
		double velocity = Math.sqrt(c.x_velocity*c.x_velocity + c.y_velocity * c.y_velocity);
		double r = Math.sqrt(x_direction*x_direction + y_direction*y_direction);
		c.x_velocity = velocity * x_direction / r;
		c.y_velocity = velocity * y_direction / r;
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
}