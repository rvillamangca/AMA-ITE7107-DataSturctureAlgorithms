/* Treenode Class Demo */

public class TreenodeDemo {

	public static void main (String[] args) {
		
		Treenode A = new Treenode("A"); Treenode B = new Treenode("B"); Treenode C = new Treenode("C");
		Treenode D = new Treenode("D"); Treenode E = new Treenode("E"); Treenode F = new Treenode("F");
		Treenode G = new Treenode("G"); Treenode H = new Treenode("H"); Treenode I = new Treenode("I");
		
		A.setChildren(B,C); B.setLeftChild(D); C.setChildren(E,F); E.setRightChild(G); F.setChildren(H,I);
		
		System.out.println("\nThe Queue content in each Traversal Loop are: \n"); A.ex2(); System.out.println();
		System.out.println("The Final Output for this Traversal will be: "  + A.levelOrder());
	}
}