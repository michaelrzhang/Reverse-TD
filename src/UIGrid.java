public class UIGrid extends Grid{
	UI ui; // what ui objects are on grid *ui should not overlap
	public UIGrid(double x, double y,String nm){
		super(x, y, nm);
		this.can_place = false;
	}
}