package src.test;
import src.creature.*;
import src.map.*;
import src.projectile.*;
import lib.*;
import src.grid.*;
public class BasicTest{
	public static void main(String[] args){
		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,10);
		double[][] path = {{1,1} ,{1,8}, {8,8}, {8,1}, {2,1}};
		Map m = new Map(path, 10, 10, 10, 1);
		m.initialize();
		m.addCreature(new Basic_Creature(m,"1Basic"));
		m.addProjectile(new BasicProjectile("testprojectile", m));
		while(true){
			StdDraw.picture(5.0, 5.0, "images/background.jpg");
			for (DirectionGrid g: m.get_dGrid()){
				if (g != null){
					g.setCreaturesDirection();
				}
			}
			m.action(0.001);
			m.draw();
			StdDraw.show(1);
		}
	}
}