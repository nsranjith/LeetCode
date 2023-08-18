//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    int color[];
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        color=new int[n];
        return helper(graph,m,n,0);
    }
    private boolean check(boolean graph[][], int col, int n,int node){
        for(int k=0;k<n;k++){
            if(k!=node && graph[k][node] && color[k]==col){
                return false;
            }
        }
        return true;
    }
    private boolean helper(boolean graph[][], int m, int n, int node){
        if(node==n) return true;
        boolean res=false;
        for(int i=1;i<=m;i++){
            if(check(graph,i,n,node)){
               color[node]=i;
               res=res || helper(graph,m,n,node+1);
               color[node]=0;
            }
        }
        return res;
    }
}