package cfx20210728;

import cfx20210727.Offer34;

import java.util.Base64;

public class Offer04 {

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target=5，返回true
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray_1(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 对列进行筛选
        int i = 0;
        int y_min = 0, y_max = matrix[0].length - 1, x_min = 0, x_max = matrix.length - 1;
        while (i < matrix[0].length) {
            if (matrix[0][i] == target) {
                return true;
            } else if (matrix[0][i] < target) {
                y_max = i;
            }
            if (matrix[matrix.length - 1][i] == target) {
                return true;
            } else if (matrix[matrix.length - 1][i] < target) {
                y_min = i + 1;
            }
            i++;
        }
        // 对行进行筛选
        int j = 0;
        while (j < matrix.length) {
            if (matrix[j][0] == target) {
                return true;
            } else if (matrix[j][0] < target) {
                x_max = j;
            }
            if (matrix[j][matrix[0].length - 1] == target) {
                return true;
            } else if (matrix[j][matrix[0].length - 1] < target) {
                x_min = j + 1;
            }
            j++;
        }

        // 对筛选值进行处理
        j = x_min;
        while (j < matrix.length && j <= x_max) {
            i = y_min;
            while (i < matrix[0].length && i <= y_max) {
                if (matrix[j][i] == target) {
                    return true;
                }
                i++;
            }
            j++;
        }
        return false;
    }

    public boolean findNumberIn2DArray_2(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 选右上角为根节点
        int i = 0, j = matrix[0].length-1;
        while (i < matrix.length && j >=0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                i++;
            }else if(matrix[i][j] > target){
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] matrix1 = new int[][]{
                {1, 4, 7, 11, 15},
        };
        int[][] matrix2 = new int[][]{
                {1, 6, 11, 16, 21},
                {2, 7, 12, 17, 22},
                {3, 8, 13, 18, 23},
                {4, 9, 14, 19, 24},
                {5, 10, 15, 20, 25}
        };
        int[][] matrix3 = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Offer04 offer04 = new Offer04();
        System.out.println(offer04.findNumberIn2DArray_2(matrix3, 17));
    }
}
