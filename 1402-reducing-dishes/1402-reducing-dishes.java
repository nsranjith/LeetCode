class Solution {
    int dp[][];
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        dp=new int[satisfaction.length][satisfaction.length+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(satisfaction,0,1);
    }
    
    private int helper(int[] satisfaction, int pos, int ut){
       if(pos>=satisfaction.length){
           return 0;
       }
       if(dp[pos][ut]!=-1) return dp[pos][ut];
       int take= ut*satisfaction[pos]+helper(satisfaction,pos+1,ut+1);
       int ntake=helper(satisfaction,pos+1,ut);
       return dp[pos][ut]=Math.max(take, ntake);
    }
}