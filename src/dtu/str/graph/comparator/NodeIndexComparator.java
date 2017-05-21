package dtu.str.graph.comparator;

import dtu.str.pretreatment.Node;

import java.util.Comparator;


public class NodeIndexComparator implements Comparator<Node> {

    @Override
    public int compare(Node node1, Node node2) {
        return node1.getIndex() - node2.getIndex();
    }
}
