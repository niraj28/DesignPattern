package walmart;

public class SearchMatrixTopRightTraversal {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1; // top-right

        while (row < rows && col >= 0) {

            int value = matrix[row][col];

            if (value == target) {
                return true;
            }

            if (target < value) {
                col--;   // move left
            } else {
                row++;   // move down
            }
        }

        return false;
    }

    public static void main(String[] args) {
    	SearchMatrixTopRightTraversal sm = new SearchMatrixTopRightTraversal();

        int[][] matrix = {
                {10, 20, 30, 40, 50},
                {21, 31, 41, 51, 61},
                {32, 42, 52, 62, 72},
                {43, 53, 63, 73, 83}
        };

        int target = 40;

        boolean found = sm.searchMatrix(matrix, target);

        System.out.println("Target " + target + " found: " + found);
    }
}
