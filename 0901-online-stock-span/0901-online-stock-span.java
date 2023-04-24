class Pair{
    int val;
    int count;
    Pair(int i, int j){
        this.val=i;
        this.count=j;
    }
}
class StockSpanner {
    Stack<Pair> s;
    public StockSpanner() { 
        s=new Stack<>();
    }

    public int next(int price) {
        int ans=1;
        while(!s.isEmpty() && s.peek().val<=price){
            Pair p=s.pop();
            ans+=p.count;
        }
        s.push(new Pair(price,ans));
        return ans;
    }    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */