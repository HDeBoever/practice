/*
 * CSC115 Assignment 4 : part of Patient Location 
 * BinaryTree.java : 
 * March, 2016
 * Henri De Boever V00752288 
 */

 
public class BinaryTree<E> {

	/* The root is inherited by any subclass
	 * so it must be protected instead of private.
	 */
	protected TreeNode<E> root;

	/**
	 * Create an empty BinaryTree.
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * Create a BinaryTree with a single item.
	 * @param item The only item in the tree.
	 */
	public BinaryTree(E item) {
		root = new TreeNode<E>(item);
	}

	/**
	 * Used only by subclasses and classes in the same package (directory).
	 * @return The root node of the tree.
	 */
	protected TreeNode<E> getRoot() {
		return root;
	}
	
	//returns a boolean value whether the tree is empty or not
	public boolean isEmpty(){
		if(getRoot() == null){
			return true;
		}else{
			return false;
		}
	}
	
	//Makes the tree empty
	public void makeEmpty(){
		root = null;
	}
	
	//returns the height of the tree
	public int height(){
		return heightAt(root);
	}
	
	//private method to recursive calculate height
	private int heightAt(TreeNode<E> root){
		//use a recursive method 
		if(root == null){
			return 0;
		}else{
			return 1 + Math.max(heightAt(root.left), heightAt(root.right));
		}
	}
}

	
