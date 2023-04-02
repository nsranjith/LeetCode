class Node{
    HashMap<Character,Node> map=new HashMap<>();
    boolean isEnd=false;
}
class Solution {
    HashSet<String> set=new HashSet<>();
    Node root=new Node();
    StringBuilder sb;
    public List<String> findWords(char[][] board, String[] words) {
        for(String word:words){
            buildTrie(word);
        }
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int[][] visited=new int[m][n];
                sb=new StringBuilder();
                if(root.map.containsKey(board[i][j])){
                    dfs(board,words,visited,i,j,root);
                }
            }
        }

        return new ArrayList<>(set);
    }
    private void dfs(char[][] board, String[] words, int[][] visited, int r, int c, Node curr){
        int row[]={0,0,-1,1};
        int col[]={-1,1,0,0};
        sb.append(board[r][c]);
        int n=sb.length();
        curr=curr.map.get(board[r][c]);
        if(curr.isEnd){
            set.add(sb.toString());
        }
        visited[r][c]=1;
        for(int i=0;i<4;i++){
            int nr=row[i]+r;
            int nc=col[i]+c;
            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length && visited[nr][nc]!=1 
            && curr.map.containsKey(board[nr][nc])){
                dfs(board,words,visited,nr,nc,curr);
                sb.setLength(n);
            }
        }
        visited[r][c]=0;
    }
    private void buildTrie(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            char temp=word.charAt(i);
            if(!curr.map.containsKey(temp)){
                Node newNode=new Node();
                curr.map.put(temp,newNode);
            }
            curr=curr.map.get(temp);
        }
        curr.isEnd=true;
    }
}