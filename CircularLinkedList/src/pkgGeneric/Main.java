package pkgGeneric;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String [] args) {
    	
        API <Player> list = new CircularLinkedList<Player>();

        Player p1 = new Player("Adam");
        Player p2 = new Player("Bob");
        Player p3 = new Player("Carol");
        Player p4 = new Player("Duke");
        
        list.placeAtEnd(p1);
        list.placeAtEnd(p2);
        list.placeAtEnd(p3);
        list.placeAtEnd(p4);        
        list.print();
        
        list.newHead(p3);
        list.print();
        
        /*
        list.deleteFromBeginning();
        list.print();
        list.deleteFromEnd();
        list.print();
        */
        LinkedList<Player> playerOrder = list.getPlayersInOrder();
        System.out.println(playerOrder.size());
    }
}