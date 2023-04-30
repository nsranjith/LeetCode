class Solution {
    int dp[][][];
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int l=group.length;
        int sum=0;
        for(int i:profit){
            sum+=i;
        }
        dp=new int[100+1][l+1][n+1];
        for(int rows[][]:dp){
            for(int row[]:rows){
                Arrays.fill(row,-1);
            }
        }
        return helper(minProfit,group,profit,0,0,0,n);
    }
    private int helper(int min, int group[], int profit[],int sum, int pos,int nm,int n){
        if(pos>=group.length){
            if(sum>=min){
                return 1;
            }
            return 0;
        }
        if(dp[sum][pos][nm]!=-1) return dp[sum][pos][nm];
        int tk=0;
        if((nm+group[pos])>n){
            return dp[sum][pos][nm]=helper(min,group,profit,sum,pos+1,nm,n);
        }
        tk+=helper(min,group,profit,Math.min(min,sum+profit[pos]),pos+1,nm+group[pos],n);// cracy hack as we are only bothered about min, and this reduces the dp state that it holds
        int ntk=helper(min,group,profit,sum,pos+1,nm,n);//not take
       
        return dp[sum][pos][nm]=(tk+ntk)%1000000007;
    }
}