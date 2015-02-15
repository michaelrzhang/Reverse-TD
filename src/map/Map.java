package src.map;
import src.grid.*;
import src.creature.*;
public class Map{
	Grid[][] grid_Map;
	int grid_Size;
	int xMax_val;
	int yMax_val;
	double[][] path;
	Direction_Grid start; // where creatures enter
	End_Grid end; // where creature leave the map
	Direction_Grid[] dGrid;
	Creature[] creatures = new Creature[100]; 
	int path_Width;

	public Map(double[][] p, int n, int xMax, int yMax, int pWidth){
		this.grid_Size = n;
		this.path = p;
		this.xMax_val = xMax;
		this.yMax_val = yMax;
		this.grid_Map = new Grid[this.grid_Size][this.grid_Size];
		this.path_Width = pWidth;
	}

	public void initialize(){
		for (int i = 0; i < grid_Size; i++){
			for (int j = 0; j< grid_Size; j++){ 
				this.grid_Map[i][j] = new Tower_Grid(xMax_val*(i+0.5)/grid_Size, yMax_val*(0.5 + j)/grid_Size, String.valueOf(i) + " x " + String.valueOf(j), this);
			}
		}
		dGrid = new Direction_Grid[grid_Size*grid_Size];
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
		int[] prev;
		int n = path.length;
		int[] next;
		for (int i = 0; i < path.length-1; i++){
			prev = closestGridCoordinate(path[i]);
			next = closestGridCoordinate(path[i+1]);
			if (next[0]>prev[0]){
				for (int k = prev[0]; k < next[0]; k++){
					grid_Map[k][prev[1]] = new Direction_Grid(grid_Map[k][prev[1]], grid_Map[k+1][prev[1]]);
					convertPath(k, prev[1], 0);
				}
			}
			else if(next[0] < prev[0]){
				for (int k = prev[0]; k > next[0]; k--){
					grid_Map[k][prev[1]] = new Direction_Grid(grid_Map[k][prev[1]], grid_Map[k-1][prev[1]]);
					convertPath(k, prev[1], 0);
				}
			}
			if (next[1]>prev[1]){
				for (int k = prev[1]; k < next[1]; k++){
					grid_Map[prev[0]][k] = new Direction_Grid(grid_Map[prev[0]][k], grid_Map[prev[0]][k+1]);
					convertPath(prev[0], k, 1);
				}
			}
			else if(next[1]<prev[1]){
				for (int k = prev[1]; k > next[1]; k--){
					grid_Map[prev[0]][k] = new Direction_Grid(grid_Map[prev[0]][k], grid_Map[prev[0]][k-1]);
					convertPath(prev[0], k, 1);
				}
			}
		}
		this.start = (Direction_Grid) closestGrid(path[0]);
		int[] ending = closestGridCoordinate(path[n-1]);
		grid_Map[ending[0]][ending[1]] =  new End_Grid(closestGrid(path[n-1]));
		this.end = (End_Grid) grid_Map[ending[0]][ending[1]];
		this.start.setStart();
		set_dGrid();
	}
	private void convertPath(int a, int b, int direction){ // direction = 1 is vertical direction = 0 is horizontal
		if (direction == 1){ // vertical
			for (int j = 1; j < path_Width+1; j++){
				if (a + j >= 0 && a + j < grid_Size){
					if (grid_Map[a+j][b].type() != "Direction"){
						grid_Map[a+j][b] = new Path_Grid(grid_Map[a+j][b]);
					}
				}
				if (a-j >= 0 && a-j < grid_Size){
					if (grid_Map[a-j][b].type() != "Direction"){
						grid_Map[a-j][b] = new Path_Grid(grid_Map[a-j][b]);
					}
				}
			}
		}
		else{ // horizontal
			for (int j = 1; j < path_Width+1; j++){
				if (b+j >= 0 && b+j < grid_Size){
					if (grid_Map[a][b+j].type() != "Direction"){
						grid_Map[a][b+j] = new Path_Grid(grid_Map[a][b+j]);
					}
				}
				if (b-j >= 0 && b-j < grid_Size){
					if (grid_Map[a][b-j].type() != "Direction"){
						grid_Map[a][b-j] = new Path_Grid(grid_Map[a][b-j]);
					}
				}
			}
		}
	}
	public Creature remove(Creature c){
		creatures[0] = null;
		return c;
	} // NEEDS TO BE WRITTEN
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
	public void addCreature(Creature c){
		creatures[0] = c;
	}
	public void action(double dt){
		for (Creature c : creatures){
			if(c != null){
				c.action(dt);
			}
		}
	}
	public void draw(){
		for (Creature c : creatures){
			if(c != null){
				c.draw();
			}
		}
	}
}