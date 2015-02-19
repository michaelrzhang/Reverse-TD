package src.grid;
import src.UI.*;
import src.map.*;
public class UIGrid extends Grid{
	UI ui; // what ui objects are on grid *ui should not overlap
	public UIGrid(double x, double y,String nm, Map m){
		super(x, y, nm, m);
		this.can_place = false;
	}
	public String type(){
		return "UI";
	}
}