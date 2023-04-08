class Solution {
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        dp=new int[nums.length+1][nums.length+1];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return helper(nums,0,-1);
    }
    private int helper(int nums[], int pos, int prev){
        if(pos>=nums.length) return 0;
        int take=0;
        if(prev!=-1 && dp[pos][prev]!=-1) return dp[pos][prev];
        if(prev==-1 || nums[pos]>nums[prev])
        take=1+helper(nums,pos+1,pos);
        int nt=helper(nums,pos+1,prev);
        if(prev!=-1){
            return dp[pos][prev]=Math.max(take,nt);
        }
        return Math.max(take,nt);
    }
}