/* Treenode Class Demo */

public class TreenodeDemo2 {

	public static void main (String[] args) {

		Treenode A = new Treenode("A"); Treenode B = new Treenode("B"); Treenode C = new Treenode("C");
		Treenode D = new Treenode("D"); Treenode E = new Treenode("E"); Treenode F = new Treenode("F");
		Treenode G = new Treenode("G"); Treenode H = new Treenode("H"); Treenode I = new Treenode("I");
		Treenode J = new Treenode("J"); Treenode K = new Treenode("K");
		
		A.setChildren(B,C); B.setChildren(D,E); C.setChildren(F,G); D.setRightChild(H);
		E.setLeftChild(I); F.setChildren(J,K);
		
		System.out.println("\n\n  (a) Tree Preorder Traversal:\t\t" + A.preOrder());
		System.out.println("  (b) Tree Postorder Traversal:\t\t" + A.postOrder());
		System.out.println("  (c) Tree Levelorder Traversal:\t" + A.levelOrder());
		System.out.println("  (d) Tree Inorder Traversal:\t\t" + A.inOrder() + "\n\n");
		System.out.println();
	}
}