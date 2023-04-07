class Solution {
    int max=Integer.MIN_VALUE;
    int dp[][];
    public int maxProduct(int[] nums) {
      int pf[]=new int[nums.length];
      int sf[]=new int[nums.length];
      pf[0]=nums[0];
      for(int i=1;i<nums.length;i++){
          if(pf[i-1]==0){
            pf[i]=nums[i]*1;
            continue;
          }
          pf[i]=nums[i]*pf[i-1];
      }
      sf[nums.length-1]=nums[nums.length-1];
      for(int i=nums.length-2;i>=0;i--){
          if(sf[i+1]==0){
            sf[i]=nums[i]*1;
            continue;
          }
          sf[i]=nums[i]*sf[i+1];
      }
    //   int max=Integer.MIN_VALUE:
      for(int i=0;i<nums.length;i++){
          max=Math.max(max,Math.max(sf[i],pf[i]));
      }
      return max;
    }

}