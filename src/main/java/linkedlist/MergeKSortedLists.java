package linkedlist;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // add first node of each list
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }
	
	public static void main(String[] args) {
		MergeKSortedLists solution = new MergeKSortedLists();
		
		ListNode[] lists1 = {
			new ListNode(1, new ListNode(4, new ListNode(5))),
			new ListNode(1, new ListNode(3, new ListNode(4))),
			new ListNode(2, new ListNode(6))
		};
		ListNode merged1 = solution.mergeKLists(lists1);
		printList(merged1); // Output: 1->1->2->3->4->4->5->6
		
		ListNode[] lists2 = {};
		ListNode merged2 = solution.mergeKLists(lists2);
		printList(merged2); // Output: (empty)
		
		ListNode[] lists3 = {null};
		ListNode merged3 = solution.mergeKLists(lists3);
		printList(merged3); // Output: (empty)
	}

	private static void printList(ListNode merged1) {
		// TODO Auto-generated method stub
		ListNode current = merged1;	
			while (current != null) {
			System.out.print(current.val);
			if (current.next != null) {
				System.out.print("->");
			}
			current = current.next;
		}		
	}

}
