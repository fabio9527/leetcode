package cfx20210708;

public class Offer45 {

    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {

        StringBuilder sum = new StringBuilder();
        if(null==nums || nums.length==0){
            return sum.toString();
        }

        if(nums.length==1){
            String.valueOf(nums[0]);
        }

        int temp;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(compareNum(nums[i],nums[j])){
                    temp = nums[j];
                    nums[j]= nums[i];
                    nums[i]=temp;
                }
            }
        }
        for(int i : nums){
            sum.append(i);
        }
        return sum.toString();
    }

    /**
     *
     * @param font 排前面的数
     * @param tail 排后面的数
     * @return 是否font排前面
     */
    private boolean compareNum(int font, int tail) {
        if(font == tail){
            return true;
        }
        char[] fontStr = String.valueOf(font).toCharArray();
        char[] tailStr = String.valueOf(tail).toCharArray();

        if(font>tail){
            return !compareByRadix(fontStr, tailStr);
        }else {
            return compareByRadix(tailStr,fontStr);
        }
    }

    /**
     *
     * @param big 较大值
     * @param small 较小值
     * @return
     */
    private boolean compareByRadix(char[] big, char[] small){
        int i = 0;
        while (i<big.length){
            if(big[i]<small[i%small.length]){
                return true;
            }else if(big[i]>small[i%small.length]){
                return false;
            }
            i++;
        }
        for(char ch : small){
            if(small[0]<ch){
                return true;
            }else if(small[0]>ch){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Offer45 offer45 = new Offer45();
        //int[] nums = new int[]{10,2};
        //int[] nums = new int[]{3,30,34,5,9};
        int[] nums = new int[]{121,12};
        System.out.println(offer45.minNumber(nums));
    }
}
