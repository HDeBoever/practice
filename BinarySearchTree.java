/*
 * CSC115 Assignment 4 : part of Patient Location 
 * BinarySearchTree.java : Uses a Binary Search Tree ADT to store nodes and items
 * March, 2016
 * Henri De Boever V00752288 
 */

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	// the root is inherited from BinaryTree.

	/**
	 * Create an empty BinarySearchTree.
	 */
	public BinarySearchTree() {
		super();
	}
	
	public void insert(E item){
		//check if node to insert is already in tree, do nothing if item is already there
		if(notInTree(root, item)){
			root = insertItem(root, item);
		}
	}
	
	public void delete(E item){
		//This method deletes the node and the item contained in the node recursively by calling helper methods
		root = deleteItem(root, item);
	}
	
	public E retrieve(E item){
		//This method returns an item in a certain node
		return retrieveItem(root, item);
	}
	
	//**************Helper methods*****************// 
	
	private TreeNode<E> insertItem(TreeNode<E> node, E item){
		//Inserts a new item into the tree, maintaining its order. If the item already exists in the tree, nothing happens.
		
		TreeNode<E> newSubTree;
		if(node == null){
			node = new TreeNode<E>(item, null, null);
			return node;
		}
		if(item.compareTo(node.item) < 0){
			newSubTree = insertItem(node.left, item);
			node.left = newSubTree;
			return node;
		}else{
			newSubTree = insertItem(node.right, item);
			node.right = newSubTree;
			return node;
		}
	}
	
	private TreeNode<E> deleteItem(TreeNode<E> node, E item){
		//This method deletes the item located in a node
		TreeNode<E> newSubTree;
		if(node  == null){
			System.out.println("Item to delete not found");
			return null;
		}else{
			E nodeItem = node.item;
			if(nodeItem.compareTo(item) == 0){
				//then item is in the root of some subtree
				node = deleteNode(node);
			}else if(nodeItem.compareTo(item) > 0){
				//look in the left subtree
				newSubTree = deleteItem(node.left, item);
				node.left = newSubTree;
			}else if(nodeItem.compareTo(item) < 0){
				//look in the right subtree
				newSubTree = deleteItem(node.right, item);
				node.right = newSubTree;
			}
		}
		return node;
	}
	
	private TreeNode<E> deleteNode(TreeNode<E> node){
		// This method deletes a node in a tree. 4 cases to consider when deleting a node from the binary search tree
		// 1. node is a leaf
		// 2. node has no left child
		// 3. node has no right child
		// 4. node has 2 children
		
		node = searchNode(root, node.item);      
		if(node.left == null && node.right == null){
			return null;
		}else if(node.left == null){  
			return node.right;
		}else if(node.right == null){
			return node.left;          
		}else{
			E temp = findFurthestLeft(node.right);
			node.item = temp;
			node.right = removeLeftMost(node.right);
			return node;
		}
	}
	
	private E retrieveItem(TreeNode<E> node, E item){
		//This method retrieves a item in the tree
		E treeItem;
		if(root == null){
			return null;			
		}else{
			E nodeItem = node.item;
			if(item.compareTo(node.item) == 0){
				//item is in the root of some subtree
				treeItem = node.item;
			}else if(item.compareTo(node.item) < 0){
				//search the left subtree
				treeItem = retrieveItem(node.left, item);
			}else{
				//search the right subtree for the item
				treeItem = retrieveItem(node.right, item);
			}
		}
		return treeItem;
	}
	
	private boolean notInTree(TreeNode<E> node, E item){
		//This methods finds out if a node is in the binary search tree
		if(node == null){
			return true;			
		}else{
			if(item.compareTo(node.item) == 0){
				//item is in the root of some subtree
				return false;
			}else if(item.compareTo(node.item) < 0){
				//search the left subtree
				return notInTree(node.left, item);
			}else{
				//search the right subtree for the item
				return notInTree(node.right, item);
			}
		}
	}
	
	private TreeNode<E> searchNode(TreeNode<E> node, E item){
		// This method returns the node you are looking for. If the nodes are identical, return the node
		if(node == null){
			System.out.println("cannot search for a null node");
			return null;
		}else if(item.compareTo(node.item) == 0){ 
			return node;
		}else if(item.compareTo(node.item) < 0){
			return searchNode(node.left, item);
		}else{
			return searchNode(node.right, item);
		}
	}
	
	private E findFurthestLeft(TreeNode<E> node){
		//This method finds the node furthest on the left of the Binary Serach Tree
		if(node.left == null){
			return node.item;
		}else{
			return findFurthestLeft(node.left);
		}
	}
	
	private TreeNode<E> removeLeftMost(TreeNode<E> node){
		//Thi method deletes the node furthet on the left of a said subTree.
		if(node.left  == null){
			return node.right;
		}else{
			node.left = removeLeftMost(node.left);
			return node;
		}
	}
	
	/**
	 * Places all the items in the tree into a sorted list.
	 * @return the sorted list.
	 */
	public ArrayList<E> inOrder() {
		ArrayList<E> list = new ArrayList<E>();
		collectInOrder(list,root);
		return list;
	}
	
	private void collectInOrder(ArrayList<E> list, TreeNode<E> node) {
		//This method traverses and orders the items in the list (inorder traversal)
		if(node != null){ 
			collectInOrder(list, node.left);
			list.add(node.item); 
			collectInOrder(list, node.right);
		}
	}

	/**
	 * Internal test harness.
	 * @param args Not used.
	 */
	public static void main(String[] args) {

		BinarySearchTree<PatientLocation> tree = new BinarySearchTree<PatientLocation>();
		PatientLocation p1 = new PatientLocation("Zola", "Emile", 338);
		PatientLocation p2 = new PatientLocation("Hugo", "Victor",116);
		PatientLocation p3 = new PatientLocation("Von Leibniz", "Gottfried",422);
		PatientLocation p4 = new PatientLocation("Euler","Leonhard",607);
		PatientLocation p5 = new PatientLocation("Earhart","Amelia",234);
		PatientLocation p6 = new PatientLocation("De Boever","Henri",148);
		PatientLocation p7 = new PatientLocation("Marseille","Hans Joachim",19);
		PatientLocation p8 = new PatientLocation("de St. Exupery","Antoine",178);
		PatientLocation p9 = new PatientLocation("Karenina","Anna",178);
		PatientLocation p10 = new PatientLocation("Curie","Marie",17);
		PatientLocation p11 = new PatientLocation("Oppenheimer","Robert",17);
		PatientLocation p12 = new PatientLocation("Sanders","Bernie",97);
		PatientLocation p13 = new PatientLocation("Chopin","Frederic",95);
		PatientLocation p14 = new PatientLocation("Anquetil","Jacques",277);
		PatientLocation p15 = new PatientLocation("Bonaparte","Napoleon",1805);
		
		//insertions  (all working so far)
		tree.insert(p13);
		tree.insert(p14);
		tree.insert(p7);
		tree.insert(p4);
		tree.insert(p3);
		tree.insert(p2);
		tree.insert(p1);
		tree.insert(p8);
		tree.insert(p5);
		tree.insert(p9);
		tree.insert(p6);
		tree.insert(p11);
		tree.insert(p11);		//program disallows multiple insertions
		tree.insert(p11);		
		tree.insert(p11);		
		tree.insert(p11);		
		tree.insert(p11);		
		tree.insert(p10);
		tree.insert(p12);
		
		//searches
		//tree.searchNode(p1);
		//tree.searchNode(p6);
		
		//retrievals    I was able to get output by sop'ing in retrieve. seems like it works now
		
		//tree.retrieve(p1);
		//tree.retrieve(p7);
		//tree.retrieve(p11);
		
		//removals      
		//tree.delete(p7);    //removing root works, also works if root has no children   
		//tree.delete(p4);	  //removing leaf		   
		//tree.delete(p3);	  //removing sub tree node	works	   
		//tree.delete(p13);
		//tree.delete(p14);
		//tree.delete(p6);
		
		//EXTERNAL TESTS FOR BINARY TREE.JAVA//
		System.out.println(tree.isEmpty());  //should print false
		System.out.println("Height is " + tree.height()); //testing height, should say 0
		System.out.println(tree.isEmpty()); //should print true 
		
		//testing getRoot()
		System.out.println(tree.getRoot().item);  //should print p13

		//testing makeEmpty()
		//tree.makeEmpty();  //makeEmpty works
		
		ArrayList<PatientLocation> list  = tree.inOrder();
		System.out.println(list);
		// draw the tree in its current state:
		DrawableBTree<PatientLocation> dbt = new DrawableBTree<PatientLocation>(tree);
		dbt.showFrame();

		/* BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();
		
		Integer A = new Integer(1);
		Integer B = new Integer(2);
		Integer C = new Integer(3);
		Integer D = new Integer(4);
		Integer E = new Integer(194);
		Integer F = new Integer(75);
		Integer G = new Integer(-23);
		Integer H = new Integer(1867);
		intTree.insert(F);
		intTree.insert(G);
		intTree.insert(E);
		intTree.insert(A);
		intTree.insert(C);
		intTree.insert(B);
		intTree.insert(D);
		intTree.insert(H);
		ArrayList<Integer> list  = intTree.inOrder();
		System.out.println(list);
		// draw the tree in its current state:
		DrawableBTree<Integer> dbt = new DrawableBTree<Integer>(intTree);
		dbt.showFrame();
	 */
		
	}
}
