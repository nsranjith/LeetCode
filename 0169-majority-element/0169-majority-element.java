class Solution {
    public int majorityElement(int[] nums) {
       int me=0;
       int c=0;
       for(int i=0;i<nums.length;i++){
           if(c==0){
               me=nums[i];
               c++;
           }else if(nums[i]!=me){
               c--;
           }else{
               c++;
           }
       }
        return me;
    }
}