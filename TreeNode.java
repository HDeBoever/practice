class TreeNode<E> {
	
	//saved in assignment 4 folder
	E item;
	TreeNode<E> left;
	TreeNode<E> right;

	TreeNode(E item, TreeNode<E> left, TreeNode<E> right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}

	TreeNode(E item) {
		this(item,null,null);
	}

	TreeNode() {
		this(null);
	}
}
