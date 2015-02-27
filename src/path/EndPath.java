package src.path;
import src.map.*;
import src.actor.creature.*;
public class EndPath extends Path{
	public EndPath(Map m){
		super(m);
	}
	public double setPosition(Creature c, double dt, double timeOnPath){
		map.remove(c);
		return -1.0;
	}
}