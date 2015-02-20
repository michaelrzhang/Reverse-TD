package src.test;
import src.actor.creature.*;
import src.map.*;
import src.actor.projectile.*;
import src.actor.tower.*;
import lib.*;
import src.grid.*;
import src.player.*;
import src.bank.*;
import java.util.ArrayList;
public class BasicTest{
	boolean space = false;
	public static void main(String[] args){
		boolean[] key = {false};
		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,10);
		double[][] path = {{1,0} ,{1,8}, {8,8}, {8,0}};
		Map m = new Map(path, 10, 10, 10, 1);
		m.initialize();
		m.addActor(new BasicCreature("testcreature", m));
		m.addActor(new BasicTower("testtower", m));
		ArrayList<DirectionGrid> dGrid = m.get_dGrid();
		Player player1 = new Player(1, m, new Bank(100));
		while(true){
			StdDraw.picture(5.0, 5.0, "images/background.jpg");
			for (DirectionGrid g: dGrid){
				g.setCreaturesDirection();
			}
			isSpace(key, player1);
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
}