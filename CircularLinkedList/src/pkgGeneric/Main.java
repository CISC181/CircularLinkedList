package pkgGeneric;

import java.util.LinkedList;

import pkgCore.Player;

public class Main {
	public static void main(String[] args) {

		API<Player> list = new CircularLinkedList<Player>();

		Player p1 = new Player("Adam");
		Player p2 = new Player("Bob");
		Player p3 = new Player("Carol");
		Player p4 = new Player("Duke");

		list.placeAtEnd(p1);
		list.placeAtEnd(p2);
		list.placeAtEnd(p3);
		list.placeAtEnd(p4);

		// list.print();
		list.setCurrent(p3);

		Player p = (Player) list.getCurrent();
		System.out.println(p.getPlayerName());

		list.setCurrent(p2);
		p = (Player) list.getCurrent();
		System.out.println(p.getPlayerName());

		list.setCurrent(p4);
		p = (Player) list.getCurrent();
		System.out.println(p.getPlayerName());

		p = (Player) list.advanceCurrent();
		System.out.println(p.getPlayerName());

		for (int i = 0; i < 100; i++) {
			p = (Player) list.advanceCurrent();
			System.out.println(p.getPlayerName());
		}

		LinkedList<Player> players = (LinkedList<Player>) list.getItemsInOrder();
		for (Player ps : players) {
			System.out.println(ps.getPlayerID() + " " + ps.getPlayerName());
		}

		list.newHead(p4);

		players = (LinkedList<Player>) list.getItemsInOrder();
		for (Player ps : players) {
			System.out.println(ps.getPlayerID() + " " + ps.getPlayerName());
		}
	}
}