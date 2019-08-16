package graph.skills;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _127_WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> worList) {
        Graph graph = new Graph();
        for (String word : worList) {
            graph.addNode(new Node(word));
        }
        if (!worList.contains(beginWord)) {
            graph.addNode(new Node(beginWord));
            worList.add(beginWord);
        }

        for (String word : worList) {
            Node node = graph.getNode(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <=  'z' ; j++) {
                    wordUnit[i] = j;
                    String temp = new String(wordUnit);
                    if (graph.getNode(temp) != null && !node.neightbors.contains(temp) && !temp.equals(word)) {
                        node.neightbors.add(graph.getNode(temp));
                    }
                }
            }
        }
        return 0;

    }

    class Graph {
        List<Node> nodes;
        HashMap<String, Integer> map;

        public Graph() {
            this.nodes = new ArrayList<>();
            this.map = new HashMap<>();
        }

        public Node getNode(String word) {
            if (map.containsKey(word)) {
                return nodes.get(map.get(word));
            }
            return null;
        }

        public void addNode(Node node) {
            map.put(node.word, nodes.size());
            nodes.add(node);
        }
    }

    class Node {
        String word;
        List<Node> neightbors;

        public Node(String word) {
            this.word = word;
            this.neightbors = new ArrayList<>();
        }
    }
}
