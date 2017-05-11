package dtu.str.gui;

import dtu.str.unit.SystemInfo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * 
 * @author tann
 * The drawing panel
 */

public class DrawingPnl extends JPanel {

    private Drawable drawablel;

    private static int PNL_WIDTH = SystemInfo.getInstance().getInt("draw.width");
    private static int PNL_HEIGHT = SystemInfo.getInstance().getInt("draw.height");

    public DrawingPnl() {
        this(null);
    }

    public DrawingPnl(Drawable drawable) {
        this.drawablel = drawable;
        setPreferredSize(new Dimension(PNL_WIDTH, PNL_HEIGHT));

    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g = (Graphics2D) grphcs;// chuyen sang Graphic2D
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);// lam min hinh ve
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);// lam min hinh ve
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, PNL_WIDTH, PNL_HEIGHT);
        if (drawablel != null) {
            drawablel.drawSelf(g);// ve hinh
        }
    }

} // end of class DrawingPnl
