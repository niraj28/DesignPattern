package walmart;

public class IntersectionInYShapedLists {
	
	 public Node intersectPoint(Node head1, Node head2) {
	        Node p1 = head1;
	        Node p2 = head2;

	        while (p1 != p2) {
	            p1 = (p1 == null) ? head2 : p1.next;
	            p2 = (p2 == null) ? head1 : p2.next;
	        }

	        return p1;
	    }
	 public static void main(String[] args) {
			IntersectionInYShapedLists solution = new IntersectionInYShapedLists();
						
			Node head1 = new Node(1);				
				head1.next = new Node(2);				
				head1.next.next = new Node(3);	
				head1.next.next.next = new Node(4);				
		        head1.next.next.next.next = new Node(5);	
									
				Node head2 = new Node(9);	
				head2.next = head1.next.next; // Intersection at node with value 3	
																							
				Node result = solution.intersectPoint(head1, head2);
				System.out.print("Output: ");
				if (result != null) {
				System.out.println(result.data); // Output: 3
				} else {
				System.out.println("No intersection");
				}
															
							
	 }

}
