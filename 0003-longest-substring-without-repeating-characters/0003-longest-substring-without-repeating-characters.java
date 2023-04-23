class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int i=0;
        int j=1;
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        map.put(s.charAt(i),1);
        int max=1;
        while(j<s.length()){
            char temp=s.charAt(j);
            if(map.containsKey(temp) && map.get(temp)>0){
                while(map.get(temp)>0){
                    char t=s.charAt(i);
                    map.put(t,map.get(t)-1);
                    i++;
                }
                j++;
            }else{
                max=Math.max(j-i+1,max);
                j++;
            }
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        return max;
    }
}
