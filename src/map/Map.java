package src.map;
import src.grid.*;
public class Map{
	Grid[][] grid_Map;
	int grid_Size;
	int xMax_val;
	int yMax_val;
	double[][] path;
	Direction_Grid start; // where creatures enter
	Grid end; // where creature leave the map
	Direction_Grid[] dGrid = new Direction_Grid[grid_Size*10]; 
	public Map(double[][] p, int n, int xMax, int yMax){
		this.grid_Size = n;
		this.path = p;
		this.xMax_val = xMax;
		this.yMax_val = yMax;
		this.grid_Map = new Grid[this.grid_Size+2][this.grid_Size+2]; // there is a frame of null grids surrounding the grids u actually see
		for (int i = 0; i < n; i++){
			for (int j = 0; j< n; j++){ 
				this.grid_Map[i+1][j+1] = new Tower_Grid(xMax_val*(i+0.5)/n, yMax_val*(0.5 + j)/n, String.valueOf(i) + " x " + String.valueOf(j));
			}
		}
		initDirection();
	}
	public Grid closestGrid(double[] point){
		int x = (int) (point[0] * grid_Size / xMax_val); 
		int y = (int) (point[1] * grid_Size / yMax_val);
		return grid_Map[x][y]; 
	}
	public Grid closestGrid(double x_pos, double y_pos){
		int x = (int) (x_pos * grid_Size / xMax_val); 
		int y = (int) (y_pos * grid_Size / yMax_val);
		return grid_Map[x][y]; 		
	}
	public int[] closestGridCoordinate(double[] point){
		int[] coordinate = new int[2];
		coordinate[0] = (int) (point[0] * grid_Size / xMax_val); 
		coordinate[1] = (int) (point[1] * grid_Size / yMax_val);
		return coordinate;
	} 
	public void initDirection(){
		int[] prev = closestGridCoordinate(path[0]);
		int n = path.length;
		int[] next;
		for (int i = 1; i < path.length; i++){
			next = closestGridCoordinate(path[i]);
			if (next[0]>prev[0]){
				for (int k = prev[0]; k < next[0]; k++){
					grid_Map[k][prev[1]] = new Direction_Grid(grid_Map[k][prev[1]], grid_Map[k+1][prev[1]]);
				}
			}
			else{
				for (int k = prev[0]; k > next[0]; k--){
					grid_Map[k][prev[1]] = new Direction_Grid(grid_Map[k][prev[1]], grid_Map[k-1][prev[1]]);
				}
			}
			if (next[1]>prev[1]){
				for (int k = prev[1]; k < next[1]; k++){
					grid_Map[prev[0]][k] = new Direction_Grid(grid_Map[prev[0]][k], grid_Map[prev[0]][k+1]);
				}
			}
			else{
				for (int k = prev[1]; k > next[1]; k--){
					grid_Map[prev[0]][k] = new Direction_Grid(grid_Map[prev[0]][k], grid_Map[prev[0]][k-1]);
				}
			}
		}
		this.start = (Direction_Grid) closestGrid(path[0]);
		this.end = closestGrid(path[n-1]); // need to figure out how to handle end of path
		this.start.setStart();
		this.end.setEnd();
	}
	public void initUI(){

	}
	public Direction_Grid get_start(){
		return start;
	}
	public Grid[][] get_grid_map(){
		return grid_Map;
	}
	public void set_dGrid(){
		int i = 0;
		for (Grid[] garray: grid_Map){
			for (Grid g: garray){
				if(g.type() == "Direction"){
					dGrid[i] = (Direction_Grid) g;
					i++;
				}
			}
		}
	}
	public Direction_Grid[] get_dGrid(){
		return dGrid;
	}
}