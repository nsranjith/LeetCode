class Solution {
    int tc=0;
    int mod=(1000)*(1000)*(1000)+7;
    public int numberOfArrays(String s, int k) {
        int dp[]=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helper(s,k,0,dp);
    }

    private int helper(String s , int k, int pos,int dp[]){
        if(pos>=s.length()){
            return 1;
        }
        if(dp[pos]!=-1) return dp[pos];
        if(s.charAt(pos)=='0') return dp[pos]=0;
        int sum=0;
        for(int i=pos;i<s.length();i++){
            String left=s.substring(pos,i+1);
            if(left.length()<=String.valueOf(k).length() && Long.parseLong(left)<=k){
                sum=(sum+helper(s,k,i+1,dp))%mod;
            }else{
                return dp[pos]=sum;
            }
        }
       return dp[pos]=sum;
    }
}