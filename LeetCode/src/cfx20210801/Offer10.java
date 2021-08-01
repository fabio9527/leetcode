package cfx20210801;

public class Offer10 {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * @param n
     * @return
     */
    public int numWays(int n) {
        if (n == 0)
            return 1;
        if (n == 1) {
            return 1;
        }
        int a = 1, b = 1;
        int temp = 1;
        for (int i = 2; i <= n; i++) {
            temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }
        return temp;
    }


    public static void main(String[] args) {
        Offer10 offer10 = new Offer10();
        System.out.println(offer10.numWays(7));
    }
}
