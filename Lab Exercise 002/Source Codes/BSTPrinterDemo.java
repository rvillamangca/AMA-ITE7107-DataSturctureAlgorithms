/* Binary Search Tree Printer Implementation by Ramon Villamangca */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BSTPrinterDemo {

    private static void BSTinsert (Integer newData, Tree<Integer> root) {
        Tree<Integer> newTree = new Tree<Integer>(newData);
        if (root == null) {
            root = newTree;
        } else {
            Tree<Integer> current = root;
            Tree<Integer> parent = new Tree<Integer>(0);
            while (true) {
                parent = current;
                if (newData < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newTree;
                        break;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newTree;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Tree<Integer> tree1 = new Tree<Integer>(5);
        BSTinsert(3, tree1); BSTinsert(7, tree1); BSTinsert(6, tree1); 
        BSTinsert(2, tree1); BSTinsert(1, tree1); BSTinsert(4, tree1);        
        System.out.println("\nBinary Search Tree for [5 3 7 6 2 1 4]:\n");
        BTreePrinter.printTree(tree1);

        Tree<Integer> tree2 = new Tree<Integer>(1);
        BSTinsert(2, tree2); BSTinsert(3, tree2); BSTinsert(4, tree2); 
        BSTinsert(5, tree2); BSTinsert(6, tree2); BSTinsert(7, tree2);
        System.out.println("\nBinary Search Tree for [1 2 3 4 5 6 7]:\n"); 
        BTreePrinter.printTree(tree2);


        Tree<Integer> tree3 = new Tree<Integer>(4);
        BSTinsert(3, tree3); BSTinsert(5, tree3); BSTinsert(2, tree3); 
        BSTinsert(6, tree3); BSTinsert(1, tree3); BSTinsert(7, tree3);
        System.out.println("\nBinary Search Tree for [4 3 5 2 6 1 7]:\n");
        BTreePrinter.printTree(tree3);
    }
}

class Tree<T extends Comparable<?>> {
    T data;
    Tree<T> left, right;

    public Tree(T initData) {
        this.data = initData;
        left = null; right = null;
    }
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printTree(Tree<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printTreeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printTreeInternal(List<Tree<T>> Trees, int level, int maxLevel) {
        if (Trees.isEmpty() || BTreePrinter.isAllElementsNull(Trees))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Tree<T>> newTrees = new ArrayList<Tree<T>>();
        for (Tree<T> Tree : Trees) {
            if (Tree != null) {
                System.out.print(Tree.data);
                newTrees.add(Tree.left);
                newTrees.add(Tree.right);
            } else {
                newTrees.add(null);
                newTrees.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < Trees.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (Trees.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (Trees.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (Trees.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printTreeInternal(newTrees, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Tree<T> Tree) {
        if (Tree == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(Tree.left), BTreePrinter.maxLevel(Tree.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}