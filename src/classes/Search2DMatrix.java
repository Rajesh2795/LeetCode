package classes;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0] == target;
        }

        int possibleRow = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                possibleRow = i - 1;
                break;
            }
        }

        if (possibleRow == -1) return false;

        for (int i = 0; i < matrix[possibleRow].length; i++) {
            if (matrix[possibleRow][i] == target) {
                return true;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0] == target;
        }

        int currentRow = 0;
        int currentIndex = matrix[0].length - 1;

        while (currentRow < matrix.length && currentIndex >= 0) {
            if (matrix[currentRow][currentIndex] < target) {
                currentRow++;
            } else if (matrix[currentRow][currentIndex] > target) {
                currentIndex--;
            } else {
                return true;
            }
        }

        return false;
    }
}
