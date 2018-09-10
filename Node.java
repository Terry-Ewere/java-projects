/**
 * Program to implement the Node class
 * @author 
 *
 * @param <K> is the K Type
 * @param <V> is the V Type
 */
public class Node<K, V> {
	private V data;
	private K key;
	Node<K, V> next;

	/**
	 * Overloaded constructor
	 * @param key is the key
	 * @param next is the next key
	 * @param data is the data
	 */
	public Node(K key, Node<K, V> next, V data) {
		this.key = key;
		this.data = data;
		this.next = next;

	}

	/**
	 * Function to get the data
	 * @return data
	 */
	public V getData() {

		return data;

	}

		/**
		 * Function to get the next data
		 * @return next data
		 */
	public Node<K, V> getNext() {

		return next;
	}
	
	/**
	 * Function to set data
	 * @param newData is the new data
	 */
	public void setData(V newData) {

		this.data = newData;
	}
	/**
	 * Function to set the next node
	 * @param newNext is  the next node
	 */
	public void setNext(Node<K, V> newNext) {

		this.next = newNext;
	}
	/**
	 * Function to get the key
	 * @return key
	 */
	public K getKey() {
		return key;
	}

}
