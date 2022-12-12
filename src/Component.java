import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Component {
    List<Node> nodes = new ArrayList<>();
    //создать список внешних связей, в которых будут только исходящие связи для всего компонента
    int totalWeight = 0;

    public Component(Node node) {
        this.nodes.add(node);
    }

    public Component() {
    }

    public Node getCurrentNode() {
        return this.nodes.get(this.nodes.size() - 1);
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public void addNodes(List<Node> nodes) {
        this.nodes.addAll(nodes);
    }

    public boolean containsNode(Node node) {
        return this.nodes.contains(node);
    }

    public Node findConnector() {
        Map.Entry<Node, Integer> connector = this.nodes.get(0).getNearestNode();
        for (Node node : this.nodes) {
            Map.Entry<Node, Integer> nearest = node.getNearestNode();
            if (!this.containsNode(nearest.getKey()) && connector.getValue() > nearest.getValue()) {
                connector = nearest;
            }
        }
        return connector.getKey();
    }
}
