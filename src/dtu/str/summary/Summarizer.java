package dtu.str.summary;

import dtu.str.graph.Node;

import java.util.List;

public class Summarizer {

    private String rawText;
    private List<Node> notes;
    private String summary;
    
    
//    private final static int PER_KEEP_WORD = SystemInfo.getInstance().getInt("summary.per.keep.token");
//    private final static int MIN_KEEP_WORD = SystemInfo.getInstance().getInt("summary.min.keep.token");
    public Summarizer(String text, int perKeepWord, int minKeepWord) {
        this.rawText = text;

        TRSummary tr = new TRSummary();
        this.summary = tr.createSummary(text, perKeepWord, minKeepWord);
        this.notes = tr.getTextRankSummary();
    }

    public String getRawText() {
        return rawText;
    }

    public List<Node> getNotes() {
        return notes;
    }

    public String getSummary() {
        return summary;
    }
    
    
}
