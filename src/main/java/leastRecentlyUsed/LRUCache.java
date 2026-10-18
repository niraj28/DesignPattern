package leastRecentlyUsed;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	/*
	 * Use 2 data structures together:

			1. HashMap
			
			Stores:
			
			key -> node
			
			This gives O(1) access to the node.
			
			2. Doubly Linked List
			
			Maintains usage order:
			
			head.next = most recently used
			tail.prev = least recently used
			
			Why doubly linked list?
			
			remove node in O(1)
			move node to front in O(1)
	 */
	
    private final int capacity;
    private final Map<Integer, Node> map;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);
            existingNode.value = value;

            remove(existingNode);
            insertAtFront(existingNode);
            return;
        }

        if (map.size() == capacity) {
            Node lruNode = tail.prev;
            remove(lruNode);
            map.remove(lruNode.key);
        }

        Node newNode = new Node(key, value);
        insertAtFront(newNode);
        map.put(key, newNode);
    }

    private void insertAtFront(Node node) {
        Node firstRealNode = head.next;

        head.next = node;
        node.prev = head;

        node.next = firstRealNode;
        firstRealNode.prev = node;
    }

    private void remove(Node node) {
        Node previousNode = node.prev;
        Node nextNode = node.next;

        previousNode.next = nextNode;
        nextNode.prev = previousNode;
    }
    
    public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		
		System.out.println(cache.get(1)); // returns 1
		
		cache.put(3, 3); // evicts key 2
		
		System.out.println(cache.get(2)); // returns -1 (not found)
		
		cache.put(4, 4); // evicts key 3
		
		System.out.println(cache.get(3)); // returns -1 (not found)
		System.out.println(cache.get(4)); // returns 4
	}

}
