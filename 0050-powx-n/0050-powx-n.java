class Solution {
    public double myPow(double x, int n) {
        double val=helper(x,Math.abs(n));
        if(n<0){
            return 1/val;
        }
        return val;

    }
    private double helper(double x, int n){
       if(n==0) return 1;
       if(n==1) return x;
       if(x==0) return 0;
       double half=helper(x,n/2);
       if(n%2==0){
           return half*half;
       }else{
           return x*half*half;
       }
    }
}