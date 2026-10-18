package linkedlist;

public class RemoveNthNodeFromEndOfList {
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
     dummy.next = head;

     ListNode fast = dummy;
     ListNode slow = dummy;

     // move fast n+1 steps ahead
     for (int i = 0; i <= n; i++) {
         fast = fast.next;
     }

     // move both until fast reaches end
     while (fast != null) {
         fast = fast.next;
         slow = slow.next;
     }

     // delete node
     slow.next = slow.next.next;

     return dummy.next;
 }
    
    public static void main(String[] args) {
		RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
		
		ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode result1 = solution.removeNthFromEnd(head1, 2);
		printList(result1); // Output: 1->2->3->5
		
		ListNode head2 = new ListNode(1);
		ListNode result2 = solution.removeNthFromEnd(head2, 1);
		printList(result2); // Output: (empty)
		
		ListNode head3 = new ListNode(1, new ListNode(2));
		ListNode result3 = solution.removeNthFromEnd(head3, 1);
		printList(result3); // Output: 1
	}

	private static void printList(ListNode result1) {
		// TODO Auto-generated method stub
		ListNode current = result1;	
			while (current != null) {
				System.out.print(current.val);
				if (current.next != null) {
					System.out.print("->");
				}
				current = current.next;
			}
			System.out.println();
	}	

}
