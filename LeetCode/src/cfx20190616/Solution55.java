package cfx20190616;

public class Solution55 {
    public boolean canJump(int[] nums) {
        int endIndex=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if((nums[i]+i)>=endIndex){
                endIndex=i;
            }
        }
        return endIndex==0;
    }

    public static void main(String[] args) {
        Solution55 solution55=new Solution55();
//        int[] int={3,0,0,0};
//        int[] ints={3,2,1,0,4};
//        int[] ints={3,0,8,2,0,0,1};
//        int[] ints={4,2,0,0,1,1,4,4,4,0,4,0};
        int[] ints={8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
//        int[] ints={1,0,0,1,1,2,2,0,2,2};
//        int[] ints={1,2,0,3,1,1,1,0,1};
        System.out.print(solution55.canJump(ints));

    }
}
