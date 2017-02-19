/*
 * Chenwei Qiu
 * Project 2
 * TCSS 305
 */
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import model.ArtModel;
import model.ShapewProperties;

/**
 * The JPanel to paint components on.
 * 
 * @author Chenwei Qiu
 * @version June 10, 2015
 */
@SuppressWarnings("serial")
public class ArtPanel extends JPanel {
  
    /** A ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** The Dimension of the screen. */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    /** The width of the screen. */
    private static final int SCREEN_WIDTH = SCREEN_SIZE.width / 3 * 2;
    
    /** The height of the screen. */
    private static final int SCREEN_HEIGHT = SCREEN_SIZE.height / 3 * 2;
    
    /** The default size for this JPanel. */
    private static final Dimension DEFUALT_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    
    /**
     * field for is it eraser.
     */
    private boolean myEraserFlag;
    
    /**
     * field for eraser size.
     */
    private int myEraserSize = 20;

    /**
     * field for the point.
     */
    private Point myP1;
    
    /**
     * field for the point.
     */
    private Point myP2;
    
    /**
     * field the shape list.
     */
    private ArtModel myShapeList;    
    
    /**
     * field for a single shape with properties.
     */
    private ShapewProperties myShapewProperties;
    
    /**
     * field for the type of shape.
     */
    private int myShape;
    
    /**
     * field for fill the shape or not.
     */
    private boolean myFilled;
    
    /**
     * field for the color.
     */
    private Color myColor;
    
    /**
     * field for the stroke.
     */
    private Stroke myStroke;
    
    /**
     * field for pen.
     */
    private Graphics2D myPen;
    
    /**
     * field for my eraser.
     */
    private Shape myEraser;

    /**
     * field for my timer.
     */
    private Timer myTimer;
    
    /**
    * Construct this ArtPanel.
    */
    public ArtPanel() {
        super();
        setPreferredSize(DEFUALT_SIZE);
        setBackground(Color.WHITE);  
        myP1 = new Point();
        myP2 = new Point();
        myShapeList = new ArtModel();
        myStroke = new BasicStroke(1);
        myTimer = new Timer(20, new TimerListener());
        myEraser = new Rectangle2D.Double();
        final Mouser m = new Mouser();
        addMouseListener(m);
        addMouseMotionListener(m);
    }
    


    /**
     * field to set the shape to the original location.
     */
    public void resetLocation() {
        for (int i = 0; i < myShapeList.getList().size(); i++) {
            final Point p = new Point();
            p.setLocation(myShapeList.getList().get(i).getMyP1().getX()
                          + myShapeList.getList().get(i).getMyShape().getBounds().getWidth() / 2,
                          myShapeList.getList().get(i).getMyP1().getY()
                          + myShapeList.getList().get(i).getMyShape().getBounds().getHeight() / 2);
            myShapeList.getList().get(i).setLocation(p);
        }
    }
    
    /**
     * method to step to next frame.
     */
    public void step() {
        for (int i = 0; i < myShapeList.getList().size(); i++) {
            if (myShapeList.getList().get(i).getMyShape().getBounds().getY() 
                            >= getHeight() - myShapeList.getList().get(i).getMyShape().getBounds().getHeight()
                            || myShapeList.getList().get(i).getMyShape().getBounds().getY() <= 0) {
                myShapeList.getList().get(i).setMovementY(myShapeList.getList().get(i).getMovementY() *  -1);
            }
            if (myShapeList.getList().get(i).getMyShape().getBounds().getX() 
                            >= getWidth() - myShapeList.getList().get(i).getMyShape().getBounds().getWidth()
                            || myShapeList.getList().get(i).getMyShape().getBounds().getX() <= 0) {
                myShapeList.getList().get(i).setMovementX(myShapeList.getList().get(i).getMovementX() *  -1);
            }
            myShapeList.getList().get(i).move(myShapeList.getList().get(i).getMovementX(), myShapeList.getList().get(i).getMovementY());                
            repaint();
        }        
    }
    


