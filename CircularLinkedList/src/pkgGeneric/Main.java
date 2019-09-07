package pkgGeneric;

import java.util.List;

import pkgCore.Player;

public class Main {
	public static void main(String[] args) {

		API<Player> list = new CircularLinkedList<Player>();

		Player p1 = new Player("Adam");
		Player p2 = new Player("Bob");
		Player p3 = new Player("Carol");
		Player p4 = new Player("Duke");

		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
		
		List<Player> players = list.getItemsInOrder();
		System.out.println(players.size());
		
		for (Player p: players)
		{
			System.out.println(p.getPlayerName());
		}
		
		list.setCurrent(p3);
		System.out.println("**** After current set ****");
		for (Player p: players)
		{
			System.out.println(p.getPlayerName());
		}
	}
}