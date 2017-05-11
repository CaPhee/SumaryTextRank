package dtu.str.summary;

import dtu.str.graph.Node;
import dtu.str.graph.comparator.NodeIndexComparator;
import dtu.str.graph.comparator.NodeRankComparator;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Pattern;

class TRSummary extends TextRank {

    private final NumberFormat formatter = new DecimalFormat("#0.0000");

    private List<Node> textRankSummary = null;

    private int getWordCount(String text) {
        String[] words = Pattern.compile("\\s+").split(text);
        return words.length;
    }
    /**
     * summary creating
     * @param fullText the raw text
     * @param minSizeInPercent the minimum percent text keeping
     * @param minLengthInWords the minimum number of text keeping
     * @return 
     */
    String createSummary(String fullText, int minSizeInPercent, int minLengthInWords) {
        int summarySize = getWordCount(fullText);
        StringBuilder summary = new StringBuilder();
        try {

            textRankSummary = useTextRankSummary(fullText);// dung graph tinh textrank

            Collections.sort(textRankSummary, new NodeRankComparator());// buoc sort de tinh theo rank

            int wordCount = 0;
            List<Node> arrNode = new ArrayList<>();// danh sach nut duoc chon theo tom tat
            for (Node node : textRankSummary) {
                arrNode.add(node);
                node.setMain(true);
                String[] words = Pattern.compile("\\s+").split(node.getKey());
                wordCount += words.length;
                int percent = (int) (wordCount * 100.0 / summarySize);
                if (percent >= minSizeInPercent && wordCount >= minLengthInWords) {// kiem tra so luong tu da du chua
                    break;
                }
            }

            similar(textRankSummary);// do do cosine

            Collections.sort(arrNode, new NodeIndexComparator());
            for (Node node : arrNode) {
                summary.append(node.getKey()).append("\n");//soat lai thu tu cau ban dau
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return summary.toString().replace("_", " ");
    }

    private void similar(List<Node> textRankSummary) {
        for (Node ni : textRankSummary) {
            StringJoiner joiner = new StringJoiner("\t");
            for (Node nj : textRankSummary) {
                joiner.add(formatter.format(ni.similarity(nj)));
            }
        }
    }

    public List<Node> getTextRankSummary() {
        return textRankSummary;
    }
}
