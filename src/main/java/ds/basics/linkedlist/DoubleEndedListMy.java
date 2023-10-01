package ds.basics.linkedlist;

public class DoubleEndedListMy<T> extends MyLinkedList<T> {

	private Node<T> tail;
	
	public Node<T> getTail() {
		return this.tail;
	}
	
	public void addAtEnd(T data) {
		Node<T> newNode = new Node<T>(data);
		this.tail.setNextNode(newNode);
		this.tail = newNode;
	}
		
}
