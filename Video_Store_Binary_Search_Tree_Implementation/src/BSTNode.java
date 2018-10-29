

class BSTNode<K, V> {
	private BSTNode<K, V> left;
	private BSTNode<K, V> right;
	private V data;
	private K key;

	/* Constructor */
	public BSTNode() {
		left = null;
		right = null;
		data = null;
		key = null;
	}

	/* Constructor */
	public BSTNode(K key, BSTNode<K, V> left, BSTNode<K, V> right, V data) {
		/*
		 * left = null; right = null; data = data;
		 */
		this.left = left;
		this.right = right;
		this.key = key;
		this.data = data;
	}

	// Function to set left node
	public void setLeft(BSTNode<K, V> n) {
		left = n;
	}

	// Function to set right node
	public void setRight(BSTNode<K, V> n) {
		right = n;
	}

	// Function to get left node
	public BSTNode<K, V> getLeft() {
		return left;
	}

	// Function to get right node
	public BSTNode<K, V> getRight() {
		return right;
	}

	// Function to set data to node
	public void setData(V d) {
		data = d;
	}

	// Function to get data from node
	public V getData() {
		return data;
	}

	// Function to get key
	public K getKey() {
		return key;
	}

	// Function to set Key
	public void setKey(K newK) {
		key = newK;
	}
}
