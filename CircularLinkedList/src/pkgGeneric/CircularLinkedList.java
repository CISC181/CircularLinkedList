package pkgGeneric;

import java.util.ArrayList;
import java.util.LinkedList;

public class CircularLinkedList<E> implements API<E> {
	private Node<E> head;
	private int size = 0;

	/*
	 * public void placeAtBeginning(E element) { Node<E> newNode = new
	 * Node<E>(element); if (head == null) { head = newNode; head.setNext(head); }
	 * else { Node<E> temp = head; head = newNode; newNode.setNext(temp); } size++;
	 * }
	 */
	public void placeAtBeginning(E element) {
		Node<E> newNode = new Node<E>(element);
		if (head == null) {
			head = newNode;
			head.setNext(head);
		} else {
			Node<E> last = head;
			while (last.getNext() != head)
				last = last.getNext();
			newNode.setNext(head);
			head = newNode;
			last.setNext(head);
		}
		size++;
	}

	public void placeAtEnd(E element) {
		Node<E> newNode = new Node<E>(element);
		if (head == null) {
			head = newNode;
		} else {
			Node<E> temp = head;
			while (temp.getNext() != head) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}

		newNode.setNext(head);
		size++;
	}

	public void deleteFromBeginning() {
		Node<E> temp = head;
		while (temp.getNext() != head) {
			temp = temp.getNext();
		}
		temp.setNext(head.getNext());
		head = head.getNext();
		size--;
	}

	public void deleteFromEnd() {
		Node<E> temp = head;
		while (temp.getNext().getNext() != head) {
			temp = temp.getNext();
		}
		temp.setNext(head);
		size--;
	}

	public LinkedList<E> getPlayersInOrder()
	{
		LinkedList<E> players = new LinkedList<E>();
		
		Node<E> temp = head;
		while (temp.getNext() != head) {
			Player p = (Player) temp.getValue();
			players.add((E) p);			
			temp = temp.getNext();
		}
		Player p = (Player) temp.getValue();
		players.add((E) p);
		return players;
	}
	public void print() {
		Node<E> temp = head;
		while (temp.getNext() != head) {
			Player p = (Player) temp.getValue();
			System.out.print(p.getPlayerName() + ", ");
			temp = temp.getNext();
		}
		Player p = (Player) temp.getValue();
		System.out.println(p.getPlayerName());
	}

	@Override
	public void newHead(E element) {

		Player p1 = (Player)element;
		
		Node<E> temp = head;
		while (temp.getNext() != head) {
			Player p = (Player) temp.getValue();
			if (p1.getPlayerID() == p.getPlayerID())
			{
				head = temp;
				break;
			}
			temp = temp.getNext();
		}		
	}
}