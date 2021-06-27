package cfx20210626;

public class Offer14_2 {

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
     * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * n=2;1,1
     * n=3;1,2
     * n=4;2,2
     * n=5;2,3
     * n=6;3,3
     * n=7;2,2,3
     * n=8;2,3,3
     * n=9;3,3,3
     * n=10;3,3,2,2
     * <p>
     * 由归纳总结可以得知，n要切成3尽可能多的绳子，由于长度为1的绳子无用，当剩余1时，要与前面一段3合并，拆成2*2也就是剩余的数量
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int i=n;
        long result=1;

        while (i>4){
            i=i-3;
            result=(result*3)%1000000007;
        }

        return (int)(result*i%1000000007);
    }

    public static void main(String[] args) {
        Offer14_2 offer14_2 = new Offer14_2();
        System.out.println(offer14_2.cuttingRope(120));
    }
}
