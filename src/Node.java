import java.util.HashMap;
import java.util.Map;

public class Node {
    private Map<Node, Integer> connectedNodes = new HashMap();

    private int index;

    public Node(int index){
        this.index = index;
    }

    public void connectNodeTo(Node node, int weight) {
        this.connectedNodes.put(node, weight);
    }

    public int getIndex() {
        return index;
    }
}
