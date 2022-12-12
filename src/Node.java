import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Node {
    private Map<Node, Integer> connectedNodes = new HashMap<Node, Integer>();

    private int index;
    public String name;

    public Node(int index) {
        this.index = index;
    }

    public Node(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public void connectNodeTo(Node node, int weight) {
        this.connectedNodes.put(node, weight);
    }

    public Map<Node, Integer> getConnections() {
        return this.connectedNodes;
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

    public Entry<Node, Integer> getNearestNode() {
        return this.getConnections().entrySet()
                .stream()
                .findFirst()
                .get();
    }

    public void printRelations() {
        System.out.println("Node " + index + ":");
        this.connectedNodes.entrySet().forEach(entry -> {
            System.out.println("\t connected to node № " + entry.getKey().getIndex() + " -> " + entry.getValue());
        });
    }

}
