/* Stack Class Demo */

public class StackDemo {
	public static void main (String[] args) {
		Stack myStack = new Stack();
		
		//System.out.println();
		System.out.print("\n\tPopping an empty stack:\t\t\t\t\t");
		myStack.pop();		// since we have caught this "EmptyStackException"
							// error, the program will not "crash" at this point
							// and will continue to execute
		myStack.push("A"); myStack.push("B"); myStack.push("C");
		System.out.println("\tStack after 3 pushes (top of Stack at left):\t\t" + myStack);
		myStack.push("D"); myStack.push("E"); myStack.push("F");
		myStack.push("G"); myStack.push("H"); myStack.push("I");
		System.out.println("\tStack after more pushes:\t\t\t\t" + myStack);
		System.out.println("\tStack after popping top 2 elements \"" + myStack.pop() 
							+ "\" and \"" + myStack.pop() + "\":\t\t" + myStack);
		myStack.clear();
		System.out.println("\tStack after clearing:\t\t\t\t\t" + myStack + "\n");
	}
}