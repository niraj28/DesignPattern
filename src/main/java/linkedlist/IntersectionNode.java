package linkedlist;

public class IntersectionNode {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {

            // when A pointer ends, move it to B head
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            // when B pointer ends, move it to A head
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }

        // either intersection node or null
        return pA;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode headA = new ListNode(4);
		headA.next = new ListNode(1);
	    headA.next.next = new ListNode(8);
		headA.next.next.next = new ListNode(4);
		headA.next.next.next.next = new ListNode(5);
							
			
		ListNode headB = new ListNode(5);
		headB.next = new ListNode(6);
		headB.next.next = new ListNode(1);
		headB.next.next.next = headA.next.next; // Intersection at node with value
				
			
		
			
		IntersectionNode solution = new IntersectionNode();
		ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
		if (intersectionNode != null) {
				
			System.out.println("Intersection Node Value: " + intersectionNode.val);
		} else {
			System.out.println("No intersection.");
				
		}

	}
	

}
