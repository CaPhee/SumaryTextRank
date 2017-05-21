package dtu.str.pretreatment;

import org.apache.commons.math.stat.descriptive.SummaryStatistics;

import java.util.LinkedList;
import java.util.TreeMap;

public class Graph extends TreeMap<String, Node> {

    private static final long serialVersionUID = 1L;
    private final static double TEXT_RANK_DAMPING_FACTOR = 0.85D;
    private final static double STANDARD_ERROR_THRESHOLD = 0.0001D;

    public void runTextRankOnSentences() {
        SummaryStatistics statistics = new SummaryStatistics();
        final int maxIterations = this.size();
        

        LinkedList<Node> nodes = new LinkedList<>(this.values());
// tinh rank
        for (int k = 0; k < maxIterations; k++) {
            statistics.clear();
//            nodes.stream().map(s -> s.getRank()).toAr
            double previousWSScore[] = new double[nodes.size()];
            for (int i = 0; i < previousWSScore.length; i++) {
                previousWSScore[i] = nodes.get(i).getRank();
            }
//            nodes.stream().map(s -> s.getRank());
            nodes.stream().forEach((Node sentence_i) -> {                
                double resultSumVji = sentence_i.getEdgesIN()
                        .stream()
                        .filter(node -> !node.getKey().equalsIgnoreCase(sentence_i.getKey()))
                        .map(node -> new Object() {
                            double sumWjk = node.getSumWjk();
                            double Wji = sentence_i.similarity(node);
                            double WSVj = previousWSScore[nodes.indexOf(node)];})
                        .filter(obj -> obj.WSVj != 0)
                        .mapToDouble(obj -> ((obj.Wji / obj.sumWjk) * obj.WSVj))
                        .sum();// tinh tong rank cua mot cau trong van ban
                double wsvi = (1.0 - TEXT_RANK_DAMPING_FACTOR) + TEXT_RANK_DAMPING_FACTOR * resultSumVji;
                statistics.addValue(Math.abs(sentence_i.getRank() - wsvi));
                sentence_i.setRank(wsvi);//luu gia tri rank
            });
                //tinh he so loi
            double standard_error = statistics.getStandardDeviation() / Math.sqrt((double) statistics.getN());

            if (standard_error < STANDARD_ERROR_THRESHOLD) {
                break;
            }
        }
    }

} 
