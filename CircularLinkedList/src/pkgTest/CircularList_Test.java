package pkgTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pkgCore.Player;
import pkgGeneric.API;
import pkgGeneric.CircularLinkedList;

public class CircularList_Test {

	@Test
	public void CircularList_Test1() {

		//	Test the following:
		//	Add
		//	Size after add
		//	Current on first addition
		//	Current after second addition
		//	clear
		//	size after clear
		//	Current after clear (should be null)
		API<Player> list = new CircularLinkedList<Player>();
		assertEquals(0, list.getSize());

		// Create a Player, add them to the list, check the size, check current
		Player p1 = new Player("Adam");
		list.placeAtEnd(p1);
		assertEquals(1, list.getSize());
		assertEquals(p1, list.getCurrent());

		// Create another Player, add them to the list
		// size should be 2
		// current still should be p1

		Player p2 = new Player("Beth");
		list.placeAtEnd(p2);
		assertEquals(2, list.getSize());
		assertEquals(p1, list.getCurrent());

		// Change the current from p1 to p2
		list.setCurrent(p2);
		assertEquals(2, list.getSize());
		assertEquals(p2, list.getCurrent());

		// Clear the list, count should be zero
		list.clear();
		assertEquals(0, list.getSize());
		assertNull(list.getCurrent());
	}
	
	@Test
	public void CircularList_Test2() {

		//	Test the following:
		//	Add
		//	Size after add
		//	Current on first addition
		//	Delete
		//	Size after deleting when there's one item
		Player p1 = new Player("Adam");
		Player p2 = new Player("Bob");
		Player p3 = new Player("Cal");
		
		API<Player> list = new CircularLinkedList<Player>();
		assertEquals(0, list.getSize());

		// Create a Player, add them to the list, check the size, check current
		
		list.placeAtEnd(p1);
		assertEquals(1, list.getSize());
		assertEquals(p1, list.getCurrent());
		
		//	Delete item
		list.delete(p1);
		assertEquals(0,list.getSize());
		assertNull(list.getCurrent());
		
		//	Add p1, check size/current
		list.placeAtEnd(p1);
		assertEquals(1, list.getSize());
		assertEquals(p1, list.getCurrent());
		
		
		list.placeAtEnd(p2);
		assertEquals(2, list.getSize());
		assertEquals(p1, list.getCurrent());	

		list.delete(p1);
		assertEquals(p2, list.getCurrent());
		
		//	Clear the list, add three players
		list.clear();
		list.placeAtEnd(p1);
		list.placeAtEnd(p2);
		list.placeAtEnd(p3);
		assertEquals(3, list.getSize());
		assertEquals(p1, list.getCurrent());
		
		//	Remove p2
		list.delete(p2);
		
		
	}

}