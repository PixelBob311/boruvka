import java.util.List;

public class Graph {
    private List<Node> nodes;

    public void setNodes(List<Node> nodesList) {
        this.nodes = nodesList;
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }
}
