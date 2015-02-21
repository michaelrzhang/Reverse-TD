package src.test;
import src.actor.creature.*;
import src.map.*;
import src.actor.projectile.*;
import src.actor.tower.*;
import lib.*;
import src.grid.*;
import src.player.*;
import src.bank.*;
import src.UI.*;
import java.util.ArrayList;
public class BasicTest{
	boolean space = false;
	public static void main(String[] args){
		boolean[] key = {false, false};
		StdDraw.setXscale(0,50);
		StdDraw.setYscale(0,50);
		double[][] path = {{1,0} ,{1,49}};
		ArrayList<UI> ui = new ArrayList<UI>();
		ui.add(new CreatureUI(25.0, 0.0, 10.0,10.0));
		Map m = new Map(path, 50, 50, 50, 3, ui);
		m.initialize();
		m.addActor(new BasicCreature("testcreature", m));
		m.addActor(new BasicTower("testtower", m));
		ArrayList<DirectionGrid> dGrid = m.get_dGrid();
		Player player1 = new Player(1, m, new Bank(100));
		Player player2 = new Player(2, m, new Bank(100));
		while(true){
			StdDraw.picture(25.0, 25.0, "images/background.jpg");
			for (DirectionGrid g: dGrid){
				g.setCreaturesDirection();
			}
			isSpace(key, player1);
			mouse(key, player2);
			m.action(0.01);
			m.draw();
			StdDraw.show(1);
		}
	}

	public static void isSpace(boolean[] key, Player p){
		if (StdDraw.isKeyPressed(32)){
			if (!key[0]){
				p.buyActor(new BasicCreature("testcreature", p.map));
			}
			key[0] = true;
		}
		else{
			key[0] = false;
		}
	}

	public static void mouse(boolean[] key, Player p){
		if (StdDraw.mousePressed()){
			double x = StdDraw.mouseX();
			double y = StdDraw.mouseY();
			Grid g = p.map.closestGrid(x,y);
			System.out.println(g.type());
			if (!key[1] && g.can_place()){
				p.buyActor(new BasicTower("testtower", p.map, x, y));
			}
			key[1] = true;
		}
		else{
			key[1] = false;
		}
	}
}