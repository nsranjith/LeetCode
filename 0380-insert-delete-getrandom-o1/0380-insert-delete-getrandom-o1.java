class RandomizedSet {
    ArrayList<Integer> list=new ArrayList<>();
    HashMap<Integer,Integer> map=new HashMap<>();
    public RandomizedSet() {
        // set=new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
       if(!map.containsKey(val)){
           return false;
       }
       int pos=map.get(val);
       for(int i=pos+1;i<list.size();i++){
           map.put(list.get(i),i-1);
       }
       map.remove(val);
       list.remove(pos);
       return true;
    }
    
    public int getRandom() {
        java.util.Random rand = new java.util.Random();
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */