package walmart;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofTwoLinkedLists {
	
	public Node findIntersection(Node head1, Node head2) {

        if (head1 == null || head2 == null) return null;

        // Step 1: Store elements of head2 in set
        Set<Integer> set = new HashSet<>();

        Node temp = head2;
        while (temp != null) {
            set.add(temp.data);
            temp = temp.next;
        }

        // Step 2: Traverse head1 and build result list
        Node dummy = new Node(0);
        Node tail = dummy;

        temp = head1;
        while (temp != null) {
            if (set.contains(temp.data)) {
                tail.next = new Node(temp.data);
                tail = tail.next;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
	
	public static void main(String[] args) {
			IntersectionofTwoLinkedLists solution = new IntersectionofTwoLinkedLists();
		
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);

		Node head2 = new Node(3);
		head2.next = new Node(4);
		head2.next.next = new Node(5);

		Node result = solution.findIntersection(head1, head2);
		System.out.print("Output: ");
		while (result != null) {
			System.out.print(result.data + " ");
			result = result.next;
		}	
	}

}
