
/**
 * this is a node class 
 * @author yash.porwal_metacube
 *
 */
public class Node {
	int data;
	Node next;
		
	/**
	 * constructor which is used to insert data in the Node
	 * @param d is the data which which inserted in the Node
	 */
	Node(int d) {
		data = d;
		next = null;
		}
	
	/**
	 * empty constructor
	 */
	public Node() {}

}