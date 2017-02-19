/*
 * Chenwei Qiu
 * Project 2
 * TCSS 305
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * Frame for paint plus plus.
 * 
 * @author Chenwei Qiu
 * @version June 10, 2015
 */
public class ArtFrame {

    /** 
     * represents a frame.
     */
    private final JFrame myFrame;

    
    /** 
     * represents a myAnimationBar.
     */
    private final AnimationButtons myAnimationBar;
    
    /**
     * represents a panel.
     */
    private final ArtPanel myPanel;
    
    /**
     * represents a choice for paint.
     */
    private final ArtChoices myArtChoice;
    
    /**
     * represents a listener.
     */
    private ShapeListener myListener;
    
    /**
     * represents a ChangeListener.
     */
    private ChangeListen myChangeListener;
    /**
     * Construct the GUI.
     */
    public ArtFrame() {
        myListener = new ShapeListener();
        myChangeListener = new ChangeListen();
        myFrame = new JFrame("Paint++");
        myPanel = new ArtPanel();
        myAnimationBar = new AnimationButtons(myListener, myChangeListener);
        myArtChoice = new ArtChoices(myListener);
        // add listener to toolbar and popup
        setupMenus();
    }
    /**
     * Sets up the frame and adds menus.
     * @custom.post frame with menus visible
     */
    private void setupMenus() {
        
        myFrame.add(myAnimationBar, BorderLayout.SOUTH);
        myFrame.add(myArtChoice, BorderLayout.NORTH);
        myFrame.add(myPanel, BorderLayout.CENTER);
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    } 
    
    /**
     * class for change listener to change fps.
     * @author Chenwei Qiu
     *
     */
    private class ChangeListen implements ChangeListener {

        @Override
        public void stateChanged(final ChangeEvent theEvent) {
            final JSlider source = (JSlider) theEvent.getSource();
            int fps = 20;
            if (!source.getValueIsAdjusting()) {
                fps = (int) source.getValue();
                myAnimationBar.getMyFPSLabel().setText(Integer.toString(fps));
            }
            myPanel.getMyTimer().setDelay(1000 / fps);
        }
        
    }
    
    /**
     * class for a Action listener.
     * @author Chenwei Qiu
     *
     */
    private class ShapeListener implements ActionListener{

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            final Object source = theEvent.getSource();
            if (source == myArtChoice.getMyBrushButton()){
                myPanel.setMyShape(0);
            } else if (source == myArtChoice.getMyCircleButton()) {
                myPanel.setMyShape(3);
            } else if (source == myArtChoice.getMyRectangleButton()) {
                myPanel.setMyShape(1);
            } else if (source == myArtChoice.getMyStarButton()){
                myPanel.setMyShape(2);
            }
            
            if (source == myArtChoice.getMyStroke()) {
                final String size = JOptionPane.showInputDialog("Enter your Stroke", 5);
                if ((size != null) && (size.length() > 0)) {
                    myPanel.setMyStroke(Integer.parseInt(size));

                }
            }

            
            if (source == myArtChoice.getMyClear()){
                myPanel.getMyShapeList().getList().clear();
                myPanel.repaint();
            }    
            
            if (source == myArtChoice.getMyColor()) {
                Color color = JColorChooser.showDialog(myFrame, "Choose a color", Color.BLACK);
                if (color == null) {
                    color = Color.BLACK;
                }
                myPanel.setMyColor(color);
            }
            
            if (source == myArtChoice.getMyBackground()) {
                Color color = JColorChooser.showDialog(myFrame, "Choose a color", Color.WHITE);
                if (color == null) {
                    color = Color.WHITE;
                }
                myPanel.setBackground(color);
            }
            
            if (source == myArtChoice.getMySave()){
                final JFileChooser filePicker = new JFileChooser();
                final FileNameExtensionFilter jpg = new FileNameExtensionFilter("JPG", "JPG");
                final FileNameExtensionFilter png = new FileNameExtensionFilter("PNG", "PNG"); 
                final FileNameExtensionFilter gif = new FileNameExtensionFilter("GIF", "GIF"); 
                filePicker.addChoosableFileFilter(jpg);
                filePicker.addChoosableFileFilter(png);
                filePicker.addChoosableFileFilter(gif);
                filePicker.setAcceptAllFileFilterUsed(false);
                final int select = filePicker.showSaveDialog(null);
                if (select == JFileChooser.APPROVE_OPTION) {
                    final BufferedImage image = new BufferedImage(myPanel.getWidth(),
                                                                  myPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
                    final Graphics2D g2 = image.createGraphics();
                    myPanel.paint(g2);
                    final String name = filePicker.getSelectedFile().getAbsolutePath()
                                    + filePicker.getSelectedFile().getName();
                    final String type = filePicker.getFileFilter().getDescription();
                    System.out.println(name + "." + type);
                    try {
                        ImageIO.write(image, type, new File(name + "." + type));
                    } catch (final IOException e) {
                        e.printStackTrace();
                    }
                }
            }
                
            if (myArtChoice.getMyEraserButton().isSelected()) {
                myPanel.setEraser(true);
            } else {
                myPanel.setEraser(false);
            }
            
            if (myAnimationBar.getMyPlayButton().isSelected()) {
                myPanel.getMyTimer().start();
                myPanel.repaint();
            } else if (myAnimationBar.getMyPauseButton().isSelected()) {
                myPanel.getMyTimer().stop();                
                myPanel.repaint();
            } else if (myAnimationBar.getMyStopButton().isSelected()) {
                myPanel.getMyTimer().stop();
                myPanel.resetLocation();
                myPanel.repaint();
            } else if (source == myAnimationBar.getMyStepButton()) {
                myPanel.step();
            }
        }        
    }
}
