import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes;

    public Graph(){
        nodes = new ArrayList<>();
    }

    public void setNodes(List<Node> nodesList) {
        this.nodes = nodesList;
    }

    public int getNodesCount() {
        return this.nodes.size();
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public void printGraph() {
        for (Node node : this.nodes) {
            node.printRelations();
        }
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }
}
