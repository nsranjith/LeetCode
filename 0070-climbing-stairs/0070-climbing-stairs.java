class Solution {
    int cal=0;
    int dp[];
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
    private int helper(int n){
         if(n<=1){
            return 1;
        }
        if(dp[n]!=-1) return dp[n];
        int c1=helper(n-1);
        int c2=helper(n-2);
        return dp[n]=c1+c2;
    }
}