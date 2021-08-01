package cfx20210729;

import javafx.scene.AmbientLight;

public class Offer29 {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {

        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int x_max = matrix.length - 1;
        int x_min = 0;
        int y_max = matrix[0].length - 1;
        int y_min = 0;
        int[] result = new int[(x_max + 1) * (y_max + 1)];
        // i为横坐标，j为纵坐标
        int i = 0, j = 0;
        // k为结果数组的坐标
        int k = 1;
        result[0] = matrix[0][0];
        int currentCircle = 1;
        while (k < result.length) {
            if (j + 1 <= y_max && i - 1 < x_min) {
                // 可以往右边走并且不能往上走
                result[k] = matrix[i][j + 1];
                j++;
            } else if (i + 1 <= x_max && j + 1 > y_max) {
                // 可以往下走
                result[k] = matrix[i + 1][j];
                i++;
            } else if (j - 1 >= y_min && i + 1 > x_max) {
                // 可以往左走
                result[k] = matrix[i][j - 1];
                j--;
            } else if (i - 1 >= x_min && j - 1 < y_min) {
                // 可以往上走
                result[k] = matrix[i - 1][j];
                i--;
            }
            currentCircle++;
            if (currentCircle == 2 * (x_max - x_min + y_max - y_min)) {
                x_max--;
                y_max--;
                x_min++;
                y_min++;
                currentCircle = 0;
            }
            k++;
        }
        return result;
    }

    public int[] spiralOrder_1(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int[] result = new int[matrix.length * matrix[0].length];
        int x_max = matrix.length - 1;
        int x_min = 0;
        int y_max = matrix[0].length - 1;
        int y_min = 0;
        int k = 0;
        while (true) {
            // 向右走
            for (int i = y_min; i <= y_max; i++) {
                result[k++] = matrix[x_min][i];
            }
            if (++x_min > x_max) {
                break;
            }
            // 向下走
            for (int i = x_min; i <= x_max; i++) {
                result[k++] = matrix[i][y_max];
            }
            if (--y_max < y_min) {
                break;
            }
            // 向左走
            for (int i = y_max; i >= y_min; i--) {
                result[k++] = matrix[x_max][i];
            }
            if (--x_max < x_min) {
                break;
            }
            //向上走
            for (int i = x_max; i >= x_min; i--) {
                result[k++] = matrix[i][y_min];
            }
            if (++y_min > y_max) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Offer29 offer29 = new Offer29();
        int[][] nums = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] nums1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] nums2 = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] nums3 = new int[][]{
                {1, 2, 3}
        };
        int[][] nums4 = new int[][]{
                {1},
                {2},
                {3}
        };
        int[] order = offer29.spiralOrder_1(nums4);
        for (int i : order) {
            System.out.print(i + ",");
        }
    }
}
