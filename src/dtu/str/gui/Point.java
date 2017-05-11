package dtu.str.gui;

import dtu.str.graph.Node;
import dtu.str.unit.SystemInfo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * 
 * @author tannn
 * 
 * The class Point is the node on graph
 * It includes position, values  
 *  
 */
public class Point extends Node implements Serializable, Drawable{   
    
    /**
     * X coordinate (flow Ox ray)
     */
    private int x;
    
    /**
     * Y coordinate (flow Oy ray)
     */
    private int y;
    
    /**
     * The number of connection which do not cross each other
     */
    private int safeConnect;    
   
    /**
     * Instantiates a new point without parameter
     */
    public Point() {
        this(0, 0, 0);
    }
    
    /**
     * Instantiates a new point 
     * @param x coordinate 
     * @param y coordinate 
     */
    public Point(int x, int y) {
        this(x, y, 0);
    }
     
    /**
     * Instantiates a new point
     * @param x coordinate 
     * @param y coordinate 
     * @param safeConnect number of safe connection
     */
    public Point(int x, int y, int safeConnect) {        
        this.x = x;
        this.y = y;
        this.safeConnect = safeConnect;
    }
    
    /**
     * Instantiates a new point via crawl other node
     * @param n node
     */
    public Point(Node n){                
        super(n.getKey(), n.getIndex(), n.getRank(), n.isMain());
//        System.out.println("Clone:" + n.getIndex() + " " + n.getRank() + " " + n.isMain());
    }
    

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getSafeConnect() {
        return safeConnect;
    }

    public void setSafeConnect(int safeConnect) {
        this.safeConnect = safeConnect;
    }

    public String getName() {
        return "W" + String.valueOf(index);
    }   
   

    public void setRank(double rank) {
        this.rank = rank;
    }
    
    private static final DecimalFormat D_FORMAT = new DecimalFormat("##.##");
    public String getRankStr(){
        return D_FORMAT.format(rank);
    }
    
    /**
     * Loading configuration from a external property file
     */
    private final SystemInfo sysInfo = SystemInfo.getInstance();
    
    /**
     * the drawing itself in panel
     * @param g pen for drawing
     */
    @Override
    public void drawSelf(Graphics2D g){                
        if ( isMain){
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.YELLOW);
        }
        int radius = sysInfo.getInt("draw.radius");
        int stroke = sysInfo.getInt("draw.stroke");
        g.fillOval(y - radius, x - radius, 2 * radius, 2 * radius);
        g.setStroke(new BasicStroke(stroke));
        g.setColor(Color.BLACK);
        g.drawOval(y - radius, x - radius, 2 * radius , 2 * radius);  
        g.setFont(new Font("Avial", Font.BOLD, radius / 2));
        String name = getName();
        g.drawString(name, (int)(y - radius / 2.0f - 1.15f * name.length()), x + radius / 6.0f);
        g.setColor(Color.BLUE);
        g.drawString(getRankStr(), y + radius/2, x - radius);
    }
    

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
    
}
