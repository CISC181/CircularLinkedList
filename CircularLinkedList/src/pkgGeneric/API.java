package pkgGeneric;

import java.util.ArrayList;
import java.util.LinkedList;

public interface API <E> {
    public void placeAtBeginning(E element);
    public void placeAtEnd(E element);
    public void deleteFromBeginning();
    public void deleteFromEnd();
    public void print();
    public void newHead(E element);
    public LinkedList<E> getPlayersInOrder();
}