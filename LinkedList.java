

/**
 * a java program to implement a singly Liked List
 * Without using collection
 * @author yash.porwal_metacube
 *
 */
public class LinkedList {

	Node head;             //head of List

	/**
	 * Method to insert a new node at last in LinkedList
	 * @param data which takes the integer value and put it in node's data
	 */
	public void insert(int data) {
		
		Node newNode = new Node(data);		//Create a new node with data
		newNode.next = null;
		
		/*
		 * If the LinkedList is empty
		 * then make a new node as head
		 */
		if(head == null) {
			head = newNode;
		}
		else {
			/*
			 * Else traverse till the last date
			 * and insert the newNode at last
			 */
			Node last = head;
			while(last.next != null) {
				last = last.next;
			}
			
			
			last.next = newNode;		//Insert the newNode
		}
	}
	
	/**
	 * Method to print the Linked List
	 */
	public void printList(){
		
		Node currNode = head;
		System.out.print("Linked List:-  ");
		
		/*
		 * Traverse through the Linked List
		 */
		while(currNode != null) {
			
			
			System.out.print(currNode.data + " ");//Print the date in the node
			
			currNode = currNode.next;//then we go to next node
		}
		System.out.println("\n");
	}
	
	/*
	 * Method to find the length of Linked List
	 */
	public int getLength() {
		Node currNode = head ;
		int length = 0;
		while(currNode != null ) {
		length++;
		currNode = currNode.next;
		}
	return length;
	}
	
	
	/**
	 * 
	 * it divides the Linked List from l to r
	 * then rotate the SubLinked List to number of rotation
	 * and then after rotation, joins the remaining Linked List 
	 * and return it.
	 * @param l is the left side from where linked list starts divide and rotate
	 * @param r is the right side from where linked list ends divide and rotate
	 * @param noOfRotation 
	 * @return it return node of complete Linked List after rotation 
	 * and join with remaining node.
	 */
	public Node completeList(int noOfRotation, int l, int r) {
		Node currNode = head;     //current Node
		Node subNode = null;
		
		/*
		 * Node to handle elements right side of the main linked list 
		 */
		Node rightSide;
		
		/*
		 * variable to find the sublist from l(staring point of sublist)
		 * to r(ending point)
		 */
		int divideFromLast=l;
		
		/*
		 * it used to calculate the length of a Node(Linked List)
		 */
		int length = 0; 
		while(currNode != null) {
			length++;
			
			/*
			 * used to store the node from where (starting point) 
			 * we want to generate sublist
			 */
			if(length == l) {
				subNode = currNode ;  // subNode points to staring point of l
			}
			currNode = currNode.next;
		}
		/*
		 * subNode is pointing to Node where we want to create sublist 
		 * and rotate that sublist
		 */
		currNode = subNode;
		while(divideFromLast < r){
			currNode = currNode.next;
			divideFromLast++;
		}
		rightSide = currNode.next; // to save the last part of the main Linked List
		
		/*
		 * to make the sublist circular so we connect end node of sublist(currNode)
		 * to subNode(first node of sublist(l)) 
		 */
		currNode.next = subNode; 
		currNode = currNode.next;// now currNode is on the head of sublist pointing to l

		Node compNode = head;
		Node completeNode;

				
		int sizeOfSubList = r-l + 1;
		int front = l-1; // 
		/*
		 * to rotate the sublist
		 */
		if(noOfRotation > sizeOfSubList) {
			noOfRotation = noOfRotation % sizeOfSubList;
		}
		/*
		 * to join the sublist with main Linked List 
		 * if noOfRotation is 0 or equal to sieOfSubList
		 */
		if(noOfRotation == 0 || noOfRotation == sizeOfSubList) {
			for(int i=1; i<=sizeOfSubList+front; i++) {

				if(i<front){
					compNode = compNode.next;
				}
				else if(i == l) {
					compNode.next = currNode;
					compNode = compNode.next;
				}
				else if(i > l) {
					compNode = compNode.next;
				}
			}
			compNode.next = rightSide;
			for(int i = 1; i <= length - r; i++) {
				compNode = compNode.next;
			}
			compNode.next = head;
			completeNode = compNode.next;
			compNode.next = null;
			return completeNode;
		}
		
		/*
		 * rotate subList 
		 */
		noOfRotation = sizeOfSubList - noOfRotation;
		for(int i=1; i<noOfRotation; i++) {
			currNode = currNode.next;
		}
		Node headOfRotatedSubList = currNode.next;
		currNode.next = null;
		
		// join the subList with remaining node of main Linked List
		for(int i=1; i<=sizeOfSubList+front; i++) {

			if(i<front){
				compNode = compNode.next;
			}
			else if(i == l) {
				compNode.next = headOfRotatedSubList;
				compNode = compNode.next;
				
			}
			else if(i > l) {
				compNode = compNode.next;
			}
		}
		compNode.next = rightSide;
		for(int i = 1; i <= length - r; i++) {
			compNode = compNode.next;
		}
		compNode.next = head;
		completeNode = compNode.next;
		compNode.next = null;
		return completeNode;
	}
	
	/**
	 * this method is used to detect loop in the Linked List
	 * Or check Circular Linked List
	 * @return boolean true(if loop is present) / false(no loop)
	 */
	public boolean detectLoop(){
		Node slow_p = head, fast_p = head, currNode = head;
		int flag = 0;
		/*
		* To detect a loop
		*/
		currNode = currNode.next.next.next.next;
		currNode.next = head;
		while (fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                flag = 1;
                break;
            }
        }
        if (flag == 1)
            return true;
        else
            return false;
    }
	
}

