/*
 * Chenwei Qiu
 * Project 2
 * TCSS 305
 */
package view;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Class for painting choice.
 * 
 * @author Chenwei Qiu
 * @version June 10, 2015
 */
@SuppressWarnings("serial")
public class ArtChoices extends JToolBar {

    /** A button group for the mutually exclusive tool bar buttons. */
    private final ButtonGroup myGroup;
    
    /**
     * rectangle button.
     */
    private JToggleButton myRectangleButton;
    
    /**
     * line button.
     */
    private JToggleButton myLineButton;
    
    /**
     * Star button.
     */
    private JToggleButton myStarButton;
    
    /**
     * circle button.
     */
    private JToggleButton myCircleButton;
    
    /**
     * eraser button.
     */
    private JToggleButton myEraser;

    /**
     * stroke button.
     */
    private JButton myStroke;
    
    /**
     * clear button.
     */
    private JButton myClear;
    
    /**
     * save button.
     */
    private JButton mySave;
    
    /**
     * background color button.
     */
    private JButton myBackground;
    
    /**
     * color button.
     */
    private JButton myColor;
    
    /**
     * Construct bar of art choice.
     * @param ShapeListener listener for buttons
     */
    public ArtChoices(ActionListener ShapeListener) {
        super("ShapeSelection");
        myGroup = new ButtonGroup();
        myRectangleButton = new JToggleButton("Rectangle",
                                              new ImageIcon("files/rectangle.jpg"));
        myLineButton = new JToggleButton("Line", new ImageIcon("files/line.png"));
        myStarButton = new JToggleButton("Star", new ImageIcon("files/star.jpg"));
        myCircleButton = new JToggleButton("Circle", new ImageIcon("files/circle.png"));
        myStroke = new JButton("Stroke", new ImageIcon("files/brush.png"));
        myClear = new JButton("Clear", new ImageIcon("files/clear.jpg"));
        myEraser = new JToggleButton("Eraser", new ImageIcon("files/Eraser.png"));
        mySave = new JButton("Save", new ImageIcon("files/save.jpg"));
        myBackground = new JButton("BackGround Color",
                                         new ImageIcon("files/background.jpg"));
        myColor = new JButton("Color", new ImageIcon("files/color.jpg"));
        addButtons();
        myLineButton.addActionListener(ShapeListener);
        myRectangleButton.addActionListener(ShapeListener);
        myStarButton.addActionListener(ShapeListener);
        myCircleButton.addActionListener(ShapeListener);
        myStroke.addActionListener(ShapeListener);
        myClear.addActionListener(ShapeListener);
        myEraser.addActionListener(ShapeListener);
        mySave.addActionListener(ShapeListener);
        myBackground.addActionListener(ShapeListener);
        myColor.addActionListener(ShapeListener);
    }
    
    /**
     * Adds buttons to a group and assigns names and tooltips to the toolbar items.
     * @custom.post buttons added to the toobar, each one with a name and a tooltip
     */
    private void addButtons() {

        myGroup.add(myLineButton);
        myGroup.add(myRectangleButton);        
        myGroup.add(myStarButton);
        myGroup.add(myCircleButton);     
        
        add(myLineButton);
        add(myRectangleButton);
        add(myStarButton);
        add(myCircleButton);
        add(myStroke);
        add(myEraser);
        add(myClear);
        add(mySave);
        add(myColor);
        add(myBackground);

    }


    /**
     * @return the myBackground
     */
    public JButton getMyBackground() {
        return myBackground;
    }

    /**
     * @return the myColor
     */
    public JButton getMyColor() {
        return myColor;
    }

    /**
     * @return the mySave
     */
    public JButton getMySave() {
        return mySave;
    }

    /**
     * @return the myEraserButton
     */
    public JToggleButton getMyEraserButton() {
        return myEraser;
    }

    /**
     * @return the myClear
     */
    public JButton getMyClear() {
        return myClear;
    }

    /**
     * @return the myStroke
     */
    public JButton getMyStroke() {
        return myStroke;
    }

    /**
     * @return the myRectangleButton
     */
    public JToggleButton getMyRectangleButton() {
        return myRectangleButton;
    }

    /**
     * @return the myBrushButton
     */
    public JToggleButton getMyBrushButton() {
        return myLineButton;
    }

    /**
     * @return the myStarButton
     */
    public JToggleButton getMyStarButton() {
        return myStarButton;
    }

    /**
     * @return the myCircleButton
     */
    public JToggleButton getMyCircleButton() {
        return myCircleButton;
    }
}
