package linkedlist;

public class LinkedListCycle {
	
	public boolean hasCycle(ListNode head) {
	       if (head == null) return false;

	        ListNode slow = head;
	        ListNode fast = head;

	        while (fast != null && fast.next != null) {
	            slow = slow.next;          // 1 step
	            fast = fast.next.next;     // 2 steps

	            if (slow == fast) {
	                return true;           // cycle detected
	            }
	        }

	        return false;                  // no cycle
	    }
	
	public static void main(String[] args) {		
		LinkedListCycle l = new LinkedListCycle();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		// Create a cycle for testing
		head.next.next.next.next = head; // Creates a cycle

		boolean hasCycle = l.hasCycle(head);
		System.out.println("Does the linked list have a cycle? " + hasCycle);

}
}
