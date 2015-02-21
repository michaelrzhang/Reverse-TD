package src.grid;
import src.UI.*;
import src.map.*;
import src.grid.*;
public class UIGrid extends Grid{
	UI ui; // what ui objects are on grid *ui should not overlap
	public UIGrid(double x, double y,String nm, Map m, UI ui){
		super(x, y, nm, m);
		this.can_place = false;
		this.ui = ui;
	}
	public UIGrid(Grid g, UI ui){
		super(g.x_position, g.y_position, g.name, g.map);
		this.can_place = false;
		this.ui = ui;
	}
	public String type(){
		return "UI";
	}
}