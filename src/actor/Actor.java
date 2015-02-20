package src.actor;
import src.map.*;
import src.bank.*;
import src.shape.*;
public abstract class Actor{
	public String name;
	public double x_position;
	public double y_position;
	public Shape hit_box;
	public int cost;
	public int health;
	public Map map;
	public Bank bank;
	public Actor(String name, double x_position, double y_position, 
		Shape hit_box, int cost, int health, Map map){
		this.name = name;
		this.x_position = x_position;
		this.y_position = y_position;
		this.hit_box = hit_box;
		this.cost = cost;
		this.health = health;
		this.map = map;
	}
	public Actor(String name, Map map){
		this.name = name;
		this.map = map;
	}
	public abstract void action(double dt);
	public boolean buy(){
		return bank.withdraw(cost);
		// boolean can_buy = bank.withdraw(cost);
		// if (can_buy){
		// 	return "bought: " + name;
		// } 
		// else{
		// 	return "insufficient funds to buy: " + name;
		// }
	}
	public void draw(){
		hit_box.draw();
	}
	public void remove(){
		map.remove(this);
	}
	public void update_shape(){
		hit_box.set_X(this.x_position);
		hit_box.set_Y(this.y_position);
	}
}