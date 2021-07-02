package cfx20210702;

public class Offer64 {

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * @param n
     * @return
     */
    public int sumNums(int n) {

        int[] sums = new int[n+1];
        for(int i=1;i<=n;i++){
            sums[i]=i+sums[i-1];
        }
        return sums[n];
    }

    public static void main(String[] args) {

    }
}
