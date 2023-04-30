class SmallestInfiniteSet {

    PriorityQueue<Integer> pq=new PriorityQueue<>();
    Set<Integer> set=new HashSet<>();
    int c=1;
    public SmallestInfiniteSet() {
    }
    
    public int popSmallest() {
        if(pq.isEmpty()){
            int ele=c;
            set.add(ele);
            c++;
            return ele;
        }
        int ele=pq.peek();
        if(ele<c){
            set.add(ele);
            pq.poll();
            return ele;
        }else if(ele==c){
            set.add(ele);
            pq.poll();
            c++;
            return ele;
        }else{
            ele=c;
            set.add(ele);
            c++;
            return ele;
        }
    }
    
    public void addBack(int num) {
        if(set.contains(num)){
            pq.add(num);
            set.remove(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */