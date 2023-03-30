class Solution {
    HashMap<String,HashMap<Integer,Boolean>> map;
    public boolean isScramble(String s1, String s2) {
        map=new HashMap<>();
        return helper(s1, s2, 0);
    }

    private boolean helper(String s1, String s2, int pos){
        if(s1.length()==1){
            if(s2.charAt(pos)==s1.charAt(0)){
                return true;
            }
            return false;
        }
        boolean result=false;
        if(map.containsKey(s1) && map.get(s1).containsKey(pos)){
            return map.get(s1).get(pos);
        }
        for(int j=1;j<s1.length();j++){
            String left=s1.substring(0,j);
            String right=s1.substring(j);
            boolean leftEval=helper(left,s2,pos) && helper(right,s2,pos+left.length());
            if(leftEval){
                result=true;
                break;
            }
            boolean rightEval=helper(right,s2,pos) && helper(left,s2,pos+right.length());
            if(rightEval){
                result=true;
                break;
            }
        }
        if(map.containsKey(s1)){
            HashMap<Integer,Boolean> m=new HashMap<>();
            m.put(pos,result);
            HashMap<Integer,Boolean> temp=map.get(s1);
            temp.put(pos,result);
        }else{
            HashMap<Integer,Boolean> m=new HashMap<>();
            m.put(pos,result);
            map.put(s1,m);
        }
        return result;
    }

}