import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Node {
    private Map<Node, Integer> connectedNodes = new HashMap<Node, Integer>();

    private int index;

    public Node(int index) {
        this.index = index;
    }

    public void connectNodeTo(Node node, int weight) {
        this.connectedNodes.put(node, weight);
    }

    public void sortRelations() {
        this.connectedNodes = connectedNodes.entrySet().stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
    }

    public int getIndex() {
        return index;
    }
}
