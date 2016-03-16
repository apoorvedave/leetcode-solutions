import java.util.HashMap;

public class LRUCache {

	private int capacity;
	private Node head;
	private Node tail;
	private HashMap<Integer, Node> map = new HashMap<>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.left = null;
		head.right = tail;
		tail.left = head;
		tail.right = null;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		Node n = map.get(key);
		delete(n);
		addFirst(n);
		return n.val;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			n.val = value;
			delete(n);
			addFirst(n);
		} else {
			// put in map
			Node n = new Node(key, value);
			map.put(key, n);
			addFirst(n);
			// put in front of list
			// remove oldest entry if required
			if (map.size() > capacity) {
				Node t = tail.left;
				map.remove(t.key);
				deleteTail();
			}
		}
	}

	private void addFirst(Node n) {
		n.right = head.right;
		head.right.left = n;
		n.left = head;
		head.right = n;
	}

	private void delete(Node n) {
		n.left.right = n.right;
		n.right.left = n.left;
	}

	private void deleteTail() {
		if (map.size() != 0) {
			tail.left.left.right = tail;
			tail.left = tail.left.left;
		}
	}
}

class Node {
	int key;
	int val;
	Node left;
	Node right;

	public Node(int key, int val) {
		this.key = key;
		this.val = val;
	}
}
