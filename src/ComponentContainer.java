import java.util.ArrayList;
import java.util.List;

public class ComponentContainer {
    List<Component> components = new ArrayList<>();

    public ComponentContainer(Graph graph) {
        for (Node node : graph.getNodes()) {
            components.add(new Component(node));
        }
    }

    public ComponentContainer() {

    }

    public List<Component> getComponents() {
        return this.components;
    }

    public Component getComponent(int index) {
        return components.get(index);
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    public Component getComponentContains(Node node) {
        for (Component component : this.components) {
            if (component.containsNode(node)) {
                return component;
            }
        }
        return null;
    }

    public void mergeComponents(Component component1, Component component2) {
        Component result = new Component();
        result.addNodes(component1.getNodes());
        result.addNodes(component2.getNodes());
        this.components.set(components.indexOf(component1), result);
        this.components.remove(components.indexOf(component2));
    }

    public int size() {
        return this.components.size();
    }
}
