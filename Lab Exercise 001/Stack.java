/* Java Stack Implementation Using ArrayList by Ramon Villamangca */

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack {
	
	private class Node {			// an inner class node is needed to implement "Linked List" stack
		public Object data;			// problem no. 2 hints that the "required" stack elements
									// data type, for this excercise, is the Object class type
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

   private Node top;				// the "top" of the stack
   private int counter;				// this is the internal stack counter

	// constructor
    public Stack() {
		top = new Node();
		counter = 0;
    }

	// basic methods
    public int size() {             // returns the current number of elements in the stack
		return counter; 
    }
    public boolean isEmpty() {		// test for an empty stack
		return counter == 0; 
    }
	public void clear() {			// clears the stack
		top = new Node();
		counter = 0;
	}
	public Object peek() {			// the module presentation calls this method as topEl()
		if (this.isEmpty()) {
			System.out.println("The stack is empty!");
			return null;
		} else {
			return top.data;
		}
	}
	
	// toString() method override
	@Override
	public String toString() {
		if (this.isEmpty()) return "The stack is empty.";
		String tempStr = "";
		Node tempNode = top;
		while (tempNode != null) {
			tempStr = tempStr + tempNode.data.toString() + " ";
			tempNode = tempNode.nextNode;
		}
		return tempStr;
	}   

	// push method
    public void push(Object newElem) {
		Node tempNode = new Node(newElem);
		if (this.isEmpty()) {
			this.top.data = newElem;
		} else {
			tempNode.nextNode = top;
			top = tempNode;
		}
		counter++;
    }  

  // pop method
    public Object pop() throws EmptyStackException {
      try {                                 // this try-catch block is needed so that the program 
        if (this.isEmpty()) {               // would not crash when the EmptyStackException
          throw new EmptyStackException();  // error is encountered
        } else {
			Object tempData = top.data;
			top = top.nextNode;
			counter--;
			return tempData;
        }
      } catch (EmptyStackException e) {
        System.err.println("WARNING: The stack is empty!"); // instead of "crashing" the program a warning 
        return null;                                        // message will be printed on screen and then 
                                                            // the pop() method returns a "null" pointer
      }
    }
}  
