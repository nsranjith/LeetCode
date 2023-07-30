class Solution {
    StringBuilder sb=new StringBuilder();
    public int maxLength(List<String> arr) {
        return helper(arr, 0);
    }
    private boolean contains(StringBuilder sb, String s){
        if(sContainsDup(s)) return true;
        for(int i=0;i<sb.length();i++){
            if(s.contains(sb.charAt(i)+"")) return true;
        }
        // System.out.println(s+"--");
        return false;
    }
    private boolean sContainsDup(String s){
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        if(set.size()!=s.length()) return true;
        return false;
    }
    public int helper(List<String> arr, int pos){
        if(pos>=arr.size()) return sb.length();
        int n=sb.length();
        int tk=0;
        int ntk=0;
       if(!contains(sb,arr.get(pos))){ // if valid
            sb.append(arr.get(pos));
            tk=helper(arr,pos+1);
            sb.setLength(n);
            ntk=helper(arr,pos+1);
        }else{
            return helper(arr,pos+1);
        }
        System.out.println(tk+"--"+ntk);
        return Math.max(tk,ntk);
    }
}