///// Prototype Questions

// Least Recently Used Cache

class LRUCache extends LinkedHashMap<K, V> {
	
	LRUCache(int capacity) {
		super(capacity);
	}

}

--------

capacity?
usage?
speed constraint?
device constraints?

fast writes
fast reads
identify items in cache
knowing order of insertion in cache
fast remove

class Data {
	
}

class Node {
	
	String key;
	Data value;
	Node next;
	Node prev;

	Node(String key, Data value) {
		this.key = key;
		this.value = value;		
	}

}

class LRUCache {

	int capacity;
	HashMap<String, Node> dataMap;
	Node head;
	Node end;

	LRUCache(int capcacity) {
		this.dataMap = new HashMap<String, Node>();
		this.capacity = capacity;
	}

	public void put(String key, Data value) {
		Node node;

		if (!dataMap.containsKey(key)) {
			if (shouldRemoveEldest()) {
				dataMap.remove(end.key);
				remove(end);
			}

			dataMap.put(key, value);
			setHead(new Node(key, value));			
		} else {
			node = dataMap.get(key);
			remove(dataMap.get(key));
			setHead(node);
		}
	}

	public void get(String key) {
		if (dataMap.containsKey(key)) {
			node = dataMap.get(key);
			remove(dataMap.get(key));
			setHead(node);
			return dataMap.get(key).value;
		}
		return null;
	}

	private boolean shouldRemoveEldest() {
		return dataMap.size() > capacity;
	}

	private void setHead(Node node) {
		if (node != null) {
			node.next = head;
			if (head != null) {
				head.prev = node;
			}
		}
		head = node;

		if (end == null) {
			end = node;
		}
	}

	private void remove(Node node) {
		if (node != null) {
			if (node.pre != null) {
				node.prev.next = node.next;
				node.prev = null;
			} else {
				head = node.next;
			}

			if (node.next != null) {
				node.next.prev = node.prev;			
				node.next = null;
			} else {
				end = node.prev;
			}
		}		
	}
	
}