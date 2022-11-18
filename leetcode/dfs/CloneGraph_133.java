package leetcode.dfs;

import java.util.*;

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

class CloneGraph_133 {
    Map<Node, Node> oldNewNodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (oldNewNodeMap.containsKey(node)) return oldNewNodeMap.get(node);
        Node tmpNode = new Node(node.val);
        oldNewNodeMap.put(node, tmpNode);
        for (Node subGraph : node.neighbors) {
            tmpNode.neighbors.add(cloneGraph(subGraph));
        }
        return tmpNode;
    }

    public Node bfs(Node node) {
        if (node == null) return null;
        Map<Node, Node> oldNewNodeMap = new HashMap<>();
        Node tmpNode = new Node(node.val);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        oldNewNodeMap.put(node, tmpNode);
        while (!queue.isEmpty()) {
            Node oldNode = queue.remove();
            for (Node neighbor : oldNode.neighbors) {
                if (oldNewNodeMap.containsKey(neighbor)){
                    oldNewNodeMap.get(oldNode).neighbors.add(oldNewNodeMap.get(neighbor));
                } else {
                    Node newNode = new Node(neighbor.val);
                    oldNewNodeMap.get(oldNode).neighbors.add(newNode);
                    oldNewNodeMap.put(neighbor, newNode);
                    queue.add(neighbor);
                }
            }
        }
        return tmpNode;
    }
}