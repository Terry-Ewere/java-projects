/**
 * Singly LinkedList data structure implementation
 * @author Osahon Terry Ewere
 *
 * @param <K> is the K type
 * @param <V> is the V type
 */
public class SLL<K extends Comparable<K>, V> {

	private Node<K, V> head;
	
	/**
	 * Default constructor
	 */
	public SLL() {

		head = null;
	}

	/**
	 * Function to get the head
	 * @return the head
	 */
	public Node<K, V> getHead() {

		return head;
	}

	public void setHead(Node<K, V> newHead) {

		this.head = newHead;

	}
/**
 * Function to print all the data
 */
	public void print() {

		Node<K, V> current = head;

		while (current != null) {

			System.out.println(current.getData() + "\n");

			current = current.getNext();
		}
		System.out.println();
	}

	/**
	 * Function to insert a key and data
	 * @param key is the key to be inserted
	 * @param data is the data associated with the key to be inserted
	 */
	public void insert(K key, V data) {

		Node<K, V> e = new Node<K, V>(key, null, data);
		if (head == null) {

			head = e;

		} else {

			Node<K, V> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(e);

		}

		e.setNext(null);
	}

	public boolean isEmpty() {

		return head == null;
	}
/**
 * Function to check if the key is present
 * @param key is the key to check for
 * @return true if it contains  the given key otherwise false
 */
	public boolean contains(K key) {

		Node<K, V> current = head;

		while (current != null) {

			if (current.getKey().equals(key))

				return true;

			current = current.getNext();

		}
		return false;
	}
	/**
	 * Function to get the value corresponding to the given key
	 * @param key is the key to get the data
	 * @return return the value associated with the key
	 */
	public V getData(K key) {

		Node<K, V> current = head;

		while ((current != null) && (!current.getKey().equals(key))) {

			current = current.getNext();

		}
		return current.getData();
	}
/**
 * Function to delete a key which in turn removes the value associated with the key
 * @param key is the key to be removed
 */
	public void remove(K key) {
		if (head == null)
			throw new RuntimeException("cannot delete");

		if (head.getKey().equals(key)) {
			head = head.next;
			return;
		}

		Node<K, V> cur = head;
		Node<K, V> prev = null;

		while (cur != null && !cur.getKey().equals(key)) {
			prev = cur;
			cur = cur.next;
		}

		if (cur == null)
			throw new RuntimeException("cannot delete");

		prev.next = cur.next;
	}

}
