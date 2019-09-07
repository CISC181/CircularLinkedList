package pkgGeneric;

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
		

		list.delete(p2);
		list.delete(p3);
		
		System.out.println(list.getCurrent().getPlayerName());
		
		list.advanceCurrent();
		System.out.println(list.getCurrent().getPlayerName());
		
		list.delete(p4);
		System.out.println(list.getCurrent().getPlayerName());
		
		
	}
}