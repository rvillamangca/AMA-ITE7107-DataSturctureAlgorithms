/* Queue Implementation Using Linked List by Ramon Villamangca */

import java.util.ArrayList;

public class Queue {
	
	private class Node {			// an inner class node is needed to implement "Linked List" queue
		public Object data;			
		public Node nextNode;
		
		public Node(){
			data = null;
			nextNode = null;
		}
		public Node(Object initData) {
			data = initData;
			nextNode = null;
		}
	}
	
	private Node front;				// the first element of the queue
	private Node back;				// the last element of the queue
	private int counter;			// this is the internal queue counter

	private ArrayList <Object> elements;

	// constructor
    public Queue() {
		front = new Node();
		back = new Node();
		counter = 0;
    }

	// basic methods
    public int size() {				// returns the current number of elements in the queue
		return counter;
    }
    public boolean isEmpty() {      // test for an empty queue
		return counter == 0;
    }
	public Object first() {			// the module presentation calls this method as firstEl()
		return front.data;
	}
	
	// toString() method override
	@Override
	public String toString() {
		if (this.isEmpty()) return "The queue is empty.";
		String tempStr = "";
		Node tempNode = front;
		while (tempNode != null) {
			tempStr = tempStr + tempNode.data.toString() + " ";
			tempNode = tempNode.nextNode;
		}
		return tempStr;
	}  
    
  // enqueue method
    public void enqueue(Object newData) {
    	Node newNode = new Node(newData);
		if (this.isEmpty()) {
			front = newNode;
			back = front;
		} else {
			Node prevBack = back;
			back = newNode;
			prevBack.nextNode = back;
		}
		counter++;
    }  

  // dequeue method
    public Object dequeue() {              
		if (this.isEmpty()) {
			System.out.println("WARNING: The queue is empty!");
			return null;
		} else {
			Object tempData = front.data;
			front = front.nextNode;
			counter--;
			return tempData;
		}
    }
	
}  