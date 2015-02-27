package src.map;
import java.util.*;
import src.grid.*;
import src.actor.*;
import src.actor.creature.*;
import src.actor.projectile.*;
import src.actor.tower.*;
import src.UI.*;
import src.player.*;
import src.bank.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.event.MouseInputAdapter;
public class Map extends JFrame{
	public int seconds;
	Grid[][] grid_Map;
	// int grid_Size;
	int xMax_val;
	int yMax_val;
	int[][] path;
	DirectionGrid start; // where creatures enter
	EndGrid end; // where creature leave the map
	ArrayList<DirectionGrid> dGrid = new ArrayList<DirectionGrid>();
	ArrayList<Actor> actors = new ArrayList<Actor>(); // active actors
	ArrayList<Actor> queue = new ArrayList<Actor>(); // actors to be added next dt
	ArrayList<Creature> creatures = new ArrayList<Creature>(); // active creatures
	ArrayList<Creature> creatures_queue = new ArrayList<Creature>(); // active creatures
	ArrayList<Actor> remove_queue = new ArrayList<Actor>();
	int path_Width;
	Graphics2D g2d;
	private static BitSet keyBits = new BitSet(256);
	public ArrayList<UI> ui = new ArrayList<UI>();
	BufferedImage background;
	int mouseX;
	int mouseY;
	boolean mouseActive = false;
	Player player1 = new Player(1, this, new Bank(100));
	Player player2 = new Player(2, this, new Bank(100));
	public Map(int[][] p, int xMax, int yMax, int pWidth, String b){
		this.path = p;
		this.xMax_val = xMax;
		this.yMax_val = yMax;
		this.grid_Map = new Grid[xMax_val][yMax_val];
		this.path_Width = pWidth;
		this.ui = ui;
		setTitle("WASSUP MICHAEL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(xMax_val, yMax_val));
		addKeyBoard();
		addMouse();
		background(b);
		setUndecorated(true);
		setVisible(true);
		this.g2d = (Graphics2D) this.getGraphics();
		initialize();
		setResizable(false);
	}

	public void initialize(){
		for (int i = 0; i < xMax_val; i++){
			for (int j = 0; j< yMax_val; j++){ 
				this.grid_Map[i][j] = new TowerGrid(i, j, String.valueOf(i) + " x " + String.valueOf(j), this);
			}
		}
		initDirection();
		addUI();
		initUI();
	}

	public Grid closestGrid(int[] point){
		int x = point[0];
		int y = point[1];
		return grid_Map[x][y]; 
	}

	public Grid closestGrid(int x_pos, int y_pos){
		return grid_Map[x_pos][y_pos]; 		
	}

	public int[] closestGridCoordinate(int[] point){
		return point;
	}
	public int[] closestGridCoordinate(int x, int y){
		return new int[] {x, y};
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
				if (a + j >= 0 && a + j < xMax_val){
					if (grid_Map[a+j][b].type() != "Direction"){
						grid_Map[a+j][b] = new PathGrid(grid_Map[a+j][b]);
					}
				}
				if (a-j >= 0 && a-j < xMax_val){
					if (grid_Map[a-j][b].type() != "Direction"){
						grid_Map[a-j][b] = new PathGrid(grid_Map[a-j][b]);
					}
				}
			}
		}
		else{ // horizontal
			for (int j = 1; j < path_Width+1; j++){
				if (b+j >= 0 && b+j < yMax_val){
					if (grid_Map[a][b+j].type() != "Direction"){
						grid_Map[a][b+j] = new PathGrid(grid_Map[a][b+j]);
					}
				}
				if (b-j >= 0 && b-j < yMax_val){
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
	public void addUI(){
		ui.add(new CreatureUI(700, 700, 100, 100));
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
	public void setDirection(){
		for (DirectionGrid g : dGrid){
			g.setCreaturesDirection();
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
				creatures.remove((Creature) a);
			}
		}

		creatures_queue = new ArrayList<Creature>();
		queue = new ArrayList<Actor>();
		remove_queue = new ArrayList<Actor>();
	}

	public Actor remove(Actor a){
		remove_queue.add(a);
		return a;
	}

	public void action(double dt){
		unQueue(); // avoids concurent modification 
		setDirection();
		for (Actor a : actors){
			a.action(dt);
		}
		draw();
	}

	public void convertUIGrid(UI u){
		int[] bottomleft = closestGridCoordinate(u.get_x_position(),u.get_y_position());
		int a = bottomleft[0];
		int b = bottomleft[1];
		int width = u.get_xlength();
		int height = u.get_ylength();
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
		if (x>=xMax_val || x < 0 || y >=yMax_val || y<0){
			return false;
		}
		return true;
	}

	public ArrayList<Creature> getCreatures(){
		return creatures;
	}

	public void background(String b){
		try{
			background =  ImageIO.read(new File(b));
		}
		catch (Exception e){
		}
	}
	public void draw(){
		g2d.drawImage(background, 0,0,xMax_val, yMax_val, null);
		for (Actor a: actors){
			a.draw(g2d);
		}
		for (UI u: ui){
			u.draw(g2d);
		}
	}
	public void addKeyBoard(){
		this.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				int keyCode = e.getKeyCode();
				keyBits.set(keyCode);
			}
			public void keyReleased(KeyEvent e){
				int keyCode = e.getKeyCode();
				right();
				left();
				space();
				keyBits.clear(keyCode);
			}
			public void keyTyped(KeyEvent e){
			}
		});
	}
	public void addMouse(){
		MouseInputAdapter ml = new MouseInputAdapter(){
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){
				mouseX = e.getXOnScreen();
				mouseY = e.getYOnScreen();
				mouseActive = true;
			}
			public void mouseMoved(MouseEvent e){}
			public void mouseDragged(MouseEvent e){}
		};
		addMouseListener(ml);
		addMouseMotionListener(ml);
	}
	public void mouseClick(){
		if (mouseActive){
			player2.buyActor(new HoningTower("testtower", this, mouseX, mouseY));
			// System.out.println(mouseX);
			// System.out.println(mouseY);
		}
		mouseActive = false;
	}
	public boolean isKeyPressed(int keyCode){
		return keyBits.get(keyCode);
	}
	public void right(){
		if (isKeyPressed(39)){
			((CreatureUI) ui.get(0)).change(1);
			keyBits.clear(39);
		}
	}	
	public void left(){
		if (isKeyPressed(37)){
			((CreatureUI) ui.get(0)).change(-1);
			keyBits.clear(37);
		}
	}
	public void space(){
		if (isKeyPressed(32)){
			((CreatureUI) ui.get(0)).get_Creature().copy(player1);
			keyBits.clear(32);
		}
	}		

}