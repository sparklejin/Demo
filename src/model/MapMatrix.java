package model;

/**
 * This class is to record the map of one game. For example:
 * matrix =
 * {1, 1, 1, 1, 1, 1},
 * {1, 0, 0, 0, 0, 1},
 * {1, 0, 20, 12, 0, 1},
 * {1, 0, 10, 2, 0, 1},
 * {1, 1, 1, 1, 1, 1}
 * The Unit digit number cannot be changed during one game.
 * 1 represents the wall
 * 0 represents the free space
 * 2 represents the target location
 * The Then digit number can be changed during one game.
 * Ten digit 1 represents the box
 * Ten digit 2 represents the hero/player
 * So that 12 represents a box on the target location and 22 represents the player on the target location.
 */
public class MapMatrix {
    int[][] matrix;
    private final int[][] initialMatrix;


    public MapMatrix(int[][] matrix) {
        this.matrix = matrix;
        initialMatrix=copyMatrix(matrix);
    }
    private int[][] copyMatrix(int[][] a) {
        int[][] b = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[i][j] = a[i][j];
            }
        }
        return b;
    }
    public void resetMapMatrix() {
        this.matrix = copyMatrix(initialMatrix);
    }
    public int getWidth() {
        return this.matrix[0].length;
    }

    public int getHeight() {
        return this.matrix.length;
    }

    public int getId(int row, int col) {
        return matrix[row][col];
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
