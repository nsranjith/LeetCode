/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Node newNode=new Node(node.val);
        map.put(node.val, newNode);
        for(int i=0;i<node.neighbors.size();i++){
            int temp=node.neighbors.get(i).val;
            if(map.containsKey(temp)){
                newNode.neighbors.add(map.get(temp));
            }else{
                newNode.neighbors.add(cloneGraph(node.neighbors.get(i)));
            }
        }
        return newNode;
    }
}