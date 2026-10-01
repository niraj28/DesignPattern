package tree;

public class kthLargestSolution {
	
	 private int count = 0;
	    private int answer = -1;

	    public int kthLargest(TreeNode root, int k) {
	        reverseInorder(root, k);
	        return answer;
	    }

	    private void reverseInorder(TreeNode node, int k) {
	        if (node == null || answer != -1) return;

	        reverseInorder(node.right, k); // bigger first

	        count++;
	        if (count == k) {
	            answer = node.val;
	            return;
	        }

	        reverseInorder(node.left, k); // smaller later
	    }
	    
	    public static void main(String[] args) {
	    kthLargestSolution s = new kthLargestSolution();	
	    					
	    TreeNode root = new TreeNode(5);	
	    root.left = new TreeNode(3);
	    root.right = new TreeNode(6);
	    root.left.left = new TreeNode(2);	
	    root.left.right = new TreeNode(4);
	    															
	    int k = 3;		
	    int result = s.kthLargest(root, k);
	    System.out.println("The " + k + "rd largest element is: " + result);
	    								
	    }

}
