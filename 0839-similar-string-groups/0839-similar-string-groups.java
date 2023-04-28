class Solution {
    public int numSimilarGroups(String[] strs) {
        int count=0;
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                if(swap(strs[i],strs[j])){
                    map.computeIfAbsent(i,k->new ArrayList<Integer>()).add(j);
                    map.computeIfAbsent(j,k->new ArrayList<Integer>()).add(i);
                }
            }
        }
        boolean visited[]=new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if(!visited[i]){
                dfs(i,map,visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int pos, HashMap<Integer,ArrayList<Integer>> map,boolean visited[]){
        if(!map.containsKey(pos)){
            return;
        }
        ArrayList<Integer> list=map.get(pos);
        for(int i=0;i<list.size();i++){
            int val=list.get(i);
            if(visited[val]==false){
                visited[val]=true;
                dfs(val,map,visited);
            }
        }
    }
    private boolean swap(String s1, String s2){
        int swap=0;
        for(int i=0;i<s1.length();i++){
            char one=s1.charAt(i);
            char two=s2.charAt(i);
            if(one!=two){
                 swap++;   
            }   
        }
        return swap==0 || swap==2;
    }
}