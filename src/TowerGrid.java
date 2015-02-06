public class TowerGrid extends Grid{
	Tower tower; // what tower is on the grid *towers should not overlap 
	public TowerGrid(double x, double y,String nm){
		super(x, y, nm);
		this.can_place = true;
	}
}