class Solution {
    public String toHex(int num) {
        StringBuilder sb=new StringBuilder();
        if(num==0) return "0";
        if(num>=0){  
            while(num>0){
                int rem=num%16;
                num=num/16;
                if(rem>9)
                sb.append((char)('a'+(rem%10)));
                else
                sb.append(rem);
            }
        }else{
             long nums=(long)Math.pow(2,32)+num;
             while(nums>0){
                long rem=nums%16;
                nums=nums/16;
                if(rem>9)
                sb.append((char)('a'+(rem%10)));
                else
                sb.append(rem);
            }
        }
        return sb.reverse().toString();
    }
}