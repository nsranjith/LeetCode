class Solution {
    public int[][] merge(int[][] intervals) {
       ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
       Arrays.sort(intervals,(a,b)->a[0]-b[0]);
       ArrayList<Integer> list=new ArrayList<>();
       list.add(intervals[0][0]);
       list.add(intervals[0][1]);

       res.add(list);

       for(int i=1;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(res.get(res.size()-1).get(1) < start){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
                res.add(temp);
            }else{
                res.get(res.size()-1).set(1,
                    Math.max(res.get(res.size()-1).get(1), end));
            } 
       }
      
       int[][] fout=new int[res.size()][2];
       for(int i=0;i<res.size();i++){
           for(int j=0;j<2;j++){
               fout[i][j]=res.get(i).get(j);
           }
       }
        return fout;
    }
}