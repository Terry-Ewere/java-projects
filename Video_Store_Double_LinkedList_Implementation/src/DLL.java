/**
 * Program to implement Doubly LinkedLIst data structure
 * @author 
 * @version 
 * @param <K> K Type
 * @param <V> V Type
 */

public class DLL<K extends Comparable<K>, V> {
	private DLNode<K, V> head;
	private DLNode<K, V> tail;

	/**
	 * Function to print out the values
	 */
	public void print() {
		DLNode<K, V> temp = tail;
		while (temp != null) {
			System.out.println(temp.getData() + "\n");
			temp = temp.getPrevNode();
		}
		System.out.println();
	}

	/**
	 * Function to insert a key and a data
	 * @param key is the key
	 * @param data is the data
	 */
	
	public void insert(K key, V data) {
		DLNode<K, V> newnode = new DLNode<K, V>(key, data);
		if (head == null) {
			head = newnode;
			tail = newnode;
			newnode.setNextNode(null);
			newnode.setPrevNode(null);
		} else {
			newnode.setNextNode(head);
			head.setPrevNode(newnode);
			head = newnode;
		}

	}
	
	/**
	 * Function to check if list is empty
	 * @return true if empty otherwise return false
	 */
	public boolean isEmpty() {
		
		
		return head==null;
	}
	
	/**
	 * Function to check in the Key is present in the list
	 * @param value is the key to check for
	 * @return true if found otherwise false
	 */
	public boolean contains(K value) {
		DLNode<K, V> current = head;
		while ((current != null) && (!current.getKey().equals(value))) {
			current = current.getNextNode();
		}
		return current != null;
	}
	
	/**
	 * Function to get the data associated with the key
	 * @param key is the key to search for that is associated with the data
	 * @return data associated with the key
	 */
	public V getData(K key) {
		DLNode<K, V> current = head;
		while ((current != null) && (!current.getKey().equals(key))) {
			current = current.getNextNode();
		}
		return current.getData();
	}

	private K unlink(DLNode<K, V> x) {
	
		final K element = x.getKey();
		final DLNode<K, V> next = x.getNextNode();
		final DLNode<K, V> prev = x.getPrevNode();

		if (prev == null) {
			head = next;
		} else {
			prev.setNextNode(next);
			x.setNextNode(null);
		}

		if (next == null) {
			tail = prev;
		} else {
			next.setPrevNode(prev);
		
			x.setNextNode(null);
		}

		x.setKey(null);
		
		return element;
	}
	/**
	 * Function to delete a the key and the corresponding data
	 * @param key is the key to delete
	 * @return true if it has been deleted otherwise false
	 */
	public boolean remove(K key) {
		if (key == null) {
			for (DLNode<K, V> x = head; x != null; x = x.getNextNode()) {
				if (x.getKey() == null) {
					unlink(x);
					return true;
				}
			}
		} else {
			for (DLNode<K, V> x = head; x != null; x = x.getNextNode()) {
				if (key.equals(x.getKey())) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}


}
