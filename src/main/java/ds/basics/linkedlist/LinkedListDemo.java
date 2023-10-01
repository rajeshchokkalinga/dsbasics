package ds.basics.linkedlist;

public class LinkedListDemo {

	public static void main(String[] args) {
		MyLinkedList<Integer> integers = new MyLinkedList<Integer>();

		integers.addAtStart(5);
		integers.addAtStart(10);
		integers.addAtStart(2);
		integers.addAtStart(12);
		integers.addAtStart(19);
		integers.addAtStart(20);
		integers.addAtStart(24);
		System.out.println(integers.length());
		System.out.println(integers.find(120));

		//Append lasts 3 nodes to initial position
		System.out.println("Integers: " +integers.toString());
		integers.appendLastNAtHead(integers, 3);
		System.out.println("Integers after append last 3 : " +integers.toString());

		integers.reverse(integers);
		System.out.println("Integers after reverse : " +integers.toString());
		integers.addAtStart(12);
		System.out.println("Integers with duplicates : " +integers.toString());
		integers.deleteDuplicates(integers);
		System.out.println("Integers -duplicates removed : " +integers.toString());
		System.out.println("Is Cyclic : " +integers.isCyclic(integers));

	}
	
}
