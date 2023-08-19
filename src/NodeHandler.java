import java.util.List;

public class NodeHandler {
    private final List<Node> nodes;

    public NodeHandler(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void handle() {
        for (Node node : nodes) {
            if (node.validate()) {
                node.execute();
                break;
            }
        }
    }
}