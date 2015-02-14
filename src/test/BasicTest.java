package src.test;
import src.creature.*;
import src.map.*;
import lib.*;
import src.grid.*;
public class BasicTest{
	public static void main(String[] args){
		StdDraw.setXscale(0,10);
		StdDraw.setYscale(0,10);
		double[][] path = {{4,1} ,{4,9}};
		Map m = new Map(path, 10, 10, 10);
		Basic_Creature c = new Basic_Creature(m,"1Basic");
		while(true){
			for (Direction_Grid g: m.get_dGrid()){
				g.setCreaturesDirection();
			}
			c.action(0.01);
			StdDraw.show(10);
		}
	}
}