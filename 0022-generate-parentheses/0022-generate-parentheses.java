class Solution {
    ArrayList<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n*2,"");
        return list;
    }
    // ()()()
    private boolean valid(String s){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if(st.isEmpty() && temp==')') return false;
            if(st.isEmpty()){
                st.push(temp);
                continue;
            }
            if(temp==')' && st.peek()==')') return false;
            if(temp==')' && st.peek()=='(') {
                st.pop();
                continue;
            }
            if(temp=='(') st.push(temp);
        }
        System.out.print(st.isEmpty());
        if(!st.isEmpty()) return false;
        return true;
    }
    private void helper(int n,String s){
        if(n==0){
            // System.out.println(valid(s));
            if(valid(s))
            list.add(s);
            return;
        }
        helper(n-1,s+"("); //take
        helper(n-1,s+")");
    }
}