package pkgGeneric;

import java.util.LinkedList;
import java.util.List;

import pkgCore.Player;

public class CircularLinkedList<E> implements API<E> {
	private Node<E> head;
	private Node<E> current;
	private int size = 0;

	public CircularLinkedList() {
		super();
		head = null;
		current = null;
	}

	public CircularLinkedList(List<E> arrayList) {
		super();
		for (E e : arrayList) {
			placeAtEnd(e);
		}
	}

	public void addAll(List<E> arrayList) {
		head = null;
		for (E e : arrayList) {
			placeAtEnd(e);
		}
	}

	public E advanceCurrent() {
		setCurrent(this.current.getNext().getValue());

		return getCurrent();
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

	public void delete(E element) {
		
		Node<E> temp = head;
		Node<E> prev = null;
		if ((size == 1) && (head.getValue() == element)) {
			this.clear();
			return;
		}
		
		Player p = (Player)element;
		Player pNext = (Player)temp.getNext().getValue();
		Player pNextNext = (Player)temp.getNext().getNext().getValue();		
		System.out.println(pNext.getPlayerName());
		System.out.println(pNextNext.getPlayerName());
		
		System.out.print(p.getPlayerName());
		
		/*
		while (temp.getNext() != head) {
			
			
			temp = temp.getNext();
		}
		
		while (true)
		{
			Player pNext = (Player)temp.getNext().getValue();
			Player pNextNext = (Player)temp.getNext().getNext().getValue();
			
			System.out.println(pNext.getPlayerName());
			System.out.println(pNextNext.getPlayerName());
			if (temp.getNext().getNext().getValue() == element)
				break;
			temp = temp.getNext();
		}
		
		temp.getNext().setNext(temp.getNext().getNext());		
		current = temp.getNext();
		*/
	}

	public void clear() {
		head = null;
		current = null;
		size = 0;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public E getCurrent() {
		if (size > 0)
			return (E) this.current.getValue();
		return null;
	}

	public List<E> getItemsInOrder() {
		List<E> list = new LinkedList<E>();
		Node<E> temp = head;
		while (temp.getNext() != head) {
			list.add((E) temp.getValue());
			temp = temp.getNext();
		}
		list.add((E) temp.getValue());
		return list;
	}

	@Override
	public void newHead(E element) {
		Node<E> temp = head;
		while (temp.getNext() != head) {
			if (temp.getNext() == element)
				break;
			temp = temp.getNext();
		}
		head = temp;
	}

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
			current = newNode;
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

	@Override
	public void setCurrent(E element) {
		Node<E> newNode = new Node<E>(element);
		Node<E> temp = null;
		if (head == null) {
			head = newNode;
		} else {
			temp = head;
			while (temp.getNext().getValue() != newNode.getValue()) {
				temp = temp.getNext();
			}
		}
		newNode.setNext(temp.getNext().getNext());
		this.current = newNode;
	}

}