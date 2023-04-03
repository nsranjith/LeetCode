class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l=0;
        int h=people.length;
        int min=Integer.MAX_VALUE;
        Arrays.sort(people);
        return valid(0,people,limit);
    }
    private int valid(int mid,int[] people,int limit){
       int i=0;
       int j=people.length-1;
       int c=0;
       while(i<=j){
           int sum=people[i]+people[j];
           if(sum>limit){
               c++;
               j--;
           }else if(sum<=limit){
               c++;
               j--;
               i++;
           }
       }
       return c;
    }
}