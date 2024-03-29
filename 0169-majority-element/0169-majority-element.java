class Solution {
    public int majorityElement(int[] nums) {
        int me=-1;
        int c=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]==me){
               c++;
           }else if(c==0){
               me=nums[i];
               c++;
           }else{
               c--;
           }
        }
        return me;
    }
}