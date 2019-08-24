package cfx20190610;

public class Solution48 {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return;
        int temp;
        int x,y;
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix.length-i-1;j++){
                x=matrix.length-1-i;
                y=matrix.length-1-j;
                temp=matrix[i][j];
                matrix[i][j]=matrix[y][i];
                matrix[y][i]=matrix[x][y];
                matrix[x][y]=matrix[j][x];
                matrix[j][x]=temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution48 solution48=new Solution48();
        int[][] nums={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println("未排序之前数组：");
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
        solution48.rotate(nums);
        System.out.println("排序之后数组：");
        for(int i=0;i<nums.length;i++){
           for(int j=0;j<nums.length;j++){
               System.out.print(nums[i][j]+" ");
           }
           System.out.println();
        }
    }
}
