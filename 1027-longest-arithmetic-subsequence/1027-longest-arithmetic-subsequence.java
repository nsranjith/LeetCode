class Solution {
    int n;
    int[] nums;
    int c=0;
    int[][] dp;
    int res=0;
    public int longestArithSeqLength(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        dp = new int[n+1][1002];
        for(int rows[]:dp){
            Arrays.fill(rows,-999);
        }
        return dfs(0,-501);
    }
    public int dfs(int i, int diff){
        if(i>=n){
            return 0;
        }
        if(dp[i][diff+501]!=-999) return dp[i][diff+501];
        int max=0;
        if(diff==-501){
            int take=0;
            int ntake=0;
            for(int j=i+1;j<n;j++){
                take=2+dfs(j,nums[j]-nums[i]);
                ntake=dfs(j,diff);
                max=Math.max(max,Math.max(take,ntake));
            }
        }else{
            int take=0;
            for(int j=i+1;j<n;j++){
                if(diff == (nums[j]-nums[i])){
                    take=1+dfs(j,nums[j]-nums[i]);
                    max=Math.max(max,take);
                }
            }
        }
        // if(diff<0) return max;
        return dp[i][diff+501]=max;
    }
}