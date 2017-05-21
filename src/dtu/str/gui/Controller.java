package dtu.str.gui;

import dtu.str.pretreatment.Node;
import dtu.str.graph.comparator.NodeIndexComparator;
import dtu.str.summary.Summarizer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFrame;

/**
 *
 * @author tannn
 *
 * The Class Controller
 */
public class Controller {

    /**
     * The main JFrame
     */
    private MainGUI mainGUI;

    /**
     * The Visualize text tree Frame
     */
    private JFrame visualizeFrm;

    /**
     * The Summarizer
     */
    private Summarizer summarizer;

    /**
     * The graph which control drawing text tree
     */
    private final GGraph ggraph;

    /**
     * The Panel where draw text tree
     */
    private DrawingPnl drawingPnl;

    /**
     * Instantiates a new controller
     */
    public Controller() {
        ggraph = new GGraph();
        initViews();
    }

    /**
     * Initialization of views components
     */
    private void initViews() {
        mainGUI = new MainGUI();
        mainGUI.setController(this);
        

        visualizeFrm = new JFrame();
        visualizeFrm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        visualizeFrm.setTitle("Đồ thị liên kết các câu");
        visualizeFrm.setSize(1366, 768);
        visualizeFrm.setResizable(true);
        
        visualizeFrm.setLocationRelativeTo(mainGUI);
        visualizeFrm.setAlwaysOnTop(false);
        drawingPnl = new DrawingPnl(ggraph);
        visualizeFrm.add(drawingPnl);
        visualizeFrm.pack();

        mainGUI.setVisible(false);
        visualizeFrm.setVisible(false);
    }

    /**
     * start visualize JFrame
     */
    void startVisualize(int nodeNum) {
        //l
        if (isRebuil) {
            List<Node> nodes = summarizer.getNotes();
            DistributedPoint dpoints = new DistributedPoint();            
            int numPoint = mainGUI.getSldNumber().getValue();
            // lay ra so nut de ve
            if(mainGUI.isShowAllNote()){
                numPoint = nodes.size();
            }
            System.out.println("Num point: " + numPoint);
            for (int i = 0; i < nodeNum && i<nodes.size(); i++) {
                if (nodes.get(i).isMain()) {
                    dpoints.add(new Point(nodes.get(i)));
                    numPoint--;
                }
            }
//            int numPoint = (int) Math.min(nodes.size(), 1.5 * dpoints.size());
//            int numPoint = nodes.size();
            for (int i = 0; i < nodes.size() && 0 < numPoint; i++) {
                if (!nodes.get(i).isMain()) {
                    dpoints.add(new Point(nodes.get(i)));
                    numPoint--;
                }
            }
            Random rand = new Random();
            for (int i = 0; i < rand.nextInt(dpoints.size() - 1) + 1; i++) {
                int u = rand.nextInt(dpoints.size());
                int v = rand.nextInt(dpoints.size());
                if (u != v) {
                    Point tmp = dpoints.get(u);
                    dpoints.set(u, dpoints.get(v));
                    dpoints.set(v, tmp);
                }
            }

            ggraph.setDistributedPoint(dpoints);
//            isRebuil = false;
        }
        visualizeFrm.setVisible(true);
        
        drawingPnl.repaint();
    }

    /**
     * start Main JFrame
     */
    public void start() {
        mainGUI.setVisible(true);
        mainGUI.setLocationRelativeTo(null);
    }

    /**
     * true if graph is built
     */
    private boolean isRebuil = false;

    void summray(String text) {
//        summarizer = new Summarizer(text, mainGUI.getSldPercent().getValue(), mainGUI.getSldMin().getValue());
        summarizer = new Summarizer(text, mainGUI.getSldPercent().getValue(), 60);
        String result = summarizer.getSummary();
        mainGUI.showResult(result);
        isRebuil = true;
    }

    private TextRankFrm textRankFrm;
    public void showTextRankTable() {
        List<Node> nodes = summarizer.getNotes();        
        Collections.sort(nodes, new NodeIndexComparator());
        Vector<Vector<String>> data = new Vector<>();
//        int icount = 1;
        for(Node node: nodes){
            Vector<String> vrow = new Vector<>();
            vrow.add("W" + node.getIndex());
            vrow.add(node.getKey());
            vrow.add(node.getRank() + "");
            data.add(vrow);
//            icount++;
        }
        if( textRankFrm != null) {
            textRankFrm.dispose();
        }
        textRankFrm = new TextRankFrm();
        textRankFrm.insertIntoTable(data);
        textRankFrm.setVisible(true);
    }

} // end of class Controller
