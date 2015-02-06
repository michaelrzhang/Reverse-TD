package grid;
import UI.*;
public class UI_Grid extends Grid{
	UI ui; // what ui objects are on grid *ui should not overlap
	public UI_Grid(double x, double y,String nm){
		super(x, y, nm);
		this.can_place = false;
	}
}