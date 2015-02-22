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
	double xlength;
	double ylength;
	String name;
	Shape hit_box;
	UIGrid[][] uigrid;
	Map map;
	public UI(double x_position, double y_position, double x_length,
		double y_length, String name){
		this.map = map;
		this.x_position = x_position;
		this.y_position = y_position;
		this.xlength = x_length;
		this.ylength = y_length;
		this.name = name;
	}
	public abstract void draw();
	public void select(){}
	public double get_x_position(){
		return x_position;
	}
	public double get_y_position(){
		return y_position;
	}
	public double get_ylength(){
		return ylength;
	}
	public double get_xlength(){
		return xlength;
	}
	public void set_uigrid(UIGrid[][] uigrid){
		this.uigrid = uigrid;
	}
	public void set_Map(Map m){
		this.map = m;
	}

}