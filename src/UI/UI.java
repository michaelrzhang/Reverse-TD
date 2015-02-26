package src.UI;
import src.shape.*;
import src.actor.creature.*;
import src.grid.*;
import src.map.*;
import src.*;
import java.util.ArrayList;
import java.awt.Graphics2D;
public abstract class UI implements Selectable{
	int x_position;
	int y_position;
	int xlength;
	int ylength;
	String name;
	Shape hit_box;
	UIGrid[][] uigrid;
	Map map;
	public UI(int x_position, int y_position, int x_length,
		int y_length, String name){
		this.map = map;
		this.x_position = x_position;
		this.y_position = y_position;
		this.xlength = x_length;
		this.ylength = y_length;
		this.name = name;
	}
	public abstract void draw(Graphics2D g2d);
	public void select(){}
	public int get_x_position(){
		return x_position;
	}
	public int get_y_position(){
		return y_position;
	}
	public int get_ylength(){
		return ylength;
	}
	public int get_xlength(){
		return xlength;
	}
	public void set_uigrid(UIGrid[][] uigrid){
		this.uigrid = uigrid;
	}
	public void set_Map(Map m){
		this.map = m;
	}

}