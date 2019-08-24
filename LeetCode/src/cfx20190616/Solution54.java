package cfx20190616;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return list;
        int row=matrix.length;
        int cloumn=matrix[0].length;
        int target=row<cloumn ? (row-1)/2:(cloumn-1)/2;
        int count=0;
        while (count<=target){
            //上
            for(int i=count;i<=cloumn-count-1;i++){
                list.add(matrix[count][i]);
            }
            //右
            for(int i=count+1;i<=row-count-1;i++){
                list.add(matrix[i][cloumn-count-1]);
            }
            if(count<cloumn-count-1 && count<row-count-1) {
                //下
                for (int i = cloumn - count - 2; i > count; i--) {
                    list.add(matrix[row - count - 1][i]);
                }
                //左
                for (int i = row - count - 1; i > count; i--) {
                    list.add(matrix[i][count]);
                }
            }
            count++;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution54 solution54=new Solution54();
//        int[][] matrix={
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };
//        int[][] matrix={
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };
//        int[][] matrix={
//                {1,2,3},
//                {4,5,6},
//                {7,8,9},
//                {10,11,12}
//        };
//        int[][] matrix={
//                {1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15}
//        };
//        int[][] matrix={
//                {1},
//                {6},
//                {11}
//        };
        int[][] matrix={
                {2,5,8},
                {4,0,-1}
        };
        System.out.print(solution54.spiralOrder(matrix));
    }
}
