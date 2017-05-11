package dtu.str.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author tannn
 *
 * The edge link two nodes as a ray
 */
public class Edge implements Serializable, Drawable {
    
    /**
     * The start point of edge
     */
    private Point u;
    
    /**
     * The end point of edge
     */
    private Point v;
    
    /** 
     * The weight of the connection
     */
    private double value;
    private static final DecimalFormat D_FORMAT = new DecimalFormat("##.##");

    /**
     * Instantiates a new edge
     * @param u start a ray
     * @param v end a ray
     * @param value weight of connection
     */
    public Edge(Point u, Point v, double value) {
        this.u = u;
        this.v = v;
        this.value = value;
    }

    public Point getU() {
        return u;
    }

    public void setU(Point u) {
        this.u = u;
    }

    public Point getV() {
        return v;
    }

    public void setV(Point v) {
        this.v = v;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getValueStr() {
        return D_FORMAT.format(value);
    }

    @Override
    public String toString() {
        return "Edge{" + "u=" + u + ", v=" + v + ", value=" + D_FORMAT.format(value) + '}';
    }

    public static List<Edge> buildExample(int numberNode, boolean isFullCenntect) {
        List<Edge> edges = new ArrayList<>();
        Random r = new Random();
        Set<String> setEdge = new HashSet<>();
        int numEdge = Math.abs(r.nextInt() % ((numberNode * (numberNode - 1) / 2) - 2)) + 2;
        if (isFullCenntect) {
            numEdge = numberNode * (numberNode - 1) / 2;
        }
        System.out.println("numEdge = " + numEdge);
        while (0 < numEdge) {
            int u = r.nextInt(numberNode);
            int v = r.nextInt(numberNode);
            if (v < u) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            String key = String.valueOf(u) + "--" + String.valueOf(v);
            if (!setEdge.contains(key) && u != v) {
                setEdge.add(key);
                double value = r.nextDouble() * 100;
                edges.add(new Edge(null, null, value));
                numEdge--;
            }
        }

        return edges;
    }

    @Override
    public void drawSelf(Graphics2D g) {
        int x1 = u.getX();
        int y1 = u.getY();
        int x2 = v.getX();
        int y2 = v.getY();
        g.setColor(Color.BLACK);
        g.drawLine(y1, x1, y2, x2);
        g.drawString(getValueStr(), (2 * y1 + y2) / 3, (2 * x1 + x2) / 3);
    }

} // end of class Edge