    /** {@inheritDoc} */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics); 
        myPen = (Graphics2D) theGraphics;
        
        for (int i = 0; i < myShapeList.getList().size(); i++) {
            myPen.setColor(myShapeList.getList().get(i).getMyColor());
            if (myShapeList.getList().get(i).isMyFlag()) {
                myPen.fill(myShapeList.getList().get(i).getMyShape());                
            }
            myPen.setStroke(myShapeList.getList().get(i).getMyStroke());
            myPen.draw(myShapeList.getList().get(i).getMyShape());
        }

        if (myEraserFlag) {
            myPen.setStroke(new BasicStroke(0));
            myPen.draw(myEraser);
        }
        
        if (myShapewProperties != null) {
            myPen.draw(myShapewProperties.getMyShape());
        }
    }  

    /**
     * @return the myShapeList.getList()
     */
    public ArtModel getMyShapeList() {
        return myShapeList;
    }
 
    /**
     * @return the myTimer
     */
    public Timer getMyTimer() {
        return myTimer;
    }
    
        /**
     * @return the isEraser
     */
    public boolean isEraser() {
        return myEraserFlag;
    }
    
    /**
     * @param theEraserFlag the EraserFlag to set
     */
    public void setEraser(final boolean theEraserFlag) {
        this.myEraserFlag = theEraserFlag;
    }
    
        /**
     * @return the myStroke
     */
    public Stroke getMyStroke() {
        return myStroke;
    }
    
    /**
     * @param theStroke the Stroke to set
     */
    public void setMyStroke(final int theStroke) {
        this.myStroke = new BasicStroke(theStroke);
    }
    
     /**
     * @return the myColor
     */
    public Color getMyColor() {
        return myColor;
    }
    
    /**
     * @param theColor the Color to set
     */
    public void setMyColor(final Color theColor) {
        this.myColor = theColor;
    }
    
     /**
     * @return the myShape
     */
    public int getMyShape() {
        return myShape;
    }
    
    /**
     * @param theShape the Shape to set
     */
    public void setMyShape(final int theShape) {
        this.myShape = theShape;
    }
    
     /**
     * @return the myShapewProperties
     */
    public ShapewProperties getMyShapewProperties() {
        return myShapewProperties;
    }
    
    /**
     * @param theShapewProperties the ShapewProperties to set
     */
    public void setMyShapewProperties(final ShapewProperties theShapewProperties) {
        this.myShapewProperties = theShapewProperties;
    }
    /**
     * innner class of mouseAdapter.
     * @author qiucw
     *
     */
    private class Mouser extends MouseAdapter {
        
        /**
         * field for index of selected shape.
         */
        private int myIndex;
        
        /**
         * field for is point on a Shape.
         */
        private boolean myFlag;

        @Override
        public void mousePressed(final MouseEvent theEvent) {            
            myP1.setLocation(theEvent.getX(), theEvent.getY());
            if (myEraserFlag) {
                myEraser = new Rectangle2D.Double(myP2.getX() - myEraserSize / 2,
                                                  myP2.getY() - myEraserSize / 2,
                                                  myEraserSize, myEraserSize);  
                for (int i = 0; i < myShapeList.getList().size(); i++) {
                    if(myShapeList.getList().get(i).getMyShape().getClass().equals(Line2D.Double.class)){
                        if (myEraser.getBounds2D().intersectsLine((Line2D)myShapeList.getList().get(i).getMyShape())){
                            myShapeList.getList().remove(i);
                        }
                    }                    
                }
            } else {
                
                if (SwingUtilities.isLeftMouseButton(theEvent)) {
                    myShapewProperties = new ShapewProperties();
                    myShapewProperties.setMyColor(myColor);
                    myShapewProperties.setMyStroke(myStroke);
                    if (myFilled) {
                        myShapewProperties.setMyFlag(true);
                    } else {
                        myShapewProperties.setMyFlag(false);
                    }
                    final Point p = new Point();
                    p.setLocation(myP1);
                    myShapewProperties.setMyP1(p);
                } else if (SwingUtilities.isRightMouseButton(theEvent)) {
                    for (int i = 0; i < myShapeList.getList().size(); i++) {
                        if (myShapeList.getList().get(i).getMyShape().contains(myP1)) {
                            myIndex = i;
                            myFlag = true;
                            break;
                        }
                    }
                }                
            }
            repaint();
        }
            
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            if (myEraserFlag) {
                myEraser = new Rectangle2D.Double(myP2.getX() - myEraserSize / 2,
                                                  myP2.getY() - myEraserSize / 2, 
                                                  myEraserSize, myEraserSize);  
                for (int i = 0; i < myShapeList.getList().size(); i++) {
                    if(myShapeList.getList().get(i).getMyShape().getClass().equals(Line2D.Double.class)){
                        if (myEraser.getBounds2D().intersectsLine((Line2D) myShapeList.getList().get(i).getMyShape())){
                            myShapeList.getList().remove(i);
                        }
                    }                    
                } 
            } else {                
                if (SwingUtilities.isLeftMouseButton(theEvent)) {
                    myShapeList.getList().add(myShapewProperties);       
                    myShapewProperties = null;
                } else if (SwingUtilities.isRightMouseButton(theEvent)) {
                    myFlag = false;
                }
            }
            repaint();
        }
        
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            myP2.setLocation(theEvent.getX(), theEvent.getY());  
            if (myEraserFlag) {
                myEraser = new Rectangle2D.Double(myP2.getX() - myEraserSize / 2,
                                                  myP2.getY() - myEraserSize / 2,
                                                  myEraserSize, myEraserSize);  
                for (int i = 0; i < myShapeList.getList().size(); i++) {
                    if(myShapeList.getList().get(i).getMyShape().getClass().equals(Line2D.Double.class)){
                        if (myEraser.getBounds2D().intersectsLine((Line2D) myShapeList.getList().get(i).getMyShape())){
                            myShapeList.getList().remove(i);
                        }
                    }                    
                }
            } else {
                if (SwingUtilities.isLeftMouseButton(theEvent)) {
                    if (myShape == 0) {
                        myShapewProperties = new ShapewProperties();
                        myShapewProperties.setMyColor(myColor);
                        myShapewProperties.setMyStroke(myStroke);
                        myShapewProperties.setMyP1(myP1);
                        myShapewProperties.setMyP2(myP2);
                        myShapewProperties.setLine(myShapewProperties.getMyShape(),
                                                   myP1, myP2);
                        myShapeList.getList().add(myShapewProperties);
                        myP1.setLocation(theEvent.getX(), theEvent.getY());
                    } else if (myShape == 1) {
                        myShapewProperties.setRec(myShapewProperties.getMyShape(), myP1, myP2);
                    } else if (myShape == 2) {
                        myShapewProperties.setStar(myShapewProperties.getMyShape(),
                                                   myP1, myP2);
                    } else if (myShape == 3) {
                        myShapewProperties.setCircle(myShapewProperties.getMyShape(),
                                                     myP1, myP2);
                    }
                } else if (SwingUtilities.isRightMouseButton(theEvent) && myFlag) {
                    final Point p = new Point();
                    p.setLocation(myP2);
                    myShapeList.getList().get(myIndex).setLocation(myP2);
                }            
            }            
            repaint();
        }
        
        /**
         * action when mouse is clicked.
         * @param theEvent get event when mouse is clicked
         */
        public void mouseClicked(final MouseEvent theEvent) {
            if (SwingUtilities.isRightMouseButton(theEvent)) {
                if (theEvent.getClickCount() == 2) {
                    final Point p = new Point();
                    p.setLocation(theEvent.getX(), theEvent.getY());
                    for (int i = 0; i < myShapeList.getList().size(); i++) {
                        if (myShapeList.getList().get(i).getMyShape().contains(p)) {
                            myShapeList.getList().remove(i);
                            break;
                        }
                    }
                }
            } else if (SwingUtilities.isLeftMouseButton(theEvent)) {
                if (theEvent.getClickCount() == 2) {
                    final Point p = new Point();
                    p.setLocation(theEvent.getX(), theEvent.getY());
                    for (int i = 0; i < myShapeList.getList().size(); i++) {
                        if (myShapeList.getList().get(i).getMyShape().contains(p)) {
                            myShapeList.getList().get(i).setMyFlag(!myShapeList.getList().get(i).isMyFlag());
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * class for timer action.
     */
    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(final ActionEvent theEvent) { 
            for (int i = 0; i < myShapeList.getList().size(); i++) {
                if (myShapeList.getList().get(i).getMyShape().getBounds().getY() >= 
                                getHeight() - myShapeList.getList().get(i).getMyShape().getBounds().getHeight()
                                || myShapeList.getList().get(i).getMyShape().getBounds().getY() <= 0) {
                    myShapeList.getList().get(i).setMovementY(myShapeList.getList().get(i).getMovementY() *  -1);
                }
                if (myShapeList.getList().get(i).getMyShape().getBounds().getX() >= 
                                getWidth() - myShapeList.getList().get(i).getMyShape().getBounds().getWidth()
                                || myShapeList.getList().get(i).getMyShape().getBounds().getX() <= 0) {
                    myShapeList.getList().get(i).setMovementX(myShapeList.getList().get(i).getMovementX() *  -1);
                }
                
                if (myShapeList.getList().get(i).getMyShape().getBounds2D().getMaxY() > getHeight()){
                    myShapeList.getList().get(i).move(0, -myShapeList.getList().get(i).getMyShape().getBounds2D().getMaxY() + getHeight());
                }
                if (myShapeList.getList().get(i).getMyShape().getBounds2D().getMaxX() > getWidth()){
                    myShapeList.getList().get(i).move(0, -myShapeList.getList().get(i).getMyShape().getBounds2D().getMaxX() + getWidth());
                }
                myShapeList.getList().get(i).move(myShapeList.getList().get(i).getMovementX(), 
                                                  myShapeList.getList().get(i).getMovementY());
                repaint();
            }
        }
    }
}
