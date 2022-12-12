import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Component {
    List<Node> nodes = new ArrayList<>();
    //создать список внешних связей, в которых будут только исходящие связи для всего компонента
    int totalWeight = 0;

    public Component(Node node) {
        this.nodes.add(node);
    }

    public Component() {
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

    public Map.Entry<Node, Integer> findConnector() {
        /*
         * а если самая короткая нода не имеет связи с другими компонентами?
         * Как быть?
         * Надо вернуть другую, которая имеет связь с другой компонентой
         * Нужно как-то проверить, принадлежит ли найденная нода друним компонентам или нет
         */
        int connectorValue = Integer.MAX_VALUE;
        Map.Entry<Node, Integer> connector = this.nodes.get(0).getNearestNode();
        for (Node node : this.nodes) {
            var externalNode = node.getConnections()
                    .entrySet()
                    .stream()
                    .filter(n -> !this.containsNode(n.getKey())).min(Map.Entry.comparingByValue());
            //если все связанны ноды находятся внутри компоненты - пропускаем ноду
            if (externalNode.isEmpty()) {
                continue;
            }
            if (externalNode.get().getValue() < connectorValue) {
                connector = externalNode.get();
                connectorValue = externalNode.get().getValue();
            }
        }
        return connector;
    }

    public int getTotalWeight(){
        return this.totalWeight;
    }

    public void incrementWeight(int value) {
        this.totalWeight += value;
    }
}
