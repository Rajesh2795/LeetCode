package classes;

import java.util.Arrays;

public class MatrixZeros {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1) {
            return;
        }

        int startCol = -1, startRow = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                 if (matrix[i][j] == 0) {
                     if (startCol == -1) {
                         startRow = i;
                         startCol = j;
                     }
                     matrix[i][startCol] = 0;
                     matrix[startRow][j] = 0;
                 }
            }
        }

        if (startCol == -1) {
            return;
        }

        System.out.println("StartRow: " + startRow + ", StartCol: " + startCol);
        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();

        for (int j = 0; j < matrix[0].length; j++) {
            if (j != startCol && matrix[startRow][j] == 0) {
                makeRowZero(0, matrix.length, j, matrix, startRow);
            }
            matrix[startRow][j] = 0;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (i != startRow && matrix[i][startCol] == 0) {
                makeColZero(i, 0, matrix[0].length, matrix, startCol);
            }
            matrix[i][startCol] = 0;
        }
    }

    public void makeRowZero(int fromRow, int toRow, int col,  int[][] matrix, int preserveRow) {
        for (int i = fromRow; i < toRow; i++) {
            if (i == preserveRow) {
                continue;
            } else {
                if (matrix[i][col] != 0) {
                    matrix[i][col] = 0;
                }
            }
        }
    }

    public  void makeColZero(int row, int fromCol, int toCol, int[][] matrix, int preserveCol) {
        for (int i = fromCol; i < toCol; i++) {
            if (i == preserveCol) {
                continue;
            } else {
                if (matrix[row][i] != 0) {
                    matrix[row][i] = 0;
                }
            }
        }
    }


}
