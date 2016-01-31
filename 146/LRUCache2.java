import java.util.HashMap;
import java.util.Map;
// Please rename the file before using it directly in Leetcode as the actual class name must is LRUCache
public class LRUCache2 {

    int capacity;
    Node head, tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        delete(n);
        insertHead(n);
        return n.val;
    }

    public void set(int key, int value) {
        Node n = new Node(key, value);
        if (map.containsKey(key)) {
            delete(map.remove(key));
        } else if (map.size() == capacity) {
            map.remove(tail.prev.key);
            delete(tail.prev);
        }
        insertHead(n);
        map.put(key, n);
    }

    private void delete(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void insertHead(Node n) {
        n.next = head.next;
        n.prev = head;
        head.next = n;
        n.next.prev = n;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        System.out.println(cache.get(2));
        cache.set(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
