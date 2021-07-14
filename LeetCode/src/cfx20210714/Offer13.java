package cfx20210714;

public class Offer13 {

    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     *
     * 思路：深度遍历DFS
     *
     * @param m
     * @param n
     * @param k
     * @return
     */

    public int movingCount(int m, int n, int k) {

        if(m==0 || n==0){
            return 0;
        }

        boolean[][] isArrived = new boolean[m][n];
        isArrived[0][0] = true;

        int[] sum = new int[1];
        sum[0] = 1;

        move(isArrived, 0, 0, k, sum);

        return sum[0];
    }

    private void move(boolean[][] isArrived, int currentX, int currentY, int k, int[] sum){
        int maxX = isArrived[0].length;
        int maxY = isArrived.length;
        if(currentX+1<maxX && !isArrived[currentY][currentX+1] && getSumByRadix(currentX+1)+getSumByRadix(currentY)<=k){
            isArrived[currentY][currentX+1] = true;
            sum[0]++;
            move(isArrived, currentX+1, currentY, k, sum);
        }
        if(currentY+1<maxY && !isArrived[currentY+1][currentX] && getSumByRadix(currentX)+getSumByRadix(currentY+1)<=k){
            isArrived[currentY+1][currentX] = true;
            sum[0]++;
            move(isArrived, currentX, currentY+1, k, sum);
        }
    }

    private int getSumByRadix(int num){
        int sum = 0;
        while (num/10>0){
            sum = sum+num%10;
            num = num/10;
        }
        sum = sum+num;
        return sum;
    }

    public static void main(String[] args) {
        Offer13 offer13 = new Offer13();
        System.out.println(offer13.movingCount(1,2,1));
    }
}
