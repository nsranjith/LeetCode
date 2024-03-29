class Solution {
    public int maxProfit(int[] prices) {
        int p=0;
        int curr=prices[0];
        for(int i=1;i<prices.length;i++){
           p=Math.max(prices[i]-curr, p);
           curr=Math.min(curr,prices[i]); 
        }
        return p;
    }
}