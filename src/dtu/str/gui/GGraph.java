package dtu.str.gui;

import dtu.str.unit.SystemInfo;
import java.awt.Graphics2D;
import java.util.List;

/**
 * 
 * @author tannn
 * 
 * The graph for drawing text tree on the panel
 */
public class GGraph implements Drawable {

    /**
     * The number of node on the graph
     */
    private int numNode = 5;    // the default for example
    
    /**
     * The points on the graph
     */
    private DistributedPoint points = DistributedPoint.gen6(numNode);
    
    /**
     * The edge on the graph which is linking of points
     */
    private final List<Edge> edges = Edge.buildExample(numNode, true);
    
    /**
     * The properties
     */
    private final SystemInfo sysInfo = SystemInfo.getInstance();

    /**
     * Instantiates a new graph
     */
    public GGraph() {
        /**
         * involve for example
         */        
        points.scale(1.0f + numNode / 10.0);
        moveToCenter();
    }
    
    /**
     * re-position of points to move it in the center of panel
     */
    private void moveToCenter() {
        int minX, minY, maxX, maxY;
        minX = minY = Integer.MAX_VALUE;
        maxX = maxY = Integer.MIN_VALUE;
        for (Point p : points) {
            minX = Math.min(minX, p.getX());
            minY = Math.min(minY, p.getY());
            maxX = Math.max(maxX, p.getX());
            maxY = Math.max(maxY, p.getY());
        }
        System.out.println("Min " + minX + " " + minY);
        int dx = maxX - minX;
        int dy = maxY - minY;
        int mx = (sysInfo.getInt("draw.height") - dx) / 2 - minX * ((minX < 0) ? 1 : 0);
        int my = (sysInfo.getInt("draw.width") - dy) / 2 - minY * ((minY < 0) ? 1 : 0);
        Point pmove = new Point(mx, my);
        System.out.println(pmove.getX() + " -- " + pmove.getY());
        points.move(pmove);
    }

    public void setDistributedPoint(DistributedPoint dp) {
        clearCache();
        points = dp;
        
        numNode = points.size();
        points.genPosition();
        if( 12 < numNode){
            points.scale(sysInfo.getFloat("draw.scala") + numNode * 1.0 / 15);
        } else {
            points.scale(sysInfo.getFloat("draw.scala") + numNode * 1.0 / 10);
        }
        moveToCenter();

        recalculateEdge();
    }
    
    /**
     * clear old values for new calculation
     */
    public void clearCache() {
        points.clear();
        edges.clear();
    }

    public List<Point> getPoints() {
        return points;
    }

    /**
     * Drawing graph on the panel
     * @param g pen for drawing
     */
    @Override
    public void drawSelf(Graphics2D g) {
        
        /**
         * Drawing edges on the panel         
         */
        edges.forEach((edge) -> edge.drawSelf(g));

        points.forEach(p -> p.drawSelf(g));
    }
        
    /**
     * re-calculate edges
     * The calculation base on similar function between 2 node
     */
    private void recalculateEdge() {
        int node = points.size();
        double sim[][] = new double[node][node];
        for (int i = 0; i < node; i++) {
            Point pi = points.get(i);
            for (int j = i + 1; j < node; j++) {
                Point pj = points.get(j);
                sim[i][j] = pi.similarity(pj);
                sim[i][j] = pj.similarity(pi);
                if (sim[i][j] < sim[j][i]) {
                    edges.add(new Edge(points.get(j), points.get(i), sim[j][i]));
                } else {
                    edges.add(new Edge(points.get(i), points.get(j), sim[i][j]));
                }
            }
        }

    }

} // end of class GGraph
