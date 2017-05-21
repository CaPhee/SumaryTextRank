package dtu.str.graph.comparator;

import dtu.str.pretreatment.Node;

import java.util.Comparator;


public class NodeRankComparator implements Comparator<Node> {

    @Override
    public int compare(Node node1, Node node2) {
        if (node2.getRank() > node1.getRank())
            return 1;
        else if (node2.getRank() < node1.getRank())
            return -1;
        else
            return node2.getKey().compareTo(node1.getKey());
    }
}
