class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(pq.size()<k){
                pq.add(m.getKey());
            }else{
                int top=map.get(pq.peek());
                if(map.get(m.getKey())>top){
                    pq.poll();
                    pq.add(m.getKey());
                }
            }
        }
        int res[]=new int[k];
        int m=0;
        while(pq.size()>0){
            res[m++]=pq.poll();
        }
        return res;
    }
}