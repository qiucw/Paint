/*
 * Chenwei Qiu
 * Project 2
 * TCSS 305
 */
package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * class for shape with properties.
 * 
 * @author Chenwei Qiu
 * @version June 10, 2015
 */
public class ShapewProperties {
    
    /**
     * field for the shape.
     */
    private Shape myShape;
    
    /**
     * field for Color.
     */
    private Color myColor;
    
    /**
     * field for fill or not.
     */
    private boolean myFlag;
    
    /**
     * field for the stroke.
     */
    private Stroke myStroke;

    /**
     * field for the upperleft point of the shape.
     */
    private Point myPoint1;
    
    /**
     * field for the lowerright point of the shape.    
     */
    private Point myPoint2;
    
    /**
     * field for movement when moving.
     */
    private int myMovementX;
    
    /**
     * field for movement when moving.
     */
    private int myMovementY;

    /**
     * construct a shape with all properties.
     */
    public ShapewProperties() {

        this.myShape = new Line2D.Double();
        this.myColor = Color.BLACK;
        this.myFlag = false;
        this.myStroke = new BasicStroke();
        this.myPoint1 = new Point();
        this.myPoint2 = new Point();
        myMovementX = -15;
        myMovementY = -15;
    }
    
    /**
     * @return the movementX
     */
    public int getMovementX() {
        return myMovementX;
    }

    /**
     * @param theX the movement X to set
     */
    public void setMovementX(final int theX) {
        this.myMovementX = theX;
    }

    /**
     * @return the movementY
     */
    public int getMovementY() {
        return myMovementY;
    }

    /**
     * @param theY the movement Y to set
     */
    public void setMovementY(final int theY) {
        this.myMovementY = theY;
    }

    /**
     * @return the myP1
     */
    public Point getMyP1() {
        return myPoint1;
    }

    /**
     * @param theP1 the myP1 to set
     */
    public void setMyP1(final Point theP1) {
        this.myPoint1 = theP1;
    }

    /**
     * @return the myP2
     */
    public Point getMyP2() {
        return myPoint2;
    }

    /**
     * @param theP2 the myP2 to set
     */
    public void setMyP2(final Point theP2) {
        this.myPoint2 = theP2;
    }

    /**
     * @return the myShape
     */
    public Shape getMyShape() {
        return myShape;
    }
    
    /**
     * set the location of shape.
     * @param theP the upper left point of shape
     */
    public void setLocation(final Point theP) {
        
        final Point p1 = new Point();
        p1.setLocation(theP.getX() - myShape.getBounds2D().getWidth() / 2,
                      theP.getY() - myShape.getBounds2D().getHeight() / 2);
        
        final Point p2 = new Point();
        p2.setLocation(theP.getX() + myShape.getBounds2D().getWidth() / 2,
                      theP.getY() + myShape.getBounds2D().getHeight() / 2);
        
        if (myShape.getClass().equals(Rectangle2D.Double.class)) {
            setRec(myShape, p1, p2);
        } else if (myShape.getClass().equals(Polygon.class)) {
            setStar(myShape, p1, p2);
        } else if (myShape.getClass().equals(Ellipse2D.Double.class)) {
            setCircle(myShape, p1, p2);
        }
    }
    
    /**
     * move the shape.
     * @param theX x movement
     * @param theY y movement
     */
    public void move(final double theX, final double theY) {
        final Point p1 = new Point();

        final Point p2 = new Point();
        p1.setLocation(myShape.getBounds2D().getX() + theX,
                             myShape.getBounds2D().getY() + theY);
        p2.setLocation(p1.getX() + myShape.getBounds2D().getWidth(),
                      p1.getY() + myShape.getBounds2D().getHeight());
        if (myShape.getClass().equals(Rectangle2D.Double.class)) {
            setRec(myShape, p1, p2);
        } else if (myShape.getClass().equals(Polygon.class)) {
            setStar(myShape, p1, p2);
        } else if (myShape.getClass().equals(Ellipse2D.Double.class)) {
            setCircle(myShape, p1, p2);
        }
    }

    /**
     * @param theShape the myShape to set
     * @param theP1 the upper left point of shape
     * @param theP2 the lower right point of shape
     */
    public void setRec(final Shape theShape, final Point theP1, final Point theP2) {
        this.myShape = new Rectangle2D.Double(theP1.getX(), theP1.getY(), 
                                              Math.abs(theP2.getX() - theP1.getX()), 
                                              Math.abs(theP2.getY() - theP1.getY()));
    }
    
    /**
     * create a line.
     * @param theShape the shape will be created
     * @param theP1 the upper left point of shape
     * @param theP2 the lower right point of shape
     */
    public void setLine(final Shape theShape, final Point theP1, final Point theP2) {
        this.myShape = new Line2D.Double(theP1, theP2);
    }
    
    /**
     * create a star.
     * @param theShape the shape will be created
     * @param theP1 the upper left point of shape
     * @param theP2 the lower right point of shape
     */    
    public void setStar(final Shape theShape, final Point theP1, final Point theP2) {
        final double size = Math.abs(theP2.getX() - theP1.getX());
        final int[] x = {(int) theP1.getX() + (int) size / 2, (int) theP1.getX() + (int) size / 5 * 2,
                   (int) theP1.getX(), (int) theP1.getX() + (int) size / 10 * 3,
                   (int) theP1.getX() + (int) size / 5, (int) theP1.getX() + (int) size / 2,
                   (int) theP1.getX() + (int) size / 5 * 4, (int) theP1.getX() + (int) size / 10 * 7,
                   (int) theP1.getX() + (int) size, (int) theP1.getX() + (int) size / 5 * 3,};
      
        final int[] y = {(int) theP1.getY(), (int) theP1.getY() + (int) size / 5 * 2,
                  (int) theP1.getY() + (int) size / 5 * 2, (int) theP1.getY() + (int) size / 5 * 3,
                  (int) theP1.getY() + (int) size, (int) theP1.getY() + (int) size / 4 * 3,
                  (int) theP1.getY() + (int) size, (int) theP1.getY() + (int) size / 5 * 3,
                  (int) theP1.getY() + (int) size / 5 * 2, (int) theP1.getY() + (int) size / 5 * 2};
        this.myShape = new Polygon(x, y, x.length);
    }
    
    /**
     * create a circle.
     * @param theShape the shape will be created
     * @param theP1 the upper left point of shape
     * @param theP2 the lower right point of shape
     */
    public void setCircle(final Shape theShape, final Point theP1, final Point theP2) {
        this.myShape = new Ellipse2D.Double(theP1.getX(), theP1.getY(), 
                                            Math.abs(theP2.getX() - theP1.getX()), 
                                            Math.abs(theP2.getX() - theP1.getX()));
    }

    /**
     * @return the myColor
     */
    public Color getMyColor() {
        return myColor;
    }

    /**
     * @param theColor the myColor to set
     */
    public void setMyColor(final Color theColor) {
        this.myColor = theColor;
    }

    /**
     * @return the myFlag
     */
    public boolean isMyFlag() {
        return myFlag;
    }

    /**
     * @param theFlag the myFlag to set
     */
    public void setMyFlag(final boolean theFlag) {
        this.myFlag = theFlag;
    }

    /**
     * @return the myStroke
     */
    public Stroke getMyStroke() {
        return myStroke;
    }

    /**
     * @param theStroke the myStroke to set
     */
    public void setMyStroke(final Stroke theStroke) {
        this.myStroke = theStroke;
    } 

}
    