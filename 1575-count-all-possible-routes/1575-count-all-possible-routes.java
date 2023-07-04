class Solution {
    int mod=(1000)*(1000)*(1000)+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int dp[][]=new int[locations.length][fuel+1];
        for(int rows[]:dp){
            Arrays.fill(rows,-1);
        }
        return helper(locations,start,finish,fuel,dp);
    }
    private int helper(int[] locations, int start, int finish, int fuel, int dp[][]){
         int ans=0;

        if(fuel<0) return ans;

        if(dp[start][fuel]!=-1) return dp[start][fuel];

        if(start==finish) ans++;

        for(int i=0;i<locations.length;i++){
            if(start==i){
                continue;
            }
            int reqF=Math.abs(locations[start]-locations[i]);
            ans+=helper(locations,i,finish,fuel-reqF,dp);
            ans%=mod;
        }
        return dp[start][fuel]=ans;
    }
}