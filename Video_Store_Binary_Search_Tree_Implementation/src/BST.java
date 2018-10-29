

public class BST<K extends Comparable<K>, V> {

	private BSTNode<K, V> root;


	/* Constructor */
	public BST() {
		root = null;
	}

	/* Function to check if tree is empty */
	public boolean isEmpty() {
		return root == null;
	}

	/* Functions to insert data */
	public void insert(K key, V data) {
		root = insert(root, key, data);
	}

	private BSTNode<K, V> insert(BSTNode<K, V> n, K key, V data) throws IllegalArgumentException {

		if (n == null) {
			return new BSTNode<K, V>(key, null, null, data);
		}

		if (n.getKey().equals(key)) {
			throw new IllegalArgumentException();
		}

		if (key.compareTo(n.getKey()) < 0) {
			// add key to the left subtree
			n.setLeft(insert(n.getLeft(), key, data));
			return n;
		}

		else {
			// add key to the right subtree
			n.setRight(insert(n.getRight(), key, data));
			return n;
		}
	}

	public void remove(K key) {

		root = remove(root, key);
	}

	private BSTNode<K, V> remove(BSTNode<K, V> n, K key) {
		if (n == null) {
			return null;
		}

		if (key.equals(n.getKey())) {
			// n is the node to be removed
			// code must be added here
			if (n.getLeft() == null && n.getRight() == null) {
				return null;
			}
			if (n.getLeft() == null) {
				return n.getRight();
			}
			if (n.getRight() == null) {
				return n.getLeft();
			}

			// if we get here, then n has 2 children
			//@SuppressWarnings("unchecked")
			BSTNode<K, V> smallVal = (n.getRight());
			n.setKey(smallVal.getKey());
			n.setRight(remove(n.getRight(), smallVal.getKey()));
			return n;
		}

		else if (key.compareTo(n.getKey()) < 0) {
			n.setLeft(remove(n.getLeft(), key));
			return n;
		}

		else {
			n.setRight(remove(n.getRight(), key));
			return n;
		}
	}

	public boolean contains(K key) {
		return contains(root, key);
	}

	private boolean contains(BSTNode<K, V> n, K key) {
		if (n == null) {
			return false;
		}

		if (n.getKey().equals(key)) {
			//System.out.println(n.getData());
			return true;
		}

		if (key.compareTo(n.getKey()) < 0) {
			// key < this node's key; look in left subtree
			return contains(n.getLeft(), key);
		}

		else {
			// key > this node's key; look in right subtree
			return contains(n.getRight(), key);
		}
	}

	public void print() {
		print(root);
	}

	private void print(BSTNode<K, V> r) {
		if (r != null) {
			print(r.getLeft());
			System.out.println(r.getData() + "\n");
			print(r.getRight());

		}
		// System.out.println();
	}

	public V getData(K key) {
		return getData(root, key);
	}

	private V getData(BSTNode<K, V> n, K key) {
		if (n == null) {
			return null;
		}

		if (n.getKey().equals(key)) {
			// System.out.println(n.getData());
			return n.getData();
		}

		if (key.compareTo(n.getKey()) < 0) {
			// key < this node's key; look in left subtree
			return getData(n.getLeft(), key);
		}

		else {
			// key > this node's key; look in right subtree
			return getData(n.getRight(), key);
		}
	}

}
