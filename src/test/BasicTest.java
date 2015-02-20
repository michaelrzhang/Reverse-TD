package src.test;
import src.actor.creature.*;
import src.map.*;
import src.actor.projectile.*;
import src.actor.tower.*;
import lib.*;
import src.grid.*;
import java.util.ArrayList;
public class BasicTest{
	public static void main(String[] args){
		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,10);
		double[][] path = {{1,1} ,{1,8}, {8,8}, {8,1}, {2,1}};
		Map m = new Map(path, 10, 10, 10, 1);
		m.initialize();
		m.addActor(new BasicCreature("testcreature", m));
		m.addActor(new BasicProjectile("testprojectile", m));
		m.addActor(new BasicTower("testtower", m));
		ArrayList<DirectionGrid> dGrid = m.get_dGrid();
		while(true){
			StdDraw.picture(5.0, 5.0, "images/background.jpg");
			for (DirectionGrid g: dGrid){
				g.setCreaturesDirection();
			}
			m.action(0.001);
			m.draw();
			StdDraw.show(1);
		}
	}
}