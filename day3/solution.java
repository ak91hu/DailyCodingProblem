import java.util.*;

class Node {
    String val;
    Node left;
    Node right;

    Node(String val) {
        this.val = val;
    }

    Node(String val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public String serialize(Node root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public Node deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private Node buildTree(Queue<String> nodes) {
        String val = nodes.poll();

        if (val.equals("#")) {
            return null;
        }

        Node node = new Node(val);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node node = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));
        
        String serialized = sol.serialize(node);
        Node deserialized = sol.deserialize(serialized);
        
        System.out.println(deserialized.left.left.val.equals("left.left"));
    }
}
