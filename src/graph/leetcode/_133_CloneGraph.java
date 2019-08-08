package graph.leetcode;

import java.util.*;

public class _133_CloneGraph {

    // 复制用hashmap
    public Node cloneGraph(Node node) {
        return helper(node, new HashMap<>());
    }

    public Node helper(Node node, HashMap<Node, Node> map) {
        List<Node> neighbors = new ArrayList<>();
        Node copy = new Node(node.val, neighbors);
        map.put(node, copy);
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                neighbors.add(helper(neighbor, map));
            } else {
                neighbors.add(map.get(neighbor));
            }
        }
        return copy;
    }

    public Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            map.get(cur).neighbors = new ArrayList<>();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
