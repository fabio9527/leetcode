package cfx20210619;

public class Offer56 {

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
     * 异或，位运算相同为0，不同为1，a^0=a a^a=0 a^a^b = b a^b^c!=0 a^1+1为a的补码
     * 把两个数分到两个组，然后分别进行异或运算即可
     * 如何分组，则通过对所有数的异或结果进行分辨，取结果的二进制为1的位，由于是异或，则该两个数在该位上的值一定不同，可以进行分组
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {

        int twoNums = 0;
        for (int num : nums) {
            twoNums = twoNums ^ num;
        }
        // 二进制位分析，取值为1的位数
        int position = 1;
        while (twoNums % 2 == 0) {
            twoNums = twoNums / 2;
            ++position;
        }
        int base = (int) Math.pow(2, position - 1);
        int[] result = new int[2];
        for (int i = 0; i <= nums.length - 1; i++) {
            int left = nums[i] / base;
            if (left % 2 == 0) {
                result[0] = result[0] ^ nums[i];
            } else {
                result[1] = result[1] ^ nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 5, 2, 5, 9, 3};
        Offer56 offer56 = new Offer56();
        int[] numbers = offer56.singleNumbers(nums);
        for (int num : numbers) {
            System.out.print(num + ",");
        }
    }

}
