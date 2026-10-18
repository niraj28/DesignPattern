package walmart;

public class SearchMatrixGloballySorted {
	
	public boolean searchMatrix(int[][] matrix, int target) {

	    int rows = matrix.length;
	    int cols = matrix[0].length;

	    int left = 0;
	    int right = rows * cols - 1;

	    while (left <= right) {

	        int mid = left + (right - left) / 2;

	        int row = mid / cols;
	        int col = mid % cols;

	        int value = matrix[row][col];

	        if (value == target) {
	            return true;
	        }

	        if (value < target) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }

	    return false;
	}
	
	public static void main(String[] args) {
		SearchMatrixGloballySorted sm = new SearchMatrixGloballySorted();
		int[][] matrix = {
			    {1, 3, 5, 7},
			    {10, 11, 16, 20},
			    {23, 30, 34, 60}
			};
		
		
		int target = 40;
		
		boolean found = sm.searchMatrix(matrix, target);
		
		System.out.println("Target " + target + " found: " + found);
	}

}
