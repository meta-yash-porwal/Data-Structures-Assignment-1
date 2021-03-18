import java.util.List;
import java.util.ArrayList;




public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");

		LinkedList head = new LinkedList();
		Node completeNode; 


		head.insert(1);
		head.insert(2);
		head.insert(3);
		head.insert(4);
		head.insert(5);
		head.insert(6);
		head.insert(7);
		head.insert(8);
		head.printList();
		
		completeNode = head.completeList(3, 2, 6);
		System.out.print("Rotated Linked List:-  ");
		while(completeNode != null) {
			System.out.print(completeNode.data + " ");
			completeNode = completeNode.next;
		}
		
		System.out.println("\n" + head.detectLoop());
		
		// Polynomial Class object 
		Polynomial multivariatePoly = new Polynomial();
		int[] e1 = {2,4};
		multivariatePoly.addElement(e1,3);
		int[] e2 = {2};
		multivariatePoly.addElement(e2,1);

		System.out.println("Degree :- "+ multivariatePoly.getDegree());
		
	}
}
