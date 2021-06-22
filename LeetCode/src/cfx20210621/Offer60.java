package cfx20210621;

public class Offer60 {

    /**
     * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */

    public double[] dicesProbability(int n) {

        double[] current_num = new double[6];

        // 当n=1时，初始话数组
        for (int i = 0; i < 6; i++) {
            current_num[i] = 1.0 / 6;
        }

        double[] temp_num ;

        // 当n>=2时，循环数组计算
        for (int i = 2; i <= n; i++) {
            temp_num = current_num;
            current_num = new double[5*i+1];
            for (int j = 0; j <= 5 * i; j++) {
                // 当i==j时，由于为数组复用
                int mid = getMid(0, 5 * i);
                if (j <= mid) {
                    double sum =0;
                    for(int x=j;x>=0 && x>=j-5;x--){
                        sum=sum+temp_num[x]/6;
                    }
                    current_num[j]=sum;
                } else {
                    current_num[j]=current_num[5*i-j];
                }

            }
        }
        return current_num;
    }

    public int getMid(int left, int right) {
        return (right - left) / 2 + left;
    }


    public static void main(String[] args) {
        Offer60 offer60 = new Offer60();
        double[] doubles = offer60.dicesProbability(2);
        double sum = 0;
        for(double d : doubles){
            sum=sum+d;
        }
        System.out.print(sum);
    }

}
