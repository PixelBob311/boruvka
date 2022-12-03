import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    public static Graph generateGraph(int nodesCount) {
        List<Node> nodes = Generator.generateNodes(nodesCount);
        Graph newGraph = new Graph();
        newGraph.setNodes(nodes);
        return newGraph;
    }

    private static List<Node> generateNodes(int nodesCount) {
        List<Node> nodesList = new ArrayList();
        for (int i = 0; i < nodesCount; i++) {
            Node node = new Node(i);
            nodesList.add(node);
        }
        Generator.setNodesRelations(nodesList);
        return nodesList;
    }

    private static void setNodesRelations(List<Node> nodesList) {
        for (Node node : nodesList) {
            for (int i = 0; i < nodesList.size(); i++) {
                Node connectingNode = nodesList.get(i);
                if (node.getIndex() == connectingNode.getIndex()) {
                    continue;
                }
                Random rnd = new Random();
                int pathWeight = rnd.nextInt(100) + 1;
                node.connectNodeTo(connectingNode, pathWeight);
                connectingNode.connectNodeTo(node, pathWeight);
            }
        }
    }

}
