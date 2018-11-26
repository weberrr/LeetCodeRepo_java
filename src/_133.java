import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 克隆图(Clone Graph)
 *
 * @date 2018/11/24
 */
public class _133 {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

    //DFS

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        } else if (map.containsKey(node.label)) {
            return map.get(node.label);
        } else {
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(node.label, newNode);
            for (UndirectedGraphNode subNode : node.neighbors) {
                newNode.neighbors.add(cloneGraph(subNode));
            }
            return newNode;
        }
    }
}
