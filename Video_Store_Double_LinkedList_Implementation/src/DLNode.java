/**
 * Program to implement Doubly LinkedList Data Structure
 * @author 
 *
 * @param <K> is the K Type
 * @param <V> is the V Tyoe
 */

public class DLNode<K, V> {
	private V data;
	private DLNode<K, V> next;
	private DLNode<K, V> prev;
	private K key;
	private K Nextkey;
	private K PrevKey;
	
	/**
	 *  Default constructor
	 */
	DLNode() {
		next = null;
		prev = null;
		data = null;
		key = null;
		Nextkey = null;
		PrevKey = null;
	}

	/**
	 * Overloaded constructor
	 * @param data is the data
	 * @param next is the next node
	 * @param prev is the previous node
	 * @param key is  the key associated with the node
	 */

	DLNode(V data, DLNode<K, V> next, DLNode<K, V> prev, K key) {
		this.data = data;
		this.next = next;
		this.prev = prev;
		this.key = key;
	}
	/**
	 * Functiuon to set the key
	 * @param newK is the new key
	 */
	public void setKey( K newK) {
		
		key = newK;
	}
	/**
	 * Overloaded constructor
	 * @param key is the key
	 * @param data is the data
	 */
	public DLNode(K key, V data ) {
		this.data = data;
		this.key = key;
	}
	/**
	 * Function to set the next key
	 * @param nextK
	 */
	void setNextKey( K nextK) {
		Nextkey = nextK;
	}
	/**
	 * Function to set the previous key
	 * @param preK is the key
	 */
	void setpretKey( K preK) {
		PrevKey = preK;
	}
	/**
	 * Function to get the next key
	 * @return the next key
	 */
	K getNextKey() {
		return Nextkey;
	}
	/**
	 * Function to get the previous key
	 * @return the previous key
	 */
	K getpretKey( ) {
		return PrevKey;
	}
	/**
	 * 
	 * @return the data
	 */
	V getData() {
		return data;
	}
	/**
	 * 
	 * @return the key
	 */
	K getKey() {

		return key;
	}
	/**
	 * Set the next node
	 * @param next is the next node
	 */
	public void setNextNode(DLNode<K, V> next) {
		this.next = next;
	}
	/**
	 * Function to get the previous node
	 * @return the previuos node
	 */
	public DLNode<K, V> getPrevNode() {
		return prev;
	}
	/**
	 * Function to set the previous node
	 * @param prev is the previuos node
	 */
	public void setPrevNode(DLNode<K, V> prev) {
		this.prev = prev;
	}
	/**
	 * Function to set the data 
	 * @param data is the data 
	 */
	public void setData(V data) {
		this.data = data;
	}
	/**
	 * Function to get the next node
	 * @return the next node
	 */
	public DLNode<K, V> getNextNode() {
		return next;
	}
}
