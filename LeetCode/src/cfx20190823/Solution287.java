package cfx20190823;

/*
* 不能更改原数组，只能用o{1}空间，时间复杂度小于o{n^2}
* */
public class Solution287 {
    /*public int findDuplicate(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min)
                min=nums[i];
        }
        return midSearch(nums,min,nums.length-2+min);
    }

    private int midSearch(int[] nums,int small,int large){
        int mid=(small+large)/2;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=mid && nums[i]>=small){
                count++;
            }
        }
        if(large==small)
            return small;
        if(count<=(large-small+2)/2){
            return midSearch(nums,mid+1,large);
        }else {
            return midSearch(nums,small,mid);
        }
    }*/

    /*
    * 由于取值在1-n之间，且数组长度等于n+1
    * 首先取出最小值，然后作为下表遍历，若不出现重复，则能遍历整个数组，若出现重复，则出现环
    * 关键是怎么知道当前下标是要被记住的，快慢指针,
    * */
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        fast=0;
        while(fast!=slow){
            slow=nums[slow];
            fast=nums[fast];
        }
        return fast;
    }


    public static void main(String[] args) {
        Solution287 solution287=new Solution287();
        int[] nums={2,5,9,6,9,3,8,9,7,1};
        System.out.print(solution287.findDuplicate(nums));
    }
}
