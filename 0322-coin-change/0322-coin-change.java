class Solution {
    long dp[][];
    public int coinChange(int[] coins, int amount) {
        dp=new long[coins.length][amount+1];
        for(long rows[]:dp){
            Arrays.fill(rows,-1);
        }
        long val=helper(coins,amount,0);
        if(val>=Integer.MAX_VALUE) return -1;
        return (int)val;
    }
    private long helper(int[] coins, int amount, int pos){
        if(amount==0) return 0;
        if(amount<0 || pos>=coins.length) return Integer.MAX_VALUE;
        if(dp[pos][amount]!=-1) return dp[pos][amount];
        long take=1+helper(coins,amount-coins[pos],pos);
        long ntake=helper(coins,amount,pos+1);
        return dp[pos][amount]=Math.min(take,ntake);
    }
}