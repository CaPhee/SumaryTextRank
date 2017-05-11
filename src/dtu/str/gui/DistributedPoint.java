package dtu.str.gui;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author tann
 * 
 * The class distributed point
 */
public class DistributedPoint extends ArrayList<Point> {

    /**
     * Translational itself 
     * @param scale factor of translational
     */
    public void scale(double scale) {
        this.forEach((my) -> {
            int nx = (int) (my.getX() * scale);
            int ny = (int) (my.getY() * scale);
            int ok = my.getSafeConnect();
            my.setPosition(nx, ny);
        });
    }

    /**
     * Movement itself
     * @param pmove vector of movement
     */
    public void move(Point pmove) {
        this.forEach((my) -> {
            int nx = (int) (my.getX() + pmove.getX());
            int ny = (int) (my.getY() + pmove.getY());
            int ok = my.getSafeConnect();
            my.setPosition(nx, ny);
        });
    }

    /**
     * Automatic generate the position of Node on the graph
     */
    public void genPosition() {
        List<Point> position = gen6(this.size());
        System.out.println("DP numb node " + this.size());

        for (int i = 0; i < position.size(); i++) {
            Point p = position.get(i);
            this.get(i).setPosition(p.getX(), p.getY());
        }

    }
    
    private static final int DIS_UNIT = 100;

    public static DistributedPoint gen6(int numNode) {
        double piece = 2.0 * Math.PI / numNode;        

        DistributedPoint dis = new DistributedPoint();
        for (int i = 0; i < numNode; i++) {
            double angle = piece * i;
            int x = -(int) (DIS_UNIT * Math.sin(angle));
            int y = -(int) (DIS_UNIT * Math.cos(angle));
            System.out.println("P " + x + " -- " + y);
            dis.add(new Point(x, y, numNode - 1));
        }
        return dis;
    }

    /*
    public static DistributedPoint gen2() {
        int[][] matrix = {
            {0, 0, 1},
            {0, 150, 1}
        };
        DistributedPoint dis = new DistributedPoint();
        for (int i = 0; i < matrix.length; i++) {
            int[] is = matrix[i];
            dis.add(new Point(is[0], is[1], is[2]));
        }
        return dis;
    }

    public static DistributedPoint gen3() {
        int[][] matrix = {
            {0, 0, 2},
            {150, -87, 2},
            {150, 87, 2},};
        DistributedPoint dis = new DistributedPoint();
        for (int i = 0; i < matrix.length; i++) {
            int[] is = matrix[i];
            dis.add(new Point(is[0], is[1], is[2]));
        }
        return dis;
    }

    public static DistributedPoint gen41() {
        int[][] matrix = {
            {0, 0, 3},
            {100, -100, 3},
            {100, 100, 3},
            {200, 0, 3}
        };
        DistributedPoint dis = new DistributedPoint();
        for (int i = 0; i < matrix.length; i++) {
            int[] is = matrix[i];
            dis.add(new Point(is[0], is[1], is[2]));
        }
        return dis;
    }

    public static DistributedPoint gen4() {
        int[][] matrix = {
            {0, 0, 3},
            {150, 0, 3},
            {0, 150, 3},
            {150, 150, 3}
        };
        DistributedPoint dis = new DistributedPoint();
        for (int i = 0; i < matrix.length; i++) {
            int[] is = matrix[i];
            dis.add(new Point(is[0], is[1], is[2]));
        }
        return dis;
    }

    public static DistributedPoint gen5() {
        int[][] matrix = {
            {0, 0, 4},
            {100, -160, 4},
            {100, 160, 4},
            {241, -100, 4},
            {241, 100, 4},};
        DistributedPoint dis = new DistributedPoint();
        for (int i = 0; i < matrix.length; i++) {
            int[] is = matrix[i];
            dis.add(new Point(is[0], is[1], is[2]));
        }
        return dis;
    }
    
     */
    
    
//    public static void main(String[] args) {
//        JFrame f = new JFrame();
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.add(new DrawingPnl(new GGraph()));
//        f.pack();
//        f.setVisible(true);
//    }
}
