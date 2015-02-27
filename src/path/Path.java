package src.path;
import src.actor.creature.*;
import src.map.*;
public abstract class Path{
	Path nextPath;
	Map map;
	public Path(Map m){
		this.map = m;
	}
	public Path(Map m, Path p){
		this.map = m;
		this.nextPath = p;
	}
	public abstract double setPosition(Creature c, double dt, double timeOnPath);
}