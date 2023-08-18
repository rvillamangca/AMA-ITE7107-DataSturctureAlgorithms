/* Queue Class Demo */

public class QueueDemo {
	
	public static void reverseQ(Queue q) {
		// precondition: q contains x1 x2 ... xN (with x1 at the front)
		// postcondition: q contains xN ... x2 x1 (with xN at the front)
		
		Stack s = new Stack();
		while (!q.isEmpty()) {
			s.push(q.dequeue());
		}
		while (!s.isEmpty()) {
			q.enqueue(s.pop());
		}	
	}
	
	public static void main (String[] args) {
		Queue myQueue = new Queue();
		myQueue.enqueue("xA"); myQueue.enqueue("xB"); myQueue.enqueue("xC");  	// testing enqueue() method
		System.out.println("\n\tQueue after 3 enqueues (front of Queue is at left):\t" + myQueue);
		myQueue.enqueue("x1"); myQueue.enqueue("x2"); myQueue.enqueue("x3");
		myQueue.enqueue("x4"); myQueue.enqueue("x5"); myQueue.enqueue("x6");
		System.out.println("\tQueue after additional enqueues:\t\t\t" + myQueue);		
		myQueue.dequeue(); myQueue.dequeue(); myQueue.dequeue();				// testing dequeue() method
		System.out.println("\tQueue after 3 dequeues:\t\t\t\t\t" + myQueue);
		reverseQ (myQueue);		// test reverseQ() method
		System.out.println("\tQueue after after reversing:\t\t\t\t" + myQueue);
		myQueue.enqueue("x0");		// further enqueuing the reversed queue
		System.out.println("\tQueue after 1 more enqueue:\t\t\t\t" + myQueue);
		myQueue.dequeue();		// further dequeuing the reversed queue
		System.out.println("\tQueue after 1 more dequeue:\t\t\t\t" + myQueue);
		System.out.println();
	}
}