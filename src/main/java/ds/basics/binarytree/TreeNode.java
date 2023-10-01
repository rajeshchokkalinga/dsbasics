package ds.basics.binarytree;

/**
 *						 25
 *                    /      \
 *                  /          \
 * 				  /              \
 *			    /                  \
 *		     15                     50
 *		  /    \                  /    \
**     10       22             35        70
 *	  /  \     /   \         /   \		/   \
 *  4     12  18    24      31    44   66    90
 *
 *
 * In order traverse : 4,10, 12,15, 18, 22, 24,25, 31,35, 44,50, 66, 70, 90
 * Pre-order traverse: 25,15,10, 4, 12, 22, 18, 24,50, 35,31,44,70, 66, 90
 * Post - Order traverse : 4,12,10,18,24,22,15,31,44,35,66,90,70,50,25
 * */
public class TreeNode {
	private Integer data;
	private TreeNode leftChild;
	private TreeNode rightChild;

	public TreeNode(Integer data) {
		this.data = data;
	}
	
	public static TreeNode addSorted(int[] data, int start, int end) {
		if (end >= start) {
			int mid = (start+end)/2;
			TreeNode newNode = new TreeNode(data[mid]);
			newNode.leftChild = addSorted(data, start, mid-1);
			newNode.rightChild = addSorted(data, mid+1, end);
			return newNode;
		}
		return null;
	}
	
	public int height() {
		if (isLeaf()) return 1;
		int left = 0;
		int right = 0;
		if (this.leftChild != null)
			left = this.leftChild.height();
		if (this.rightChild != null)
			right = this.rightChild.height();
		return (left > right) ? (left + 1) : (right + 1);
	}
	
	public int numOfLeafNodes() {
		if (isLeaf()) return 1;
		int leftLeaves = 0;
		int rightLeaves = 0;
		if (this.leftChild != null)
			leftLeaves = leftChild.numOfLeafNodes();
		if (this.rightChild != null)
			rightLeaves = rightChild.numOfLeafNodes();
		return leftLeaves + rightLeaves;
	}
	
	public boolean isLeaf() {
		return this.leftChild == null && this.rightChild == null;
	}

	public void traverseInOrder() {
		if (this.leftChild != null)
			this.leftChild.traverseInOrder();
		System.out.print(this + " ");
		if (this.rightChild != null)
			this.rightChild.traverseInOrder();
	}

	public TreeNode find(Integer data) {
		if (this.data == data)
			return this;
		if (data < this.data && leftChild != null)
			return leftChild.find(data);
		if (rightChild != null)
			return rightChild.find(data);
		return null;
	}

	public void insert(Integer data) {
		if (data >= this.data) { // insert in right subtree
			if (this.rightChild == null)
				this.rightChild = new TreeNode(data);
			else
				this.rightChild.insert(data);
		} else { // insert in left subtree
			if (this.leftChild == null)
				this.leftChild = new TreeNode(data);
			else
				this.leftChild.insert(data);
		}
	}

	public Integer largest() {
		if (this.rightChild == null)
			return this.data;
		return this.rightChild.largest();
	}

	public Integer smallest() {
		if (this.leftChild == null)
			return this.data;
		return this.leftChild.smallest();
	}

	public Integer getData() {
		return data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode left) {
		this.leftChild = left;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode right) {
		this.rightChild = right;
	}

	@Override
	public String toString() {
		return String.valueOf(this.data);
	}
}
