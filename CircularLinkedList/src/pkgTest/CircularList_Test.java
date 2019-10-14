package pkgTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pkgCore.Player;
import pkgGeneric.API;
import pkgGeneric.CircularLinkedList;

public class CircularList_Test {


	
	@Test
	public void CircularTest1()
	{
		Player p1 = new Player("Adam");
		Player p2 = new Player("Bob");
		Player p3 = new Player("Cal");
		Player p4 = new Player("Doug");
		
		Player pCurrent = null;
		
		API<Player> list = new CircularLinkedList<Player>();		
		assertEquals(0, list.getSize());
		
		list.add(p1);
		assertEquals(1, list.getSize());
		
		pCurrent = list.getCurrent();
		
		assertEquals(p1,pCurrent);
		
		list.add(p2);
		assertEquals(p1, list.getCurrent());
		
		list.setCurrent(p2);
		assertEquals(p2, list.getCurrent());
		
		list.clear();
		assertEquals(0,list.getSize());		
		assertNull(list.getCurrent());
		
		list.add(p1);
		list.add(p2);
		assertEquals(p1, list.getCurrent());
		
		list.advanceCurrent();
		assertEquals(p2, list.getCurrent());
		
		list.advanceCurrent();
		assertEquals(p1, list.getCurrent());
		
		
		
		list.clear();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		assertEquals(3, list.getSize());
		assertEquals(p1, list.getCurrent());		
		list.delete(p2);
		
		assertEquals(2,list.getSize());
		list.advanceCurrent();
		assertEquals(p3, list.getCurrent());
		list.advanceCurrent();
		assertEquals(p1, list.getCurrent());
		list.advanceCurrent();
		assertEquals(p3, list.getCurrent());
		
		list.clear();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.advanceCurrent();
		assertEquals(p2, list.getCurrent());
		list.setCurrent(p2);
		assertEquals(p2, list.getCurrent());
		
		list.delete(p2);
		assertEquals(2, list.getSize());
		
		assertEquals(p3, list.getCurrent());
	}
	
	@Test
	public void TestRound()
	{
		API<Player> list = new CircularLinkedList<Player>();	
		
		Player p1 = new Player("Adam");
		Player p2 = new Player("Bob");
		Player p3 = new Player("Cal");
		Player p4 = new Player("Doug");
		
		list.clear();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		assertEquals(1,list.getRounds());
		list.advanceCurrent();
		assertEquals(1,list.getRounds());		
		list.advanceCurrent();
		assertEquals(1,list.getRounds());
		list.advanceCurrent();
		assertEquals(2,list.getRounds());
	}

}
