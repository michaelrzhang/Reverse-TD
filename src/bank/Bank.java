package src.bank;
public class Bank{ // not really sure what to call it 
	public double cash;
	public int player; // should always be 1==towers or 2==creatures
	public Bank(int p){
		this.player = p;
		this.cash = 0;
	}
	public Bank(int p, double cash){
		this.player = p;
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
	public int getPlayer(){
		return player;
	}
}