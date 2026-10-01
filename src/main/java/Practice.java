

public class Practice {
	/*19. Remove Nth Node From End of List
			Solved
			Medium
			Topics
			conpanies icon
			Companies
			Hint
			Given the head of a linked list, remove the nth node from the end of the list and return its head.
			
			 
			
			Example 1:
			
			
			Input: head = [1,2,3,4,5], n = 2
			Output: [1,2,3,5]
			Example 2:
			
			Input: head = [1], n = 1
			Output: []
			Example 3:
			
			Input: head = [1,2], n = 1
			Output: [1]
			 
			
			Constraints:
			
			The number of nodes in the list is sz.
			1 <= sz <= 30
			0 <= Node.val <= 100
			1 <= n <= sz

	 * 
	 */
	
	 public ListNode removeNthFromEnd(ListNode head, int n) {
		 

		    ListNode dummy = new ListNode(0);
		    dummy.next = head;

		    ListNode slow = dummy;
		    ListNode fast = dummy;
		 
		 for(int i=0; i<=n; i++) {
			fast= fast.next; 
		 }
		 
		 while(fast!=null) {
			 slow=slow.next;
			 fast= fast.next;
		 }
		 
		 slow.next = slow.next.next;
		 
		 return  dummy.next;
	 }
	 
	 public static void main(String[] args) {
		 Practice p = new Practice();
		 
		 ListNode head = new ListNode(1);
		 head.next = new ListNode(2);
		 head.next.next = new ListNode(3);
		 head.next.next.next = new ListNode(4);
		 head.next.next.next.next = new ListNode(5);
		 
		 int n = 2;
		 
		 ListNode result = p.removeNthFromEnd(head, n);
		 
		 while(result!=null) {
			 System.out.print(result.val + " ");
			 result = result.next;
		 }
	 }
	 
	 
	
	}
