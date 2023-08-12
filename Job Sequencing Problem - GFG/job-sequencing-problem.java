//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b)->b.profit-a.profit);
        int max=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i].deadline);
        }
        int temp[]=new int[max+1];
        int sum=0;
        int c=0;
        Arrays.fill(temp,-1);
        for(int i=0;i<arr.length;i++){
            // System.out.println(arr[i].deadline+"---");
            int t=arr[i].deadline;
            if(temp[t]==-1) temp[t]=arr[i].profit;
            else{
                while(temp[t]!=-1 && t>0){
                    t-=1;
                }
                if(t>0) temp[t]=arr[i].profit;
            }
        }
        for(int i: temp){
            if(i!=-1){
                c++;
                sum+=i;
            }
        }
        return new int[]{c,sum};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/