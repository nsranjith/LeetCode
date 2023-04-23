class Solution {
    int fmax=Integer.MIN_VALUE;
    int max=0;
    int temp=0;
    public int findMaxConsecutiveOnes(int[] nums) {
      for(int i=0;i<nums.length;i++){
          if(nums[i]==0){
              max=Math.max(max,temp);
              temp=0;
          }else{
              temp++;
          }
      }
        return Math.max(max,temp);
    }
}