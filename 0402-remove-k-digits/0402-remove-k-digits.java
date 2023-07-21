class Solution {
    public String removeKdigits(String s, int k) {
      Stack<Character> stack=new Stack<>();
      int i=0;
      if(s.length()==1) return "0";
      for(i=0;i<s.length();i++){
            while(!stack.isEmpty() && stack.peek()>s.charAt(i) && k>0){
                stack.pop();
                k--;
            }
            stack.push(s.charAt(i)); 
        }
        String res="";
        while(!stack.isEmpty()){
            if(k==0)
                res=stack.pop()+res;
            else{
                stack.pop(); 
                k--;
            }   
        }
        if(res.length()==0) return "0";
        i=0;
        int N=res.length();
        for(i=0;i<res.length();){
            if(res.charAt(i)=='0' && N>1){
                N--;
                i++;
            }else{
                break;
            }
        }

        return res.substring(i);
    }
}