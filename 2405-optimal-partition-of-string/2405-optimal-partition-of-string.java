class Solution {
    long dp[];
    HashMap<Character,Integer> map=new HashMap<>();
    public int partitionString(String s) {
        int c=0;
        for(int i=0;i<s.length();){
         if(map.containsKey(s.charAt(i))){
             map=new HashMap<>();
             c++;
         }else{
             map.put(s.charAt(i),1);
             i++;
         }   
        }
        return c+1;
    }
}