class Solution {
    int max=Integer.MIN_VALUE;
    public int tallestBillboard(int[] rods) {

        int dp[][]=new int[rods.length][5001*2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(rods,0,0,dp);
        // return max;
    }
    private int helper(int rods[], int pos, int s1,int dp[][]){
        if(pos>=rods.length){
            if(s1==0) return s1;
            return Integer.MIN_VALUE;
        }
        if(dp[pos][5000+s1]!=-1) return dp[pos][s1+5000];
        int tk=rods[pos]+helper(rods,pos+1,s1+rods[pos],dp);
        int tk2=helper(rods,pos+1,s1-rods[pos],dp);
        int skip=helper(rods,pos+1,s1,dp);
        return dp[pos][s1+5000]=Math.max(Math.max(tk,tk2),skip);
    }
}