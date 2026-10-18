package linkedlist;

public class ReorderList {
	
/*	You are given the head of a singly linked-list. The list can be represented as:

		L0 → L1 → … → Ln - 1 → Ln
		Reorder the list to be on the following form:

		L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
		You may not modify the values in the list's nodes. Only nodes themselves may be changed. */
	
		public void reorderList(ListNode head) {
		if (head == null || head.next == null) return;

		// Step 1: Find the middle of the list
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Step 2: Reverse the second half
		ListNode prev = null, curr = slow, next;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		// Step 3: Merge the two halves
		ListNode first = head, second = prev;
		while (second.next != null) {
			ListNode temp1 = first.next, temp2 = second.next;
			first.next = second;
			second.next = temp1;
			first = temp1;
			second = temp2;
		}
	}
	
	public static void main(String[] args) {
		ReorderList solution = new ReorderList();
		
		ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		solution.reorderList(head1);
		printList(head1); // Output: 1->4->2->3
		
		ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		solution.reorderList(head2);
		printList(head2); // Output: 1->5->2->4->3
	}

	private static void printList(ListNode head1) {
		// TODO Auto-generated method stub
			ListNode current = head1;	
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
