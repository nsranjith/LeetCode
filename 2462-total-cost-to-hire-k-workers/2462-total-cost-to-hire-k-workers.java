class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> min=new PriorityQueue<>();
        long ans=0;
        if(candidates*2>costs.length){
            for(int i=0;i<costs.length;i++){
                min.add(costs[i]);
            }
            while(k!=0 && min.size()>0){
                ans+=min.poll();
                k--;
            }
            return ans;
        }
        PriorityQueue<Integer> left=new PriorityQueue<>();
        PriorityQueue<Integer> right=new PriorityQueue<>();
        int i=0, j=0;
        for(i=0;i<candidates;i++){
             left.add(costs[i]);
         }
        i--;
        for(j=costs.length-1;j>=costs.length-candidates;j--){
             right.add(costs[j]);
         }

        j++;
        boolean flag=false;
        while(k!=0 && left.size()>0 && right.size()>0){
           int l=left.peek();
           int r=right.peek();
            if(l<=r){
                ans+=l;
                k--;
                left.poll();
                i++;
                if(i<j)
                    left.add(costs[i]);
                else{
                    flag=true;
                    break;
                }
            } else{
                ans+=r;
                k--;
                right.poll();
                j--;
                if(i<j)
                    right.add(costs[j]);
                else{
                    flag=true;
                    break;
                }
            }
        }
        while(k!=0){
            int l=Integer.MAX_VALUE;
            int r=Integer.MAX_VALUE;
            if(left.size()>0)
                l=left.peek();
            if(right.size()>0)
                r=right.peek();
            if(l<=r)
            {
               ans+=left.poll();     
            }else{
                ans+=right.poll();
            }
            k--;
        }
        return ans;
    }
}