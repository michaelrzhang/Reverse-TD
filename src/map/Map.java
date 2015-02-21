package src.map;
import java.util.ArrayList;
import src.grid.*;
import src.actor.*;
import src.actor.creature.*;
import src.actor.projectile.*;
import src.actor.tower.*;
import src.UI.*;
public class Map{
	Grid[][] grid_Map;
	int grid_Size;
	int xMax_val;
	int yMax_val;
	double xScale;
	double yScale;
	double[][] path;
	DirectionGrid start; // where creatures enter
	EndGrid end; // where creature leave the map
	ArrayList<DirectionGrid> dGrid = new ArrayList<DirectionGrid>();
	ArrayList<Actor> actors = new ArrayList<Actor>(); // active actors
	ArrayList<Actor> queue = new ArrayList<Actor>(); // actors to be added next dt
	ArrayList<Creature> creatures = new ArrayList<Creature>(); // active creatures
	ArrayList<Creature> creatures_queue = new ArrayList<Creature>(); // active creatures
	ArrayList<Actor> remove_queue = new ArrayList<Actor>();
	int path_Width;
	public ArrayList<UI> ui = new ArrayList<UI>();

	public Map(double[][] p, int n, int xMax, int yMax, int pWidth, ArrayList<UI> ui){
		this.grid_Size = n;
		this.path = p;
		this.xMax_val = xMax;
		this.yMax_val = yMax;
		this.xScale = (0.0 + xMax_val)/grid_Size;
		this.yScale = (0.0 + yMax_val)/grid_Size;
		this.grid_Map = new Grid[this.grid_Size][this.grid_Size];
		this.path_Width = pWidth;
		this.ui = ui;
	}

	public void initialize(){
		for (int i = 0; i < grid_Size; i++){
			for (int j = 0; j< grid_Size; j++){ 
				this.grid_Map[i][j] = new TowerGrid(xMax_val*(i+0.5)/grid_Size, yMax_val*(0.5 + j)/grid_Size, String.valueOf(i) + " x " + String.valueOf(j), this);
			}
		}
		initDirection();
		initUI();
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
	public int[] closestGridCoordinate(double x, double y){
		int[] coordinate = new int[2];
		coordinate[0] = (int) (x * grid_Size / xMax_val); 
		coordinate[1] = (int) (y * grid_Size / yMax_val);
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
					grid_Map[k][prev[1]] = new DirectionGrid(grid_Map[k][prev[1]], grid_Map[k+1][prev[1]]);
					dGrid.add((DirectionGrid) grid_Map[k][prev[1]]);
					convertPath(k, prev[1], 0);
				}
			}
			else if(next[0] < prev[0]){
				for (int k = prev[0]; k > next[0]; k--){
					grid_Map[k][prev[1]] = new DirectionGrid(grid_Map[k][prev[1]], grid_Map[k-1][prev[1]]);
					dGrid.add((DirectionGrid) grid_Map[k][prev[1]]);					
					convertPath(k, prev[1], 0);
				}
			}
			if (next[1]>prev[1]){
				for (int k = prev[1]; k < next[1]; k++){
					grid_Map[prev[0]][k] = new DirectionGrid(grid_Map[prev[0]][k], grid_Map[prev[0]][k+1]);
					dGrid.add((DirectionGrid) grid_Map[prev[0]][k]);					
					convertPath(prev[0], k, 1);
				}
			}
			else if(next[1]<prev[1]){
				for (int k = prev[1]; k > next[1]; k--){
					grid_Map[prev[0]][k] = new DirectionGrid(grid_Map[prev[0]][k], grid_Map[prev[0]][k-1]);
					dGrid.add((DirectionGrid) grid_Map[prev[0]][k]);
					convertPath(prev[0], k, 1);
				}
			}
		}
		this.start = (DirectionGrid) closestGrid(path[0]);
		int[] ending = closestGridCoordinate(path[n-1]);
		grid_Map[ending[0]][ending[1]] =  
		end = new EndGrid(closestGrid(path[n-1]));
		grid_Map[ending[0]][ending[1]] = end;
		dGrid.add(end);
		this.start.setStart();
	}
	private void convertPath(int a, int b, int direction){ // direction = 1 is vertical direction = 0 is horizontal
		if (direction == 1){ // vertical
			for (int j = 1; j < path_Width+1; j++){
				if (a + j >= 0 && a + j < grid_Size){
					if (grid_Map[a+j][b].type() != "Direction"){
						grid_Map[a+j][b] = new PathGrid(grid_Map[a+j][b]);
					}
				}
				if (a-j >= 0 && a-j < grid_Size){
					if (grid_Map[a-j][b].type() != "Direction"){
						grid_Map[a-j][b] = new PathGrid(grid_Map[a-j][b]);
					}
				}
			}
		}
		else{ // horizontal
			for (int j = 1; j < path_Width+1; j++){
				if (b+j >= 0 && b+j < grid_Size){
					if (grid_Map[a][b+j].type() != "Direction"){
						grid_Map[a][b+j] = new PathGrid(grid_Map[a][b+j]);
					}
				}
				if (b-j >= 0 && b-j < grid_Size){
					if (grid_Map[a][b-j].type() != "Direction"){
						grid_Map[a][b-j] = new PathGrid(grid_Map[a][b-j]);
					}
				}
			}
		}
	}

	public void initUI(){
		for (UI u : ui){
			convertUIGrid(u);
		}
	}
	public DirectionGrid get_start(){
		return start;
	}
	public Grid[][] get_Grid_map(){
		return grid_Map;
	}
	public void set_dGrid(){
		int i = 0;
		for (Grid[] garray: grid_Map){
			for (Grid g: garray){
				if(g.type() == "Direction"){
					dGrid.add((DirectionGrid) g);
					i++;
				}
			}
		}
	}
	public ArrayList<DirectionGrid> get_dGrid(){
		return dGrid;
	}

	public void addActor(Actor a){
		queue.add(a); // cant be immediately added because then it causes problems when looping through the actors
		if (a instanceof Creature){
			creatures_queue.add((Creature) a);
		}
	}

	public void addTower(Tower t){
		queue.add(t);
	}

	public void unQueue(){
		for (Actor a : queue){
			actors.add(a);
		}
		for (Creature c : creatures_queue){
			creatures.add(c);
		}
		for (Actor a : remove_queue){
			actors.remove(a);
			if (a instanceof Creature){
				creatures_queue.remove((Creature) a);
			}
		}

		creatures_queue = new ArrayList<Creature>();
		queue = new ArrayList<Actor>();
	}

	public Actor remove(Actor a){
		remove_queue.add(a);
		return a;
	}

	public void action(double dt){
		unQueue(); // avoids concurent modification 
		for (Actor a : actors){
			a.action(dt);
		}

	}

	public void convertUIGrid(UI u){
		int[] bottomleft = closestGridCoordinate(u.get_x_position(),u.get_y_position());
		int a = bottomleft[0];
		int b = bottomleft[1];
		int width = (int) (u.get_xlength()/xScale);
		int height = (int) (u.get_ylength()/yScale);
		UIGrid[][] uigrid = new UIGrid[width+1][height+1];
		for (int i = 0; i <= width; i++){
			for(int j = 0; j <= height; j++){
				if (checkCoordinate(a+i,b+j)){
					grid_Map[a+i][b+j] = new UIGrid(grid_Map[a+i][b+j], u);
					uigrid[i][j] = (UIGrid) grid_Map[a+i][b+j];
				}
			}
		}
		u.set_uigrid(uigrid);
	}
	public boolean checkCoordinate(int x, int y){
		if (x>=grid_Size || x < 0 || y >=grid_Size || y<0){
			return false;
		}
		return true;
	}

	public void draw(){
		for (Actor a: actors){
			a.draw();
		}
		for (UI u: ui){
			u.draw();
		}
	}
}