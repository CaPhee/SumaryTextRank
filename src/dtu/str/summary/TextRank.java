package dtu.str.summary;

import dtu.str.graph.Graph;
import dtu.str.graph.Node;
import dtu.str.unit.PreText;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

class TextRank {

    private Graph graph = null;

    public TextRank() {
        graph = new Graph();
    }

    List<Node> useTextRankSummary(String fullText) {

      
      String[] sentences = PreText.getSentencesVN(fullText);//tach cau
        for (int index = 0; index < sentences.length; index++) {
            String[] tokens = PreText.vnTokenList(sentences[index]);//tach tu
            StringJoiner joinerS = new StringJoiner(" ");
            //join cac cum thanh 1 cau da pre
            for (int i = 0; i < tokens.length; i++) {
                joinerS.add(tokens[i]);
            }
            System.out.println("TOKEN: " + joinerS);
            StringJoiner joiner = new StringJoiner(" ");
            for (String token : tokens) {
                joiner.add(token);
            }
            String value = joiner.toString();// cau da duoc tach tu
            Node n = graph.get(value);
            if (n == null) {
                n = new Node(value, index);
                graph.put(value, n);
            }

            Node last_node = graph.lastEntry().getValue();
            double wij = n.similarity(last_node);
            if (last_node != null && (wij > 0)) {
                n.connect(last_node);
            }
        }
        graph.runTextRankOnSentences();

        return new ArrayList<>(graph.values());
    }

}
