package src.bank;
import src.player.*;
public class Bank{ // not really sure what to call it 
	public double cash;
	public Player player; // should always be 1==towers or 2==creatures
	public Bank(){
		// this.player = p;
		this.cash = 0;
	}
	public Bank(double cash){
		// this.player = p;
		this.cash = cash;
	}
	public void deposit(double c){
		cash += c;
	}
	public boolean withdraw(double c){
		if (c > cash){
			return false;
		}
		else{
			cash -= c;
			return true;
		}
	}
	public double getCash(){
		return cash;
	}
	// public int getPlayer(){
	// 	return player;
	// }
}