package src.UI;
import src.shape.*;
import src.creature.*;
public abstract class UI{
	double x_position;
	double y_position;
	String name;
	Shape hit_box;
	abstract void action(Creature[] creatures);
	abstract void draw();
}