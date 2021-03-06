package dsalgoproblems.project.programcreek.tree;

import java.util.LinkedList;

/**
 * @author shekh.......................................
 */
public class InvertATree {
	
	public static void invertBinaryTree(TreeNode root){
		if(root == null)
			return;
		
		invertBinaryTree(root.leftChild);
		invertBinaryTree(root.rightChild);
		
		if(root.leftChild!=null && root.rightChild != null){
			TreeNode temp = root.leftChild;
			root.leftChild = root.rightChild;
			root.rightChild = temp;
		}
	}
	
	public static TreeNode invertTree(TreeNode root) {
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	 
	    if(root!=null){
	        queue.add(root);
	    }
	 
	    while(!queue.isEmpty()){
	        TreeNode p = queue.poll();
	        if(p.leftChild!=null)
	            queue.add(p.leftChild);
	        if(p.rightChild!=null)
	            queue.add(p.rightChild);
	 
	        TreeNode temp = p.leftChild;
	        p.leftChild = p.rightChild;
	        p.rightChild = temp;
	    }
	 
	    return root;    
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.leftChild = new TreeNode(2);
		root.leftChild.leftChild = new TreeNode(4);
		root.leftChild.leftChild.leftChild = new TreeNode(10);
		root.leftChild.leftChild.rightChild = new TreeNode(11);
		root.leftChild.rightChild = new TreeNode(5);
		root.rightChild = new TreeNode(3);
		root.rightChild.leftChild = new TreeNode(6);
		root.rightChild.rightChild = new TreeNode(7);
		root.rightChild.rightChild.leftChild = new TreeNode(8);
		root.rightChild.rightChild.rightChild = new TreeNode(9);
		System.out.println("\nOld Tree:");
		LevelOrderTraversal.levelOrderTraversal(root);
		invertTree(root);
		System.out.println("\nNew Tree:");
		LevelOrderTraversal.levelOrderTraversal(root);
		/*
		 * Original Tree
		 *         1					
   		 *	     /   \	
  		 *	    2     3
 		 *	   / \   / \				
		 *    4   5 6   7
		 *	 / \	   / \
		 *	10 11	  8   9
		 */
		
		/*
		 * New Tree
		 *         1					
   		 *	     /   \	
  		 *	    3     2
 		 *	   / \   / \				
		 *    7   6 5   4
		 *	 / \	   / \
		 *	9   8	  11 10
		 */


		//Another Example:
		System.out.println("Another Example!!!!");
		root = new TreeNode(50);
		root.leftChild = new TreeNode(40);
		root.leftChild.leftChild = new TreeNode(30);
		root.leftChild.leftChild.leftChild = new TreeNode(20);
		root.leftChild.rightChild = new TreeNode(45);
		root.leftChild.rightChild.rightChild = new TreeNode(47);
		root.leftChild.rightChild.rightChild.leftChild = new TreeNode(46);
		root.leftChild.rightChild.rightChild.rightChild = new TreeNode(48);
		root.leftChild.rightChild.rightChild.rightChild.rightChild = new TreeNode(49);


		root.rightChild = new TreeNode(80);
		root.rightChild.leftChild = new TreeNode(70);
		root.rightChild.rightChild = new TreeNode(90);

		System.out.println("\nOld Tree:");
		LevelOrderTraversal.levelOrderTraversal(root);
		invertTree(root);
		System.out.println("\nNew Tree:");
		LevelOrderTraversal.levelOrderTraversal(root);

		/*
		 * Original Tree
		 *          50
		 *	     /      \
		 *	    40      80
		 *	   / \     /  \
		 *    30 45   70  90
		 *	 / 	   \
		 *	20 	   47
		 *		  /  \
		 *		 46  48
		 *		 	  \
		 *		 	  49
		 */

		/*
		 * New Tree
		 *          50
		 *	     /      \
		 *	    80      40
		 *	   / \     /  \
		 *	  90  70  45  30
		 *	 		 /	    \
		 *	 		47 		20
		 *		   /  \
		 * 		  48  46
		 * 		 /
		 * 		49
		 */
	}
}