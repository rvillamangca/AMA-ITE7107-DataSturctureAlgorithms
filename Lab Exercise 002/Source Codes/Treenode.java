/* Binary Tree Implementation by Ramon Villamangca */

import java.util.ArrayList;
import java.util.Iterator;

public class Treenode {
	
	private Object data;
	private Treenode leftChild;
	private Treenode rightChild;
	
	public Treenode (Object initData) {
		this.data = initData;
		this.leftChild = null;
		this.rightChild = null;
	}

	public Treenode () {
		this.data = null;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	
	public void setLeftChild(Treenode child) {
		this.leftChild = child;
	}
	
	public void setRightChild(Treenode child) {
		this.rightChild = child;
	}
	
	public void setChildren(Treenode lchild, Treenode rchild) {
		this.leftChild = lchild;
		this.rightChild = rchild;
	}
	
	public List getChildren() {
		List outList = new List();
		if (this.leftChild != null) outList.add(this.leftChild);
		if (this.rightChild != null) outList.add(this.rightChild);
		return outList;
	}
	
	public Object getData() {
		return this.data;
	}	
	public void ex2() {
		ex2 (this);
	}
	
	private void ex2(Treenode root) {
		Queue Q = new Queue(); 										// Q queue should be defined
		Q.enqueue(root);
		int lineNo = 0;
		while (!Q.empty()) {
			lineNo++;
			System.out.println("\tLoop No. " + lineNo + ": " + Q);	// excercise requires "pictures" of Q
			Treenode n = Q.dequeue();
			// System.out.print(n.getData()); 						// this should be suppressed
			List L = n.getChildren();
			Iterator it = L.iterator();
			while (it.hasNext()) {
				Q.enqueue((Treenode) it.next());					// this must be casted as "Treenode" type
			}
		}
	}

	public String preOrder() {
		return preOrder(this);
	}
	private String preOrder(Treenode root) {
		String outString = "";
		if (root != null) {
			outString += root.getData() + " ";
			outString += preOrder(root.leftChild);
			outString += preOrder(root.rightChild);
		}
		return outString;
	}
	
	public String postOrder() {
		return postOrder(this);
	}
	private String postOrder(Treenode root) {
		String outString = "";
		if (root != null) {
			outString += postOrder(root.leftChild);
			outString += postOrder(root.rightChild);
			outString += root.getData() + " ";
		}
		return outString;
	}

	public String levelOrder() {
		return levelOrder(this);
	}	
	private String levelOrder(Treenode root) {
		String outString = "";
		Queue Q = new Queue();
		Q.enqueue(root);
		while (!Q.empty()) {
			Treenode n = Q.dequeue();
			outString += n.getData() + " ";
			List L = n.getChildren();
			Iterator it = L.iterator();
			while (it.hasNext()) {
				Q.enqueue((Treenode) it.next());
			}
		}
		return outString;
	}

	public String inOrder() {
		return inOrder(this);
	}
	private String inOrder(Treenode root) {
		String outString = "";
		if (root != null) {
			outString += inOrder(root.leftChild);
			outString += root.getData() + " ";
			outString += inOrder(root.rightChild);
		}
		return outString;
	}
	
	private class List extends ArrayList<Treenode> {}
	
	private class Queue extends ArrayList<Treenode> {
		public boolean empty() {
			return (this.size() == 0);
		}
		public Treenode first() {
			if (this.empty()) {
				System.out.println("The queue is empty!");
				return null;
			} else {
				return this.get(0);
			}
		}
		public void enqueue(Treenode newElem) {
			this.add(newElem);
		}  
		public Treenode dequeue() {              
			if (this.empty()) {
				System.out.println("WARNING: The queue is empty!");
				return null;
			} else {
				Treenode tempObj = this.get(0);
				this.remove(0);
				return tempObj;
			}
		}		
		@Override
		public String toString() {
			String tempStr = " ";
			for (int i = this.size()-1; i >= 0; i--) {
				if (this.get(i).getData() != null) tempStr += this.get(i).getData() + "   ";
			}
			tempStr = String.format("%1$"+15+ "s", tempStr);
			return tempStr;
		}
	} 
	
}