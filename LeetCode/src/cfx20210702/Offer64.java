package cfx20210702;

public class Offer64 {

    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * @param n
     * @return
     */
    public int sumNums(int n) {
        int[] sum = new int[1];
        getSum(sum,n);
        return sum[0];
    }

    private boolean getSum(int[] sum, int n) {
        
        // false == 0
        sum[0] = sum[0]+n;
        return n==0 || getSum(sum,n-1);
    }

    public static void main(String[] args) {
        Offer64 offer64 = new Offer64();
        System.out.println(offer64.sumNums(3));
    }
}
