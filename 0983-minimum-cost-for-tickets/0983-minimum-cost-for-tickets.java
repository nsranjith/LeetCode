class Solution {
    int dp[];
    public int mincostTickets(int[] days, int[] costs) {
        dp=new int[days.length];
        Arrays.fill(dp,-1);
       return helper(days,costs,0);
    }
    private int helper(int[] days, int[] costs, int pos){
        if(pos==days.length){
           return 0;
        }
        if(dp[pos]!=-1) return dp[pos];
        int day1=costs[0]+helper(days,costs,pos+1);
        int i=0;
        for(i=pos;i<days.length && days[i]<7+days[pos];i++);
        int day2=costs[1]+helper(days,costs,i);
        for(i=pos;i<days.length && days[i]<30+days[pos];i++);
        int day3=costs[2]+helper(days,costs,i);
        return dp[pos]=Math.min(day1,Math.min(day2,day3));
    }
}