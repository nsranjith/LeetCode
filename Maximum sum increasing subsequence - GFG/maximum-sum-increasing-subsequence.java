//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int dp[][];
	public int maxSumIS(int arr[], int n)  
	{  
	    dp=new int[n][n];
	    for(int rows[]:dp){
	        Arrays.fill(rows,-1);
	    }
	    //code here
	    return helper(arr,0, -1);
	}
	
	private int helper(int arr[], int pos, int prev){
	    if(pos>=arr.length) return 0;
	    int tk=0;
	    int ntk=0;
	    if(prev!=-1 && dp[pos][prev]!=-1) return dp[pos][prev];
	    if(prev==-1 || arr[pos]>arr[prev]){
	        tk=arr[pos]+helper(arr,pos+1,pos);
	    }
	    ntk=helper(arr,pos+1,prev);
	    if(prev==-1) return Math.max(tk,ntk);
	    return dp[pos][prev]=Math.max(tk,ntk);
	}
}