/*
 * Chenwei Qiu
 * Project 2
 * TCSS 305
 */
package view;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.event.ChangeListener;

/**
 * Class for animation button.
 * 
 * @author Chenwei Qiu
 * @version June 10, 2015
 */
@SuppressWarnings("serial")
public class AnimationButtons extends JToolBar {

    /** A button group for the mutually exclusive Animation Buttons. */
    private final ButtonGroup myGroup;
    
    /**
     * play button.
     */
    private JToggleButton myPlayButton;
    
    /**
     * pause button.
     */
    private JToggleButton myPauseButton;
    
    /**
     * step button.
     */
    private JToggleButton myStepButton;
    
    /**
     * stop button.
     */
    private JToggleButton myStopButton;
    
    /**
     * slider to select the fps.
     */
    private JSlider mySlider;
    
    /**
     * label for fps.
     */
    private JLabel myFPSLabel;
    
    /**
     * field for fps.
     */
    private int myFPS;
    
    /**
     * Construct the Animation button.
     * @param theListener listener for buttons
     * @param theChangeListener listener for slider of fps
     */
    public AnimationButtons(ActionListener theListener, ChangeListener theChangeListener) {
        super("Colors");
        myGroup = new ButtonGroup();
        myPlayButton = new JToggleButton(new ImageIcon("files/play.png"));
        myPauseButton = new JToggleButton(new ImageIcon("files/pause.png"));
        myStepButton = new JToggleButton(new ImageIcon("files/step-forward.png"));
        myStopButton = new JToggleButton(new ImageIcon("files/stop.png"));
        mySlider = new JSlider(JSlider.HORIZONTAL, 10, 100, 50);
        myFPS = 50;
        myFPSLabel = new JLabel(Integer.toString(myFPS));

        mySlider.setMajorTickSpacing(10);
        mySlider.setMinorTickSpacing(1);
        mySlider.setPaintTicks(true);
        mySlider.setPaintLabels(true);
        
        mySlider.addChangeListener(theChangeListener);
        myPlayButton.addActionListener(theListener);
        myPauseButton.addActionListener(theListener);
        myStepButton.addActionListener(theListener);
        myStopButton.addActionListener(theListener);    
        addButtons();
    }
    
    /**
     * @return the myFPSLabel
     */
    public JLabel getMyFPSLabel() {
        return myFPSLabel;
    }

    /**
     * @return the myFPS
     */
    public int getMyFPS() {
        return myFPS;
    }

    /**
     * @param theFps the myFPS to set
     */
    public void setMyFPS(final int theFps) {
        this.myFPS = theFps;
    }

    /**
     * @return the myPlayButton
     */
    public JToggleButton getMyPlayButton() {
        return myPlayButton;
    }

    /**
     * @return the myPauseButton
     */
    public JToggleButton getMyPauseButton() {
        return myPauseButton;
    }

    /**
     * @return the myStepButton
     */
    public JToggleButton getMyStepButton() {
        return myStepButton;
    }
    
    /**
     * @return the myStopButton
     */
    public JToggleButton getMyStopButton() {
        return myStopButton;
    }

    /**
     * Adds buttons to a group and assigns names and tooltips to the toolbar items.
     * @custom.post buttons added to the toobar, each one with a name and a tooltip
     */
    private void addButtons() {
        
        myGroup.add(myPlayButton);
        myGroup.add(myPauseButton);
        myGroup.add(myStepButton);
        myGroup.add(myStopButton);
        
        add(myPlayButton);
        add(myPauseButton);
        add(myStepButton);
        add(myStopButton);
        add(mySlider);
        add(myFPSLabel);        
    }
}
