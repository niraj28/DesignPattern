package linkedlist;

public class MergeTwoSortedLists {
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }
	public static void main(String[] args) {
		MergeTwoSortedLists m = new MergeTwoSortedLists();
		
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);
		
		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);
		
		ListNode mergedHead = m.mergeTwoLists(list1, list2);
		
		// Print the merged list
		ListNode current = mergedHead;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}

}
