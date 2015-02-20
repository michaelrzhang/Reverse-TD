package src.player;
import src.map.*;
import src.actor.*;
import src.bank.*;
public class Player{
	public Map map;
	public int player;
	public Bank bank;
	public Player(int player, Map map, Bank bank){
		this.player = player;
		this.map = map;
		this.bank = bank;
	}

	public void buyActor(Actor a){
		if (bank.withdraw(a.cost)){
			map.addActor(a);
		}
	}

}