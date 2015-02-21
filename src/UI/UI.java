package src.UI;
import src.shape.*;
import src.actor.creature.*;
import src.grid.*;
import src.map.*;
import src.*;
import java.util.ArrayList;
public abstract class UI implements Selectable{
	double x_position;
	double y_position;
	double x_length;
	double y_length;
	String name;
	Shape hit_box;
	UIGrid uigrid;
	Map map;
	public UI(Map map, double x_position, double y_position, double x_length
		double y_length, String name){

	}
	abstract void action(Creature[] creatures);
	abstract void draw();
	public void select(){}
}