package dtu.str.pretreatment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Node {

    private final HashSet<Node> edgesIN = new HashSet<>();
    private final HashSet<Node> edgesOUT = new HashSet<>();

    protected String key;
    protected int index;
    protected double rank = 0.0D;    
    protected boolean isMain;    
    
    public Node(){
    
    }
    
    public Node(String key, int index) {        
        this(key, index, 1.0d, false);
    }
    
    public Node(String key, int index, double rank, boolean isMain){
        this.key = key;
        this.index = index;
        this.rank = rank;
        this.isMain = isMain;
    }
//HAM TINH COSINE
    public double similarity(Node otherNode) {
        ArrayList<String> str1Tokens = new ArrayList<>(Arrays.asList(this.key.split(" ")));
        ArrayList<String> str2Tokens = new ArrayList<>(Arrays.asList(otherNode.key.split(" ")));
        Set<String> allTokens = new HashSet<>();
        allTokens.addAll(str1Tokens);
        int termsInString1 = allTokens.size();
        Set<String> secondStringTokens = new HashSet<>();
        secondStringTokens.addAll(str2Tokens);
        int termsInString2 = secondStringTokens.size();
        allTokens.addAll(secondStringTokens);
        int commonTerms = (termsInString1 + termsInString2) - allTokens.size();
        return (float) (commonTerms) / (float) (Math.pow((float) termsInString1, 0.5f) * Math.pow((float) termsInString2, 0.5f));
    }

    public void connect(final Node that) {
        this.edgesOUT.add(that);
        this.edgesIN.add(that);
    }

    public double getRank() {
        return rank;
    }

    public String getKey() {
        return key;
    }

    public int getIndex() {
        return index;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    void setRank(double rank) {
        this.rank = rank;
    }

    double getSumWjk() {
        return this.edgesOUT.stream().mapToDouble(node -> similarity(node)).sum();        
    }

    HashSet<Node> getEdgesIN() {
        return edgesIN;
    }
}
