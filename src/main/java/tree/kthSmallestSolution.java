package tree;

public class kthSmallestSolution {
	
	private int count = 0;
    private int answer = -1;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return answer;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null || answer != -1) return;

        dfs(node.left, k);

        count++;
        if (count == k) {
            answer = node.val;
            return;
        }

        dfs(node.right, k);
    }
    
    public static void main(String[] args) {
		kthSmallestSolution s = new kthSmallestSolution();
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		
		int k = 3;
		int result = s.kthSmallest(root, k);
		System.out.println("The " + k + "st smallest element is: " + result);
	}
}
