package cfx20210626;

public class Offer14_1 {

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
     * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     *
     * 平均值的乘积最大
     *
     * @param n 绳子的长度
     * @return
     */
    public int cuttingRope(int n) {

        int result = 1;
        if(n==3) {
            return 2;
        }

        for (int m = 2; m < n / 2 + 1; m++) {
            int temp;
            if (n % m == 0) {
                temp = (int) Math.pow(n / m, m);
            } else {
                temp = (int) (Math.pow(n / m + 1, n % m) * Math.pow(n / m, m - n % m));
            }
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Offer14_1 offer14_1 = new Offer14_1();
        System.out.println(offer14_1.cuttingRope(3));
    }
}
