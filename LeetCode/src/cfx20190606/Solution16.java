package cfx20190606;

import java.util.Arrays;


public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int left,right;
        int temp;   //存储三数之和
        int min=nums[0]>=0 ? Integer.MAX_VALUE:Integer.MAX_VALUE+nums[0];

        for(int i=0;i<nums.length-2;i++){
            left=i+1;
            right=nums.length-1;
            while (left<right){
                temp = nums[left]+nums[right]+nums[i];
                if(temp==target)
                    return temp;
                if(Math.abs(temp-target)<Math.abs(min-target))
                    min=temp;
                else {
                    if(temp<target)
                        left++;
                    else
                        right--;
                }
            }
        }
        return min;
    }


//public int threeSumClosest(int[] nums, int target) {
//
//    Arrays.sort(nums);
//
//    int left=0;
//    int right=nums.length-1;
//    int temp;   //存储三数之和
//    int min=nums[0]>=0 ? Integer.MAX_VALUE:Integer.MAX_VALUE+nums[0];
//
//
//    while(left<right){
//        for(int i=left+1;i<=right-1;i++){
//            temp=nums[left]+nums[right]+nums[i];
//            if (Math.abs(temp - target) < Math.abs(min - target)) {
//                min=temp;
//            }
//            if(min==target)
//                return min;
//        }
//        if(temp<target)
//            left++;
//        else right--;
//    }
//    return min;
//}


    public static void main(String[] args) {
        Solution16 solution16=new Solution16();
        int[] ints={4,0,5,-5,3,3,0,-4,-5};
        System.out.println(solution16.threeSumClosest(ints,-2)); //-2

        int[] ints2={0,1,2};
        System.out.println(solution16.threeSumClosest(ints2,0)); //3

        int[] ints1={-1,2,1,-4};
        System.out.println(solution16.threeSumClosest(ints1,1));  //2

        int[] ints3={1,1,-1,-1,3};
        System.out.println(solution16.threeSumClosest(ints3,3)); //3

        int[] ints4={1,1,-1,-1,3};
        System.out.println(solution16.threeSumClosest(ints4,1)); //1

        int[] ints5={1,2,4,8,16,32,64,128};
        System.out.println(solution16.threeSumClosest(ints5,82)); //82
    }
}
