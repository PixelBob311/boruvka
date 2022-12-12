import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        Graph graph = Generator.generateGraph(5);
        Graph graph = testGraph();
//        graph.printGraph();
        boruvkaSeq(graph);
    }

    public static void boruvkaSeq(Graph graph) {
        ComponentContainer components = makeComponents(graph);
        while (components.size() > 1) {
            //объединяем компоненты по минимальному пути
            for (int i = 0; i < components.getComponents().size(); i++) {
                Component currentComponent = components.getComponent(i);
                Map.Entry<Node, Integer> connector = currentComponent.findConnector();
                Component nearestComponent = components.getComponentContains(connector.getKey());
                if (nearestComponent != null) {
                    currentComponent.incrementWeight(connector.getValue());
                    components.mergeComponents(currentComponent, nearestComponent);
                }
            }
        }
        int w = components.getComponent(0).getTotalWeight();
        int t = 1;
    }

    private static ComponentContainer makeComponents(Graph graph) {
        ComponentContainer components = new ComponentContainer();
        List<Node> nodes = graph.getNodes();
        Component currentComponent = new Component(nodes.get(0));
        components.addComponent(currentComponent);
        for (int i = 1; i < nodes.size(); i++) {
            Node currentNode = nodes.get(i);
            Node nearestNode = currentNode.getNearestNode().getKey();
            Component existingComponent = components.getComponentContains(nearestNode);
            if (existingComponent != null) {
                existingComponent.addNode(currentNode);
                existingComponent.incrementWeight(currentNode.getNearestNode().getValue());
            } else {
                Component anotherComponent = new Component();
                anotherComponent.addNode(currentNode);
                components.addComponent(anotherComponent);
            }
        }
        return components;
    }

    public static Graph testGraph() {
        Graph graph = new Graph();
        Node a = new Node(0, "a");
        Node b = new Node(1, "b");
        Node c = new Node(2, "c");
        Node d = new Node(3, "d");
        Node e = new Node(4, "e");
        Node f = new Node(5, "f");
        Node g = new Node(6, "g");

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);

        a.connectNodeTo(b, 1);
        b.connectNodeTo(a, 1);
        a.connectNodeTo(c, 4);
        c.connectNodeTo(a, 4);
        a.connectNodeTo(d, 9);
        d.connectNodeTo(a, 9);
        a.connectNodeTo(e, 16);
        e.connectNodeTo(a, 16);
        a.connectNodeTo(f, 25);
        f.connectNodeTo(a, 25);
        a.connectNodeTo(g, 36);
        g.connectNodeTo(a, 36);

        b.connectNodeTo(c, 20);
        c.connectNodeTo(b, 20);
        c.connectNodeTo(d, 15);
        d.connectNodeTo(c, 15);
        d.connectNodeTo(e, 3);
        e.connectNodeTo(d, 3);
        e.connectNodeTo(f, 17);
        f.connectNodeTo(e, 17);
        f.connectNodeTo(g, 26);
        g.connectNodeTo(f, 26);
        g.connectNodeTo(b, 23);
        b.connectNodeTo(g, 23);

        a.sortRelations();
        b.sortRelations();
        c.sortRelations();
        d.sortRelations();
        e.sortRelations();
        f.sortRelations();
        g.sortRelations();
        return graph;
    }
}