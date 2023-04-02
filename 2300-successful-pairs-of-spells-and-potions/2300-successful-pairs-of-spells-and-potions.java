class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int res[]=new int[spells.length];
        int j=0;
        for(int i:spells){
            int l=0;
            int h=potions.length-1;
            while(l<=h){
                int mid=l+(h-l)/2;
                long ans=(long)potions[mid]*(long)i;
                if(ans<success){
                    l=mid+1;
                }else{
                    h=mid-1;
                }
            }
            // System.out.println(h);
            res[j++]=potions.length-l;
        }   
        return res;
    }
}