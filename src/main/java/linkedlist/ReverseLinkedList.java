package linkedlist;

public class ReverseLinkedList {
	
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
      ListNode curr = head;

      while (curr != null) {
          ListNode next = curr.next; // store next
          curr.next = prev;          // reverse link
          prev = curr;               // move prev
          curr = next;               // move curr
      }

      return prev;
  }
    public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode reversedHead = r.reverseList(head);
		
		// Print the reversed list
		ListNode current = reversedHead;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

}
