/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 // first, get all the nodes use BFS, and clone those nodes
 // second, clone neighbors of the above nodes
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        //get all nodes
        List<UndirectedGraphNode> nodes = getAllNodes(node);

        // clone nodes
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode oldNode : nodes) {
            map.put(oldNode, new UndirectedGraphNode(oldNode.label));
        }

        //clone neighbors
        for (UndirectedGraphNode oldNode : nodes) {
            List<UndirectedGraphNode> neighborNodes = oldNode.neighbors;
            for (UndirectedGraphNode neighbor : neighborNodes) {
                map.get(oldNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    private List<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> nodes = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.offer(node);
        nodes.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!nodes.contains(neighbor)) {
                    queue.offer(neighbor);
                    nodes.add(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode> (nodes);
    }
}
