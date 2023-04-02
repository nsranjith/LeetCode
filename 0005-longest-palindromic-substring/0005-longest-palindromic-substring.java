class Solution {
    public String longestPalindrome(String s) {
        int max=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            String s1=expand(s,i-1,i+1);
            String oddString="";
            if((i+1)<s.length() && s.charAt(i)==s.charAt(i+1)){
                oddString=expand(s,i-1,i+2);
            }
            int s1l=s1.length();
            int ol=oddString.length();
            if(s1l>max){
                max=s1l;
                ans=s1;
            }
            if(ol>max){
                max=ol;
                ans=oddString;
            }          
        }
        return ans;
    }
    private String expand(String s, int l, int r){
        while(l>=0 && r<s.length()){
            if(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }else{
                break;
            }
        }
        return s.substring(l+1,r);
    }
}