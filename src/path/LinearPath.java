package src.path;
import src.map.*;
import src.actor.creature.*;
public class LinearPath extends Path{
	int startx;
	int starty;
	int endx;
	int endy;
	double length;
	int xlength;
	int ylength;
	public LinearPath(Map m, Path p, int x0, int y0, int x1, int y1){
		super(m, p);
		startx = x0;
		starty = y0;
		endx= x1;
		endy= y1;
		length = Math.sqrt((x1-x0)*(x1-x0) + (y1-y0)*(y1-y0));
		xlength = (x1 - x0);
		ylength = (y1-y0);
	}
	public int x(double t){
		return (int) Math.round(t*xlength);
	}
	public int y(double t){
		return (int) Math.round(t*ylength);
	}
	// public int[] funct(double t){
	// 	return {x(t), y(t)};
	// }
	public double setPosition(Creature c, double dt, double timeOnPath){
		double v = c.get_velocity();
		double dist = v*dt;
		double t = dist/length + timeOnPath;
		if (t > 1){
			c.set_path(nextPath);
			nextPath.setPosition(c, t-1, 0);
		}
		c.set_x_position(x(t));
		c.set_y_position(y(t));
		return t;
	}
}