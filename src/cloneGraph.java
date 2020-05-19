import java.util.*;
public class cloneGraph {
    static HashMap<Node, Node> seen = new HashMap<>();

    public static Node cloneGraph(Node node) {

        if(seen.containsKey(node)) {
            return seen.get(node);
        }
        Node clone = new Node();
        clone.val = node.val;
        clone.neighbors = new ArrayList<Node>();
        seen.put(node, clone);
        for(Node cloneNeighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(cloneNeighbor));
        }
        return clone;
    }
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        List<Node> n1 = new ArrayList<>();
        n1.add( two);
        n1.add( four);
                List<Node> n2= new ArrayList<>();
        n1.add( one);
        n1.add( three);
                List<Node> n3 = new ArrayList<>();
        n1.add( two);
        n1.add( four);
                List<Node> n4 = new ArrayList<>();
        n1.add( one);
        n1.add( three);

        one.neighbors = n1;
        two.neighbors = n2;
        three.neighbors = n3;
        four.neighbors = n4;
        cloneGraph(one);





    }
}
