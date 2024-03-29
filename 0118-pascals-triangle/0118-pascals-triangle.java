class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        List<Integer> prev=new ArrayList<>();
        prev.add(1);
        list.add(prev);
        if(numRows==1) return list;
        prev=new ArrayList<>();
        prev.add(1);
        prev.add(1);
        list.add(prev);
        for(int j=2;j<numRows;j++){
            List<Integer> in=new ArrayList<>();
            in.add(1);
            for(int i=0;i<prev.size()-1;i++){
                int sum=prev.get(i)+prev.get(i+1);
                in.add(sum);
            }
            in.add(1);
            list.add(in);
            prev=in;
        }
        return list;
    }
}