package dtu.str.gui;

import dtu.str.pretreatment.Node;
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
 * Class mo ta node tren do thi 
 * bao gom position, values  
 *  
 */
public class Point extends Node implements Serializable, Drawable{   
    
    /**
     * Tọa độ X(Theo trục Ox)
     */
    private int x;
    
    /**
     * Tọa độ Y(Theo trục Oy)
     */
    private int y;
    
    /**
     * Số lượng các kết nối
     */
    private int safeConnect;    
   
    /**
     * Hàm khởi tạo không tham số
     */
    public Point() {
        this(0, 0, 0);
    }
    
    /**
     * Hàm khởi tạo có tham số tọa độ x,y
     * @param x tạo độ x
     * @param y tọa dộ y
     */
    public Point(int x, int y) {
        this(x, y, 0);
    }
     
    /**
     * Hàm khởi tạo với tham số x,y,safeConnect
     * @param x Tọa độ x 
     * @param y Tọa độ y 
     * @param safeConnect Số điểm kết nối 
     */
    public Point(int x, int y, int safeConnect) {        
        this.x = x;
        this.y = y;
        this.safeConnect = safeConnect;
    }
    
    /**
     * Hàm khởi tọa một node mới thông qua 1 node cho trước
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
