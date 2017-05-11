package dtu.str.gui;

import java.awt.Graphics2D;

/**
 * 
 * @author tannn
 * 
 * The interface class Drawable describe a object which can draw on the panel
 */

public interface Drawable {
    
    /**
     * Drawing itself
     * @param g pen for drawing
     */
    void drawSelf(Graphics2D g);
    
} // end of interface Drawable
