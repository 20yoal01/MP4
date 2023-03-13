package MP4;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import MP4.ModeState.*;
import MP4.ShapeContainer.ShapeMode;

public class ShapeApp extends JFrame
  {
  private static final long serialVersionUID = 1L;
  private ShapeContainer shapeContainer = new ShapeContainer();
  public ShapeApp()
    {
    createMenue();
    this.add(shapeContainer);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400,400);
    this.setVisible(true);
    }
  
  public void createMenue()
    {
    JMenu menu = new JMenu("Modes");
    createMenuItem(menu, "Insert", e -> shapeContainer.changeModeState(new InsertMode()));
    createMenuItem(menu, "Move", e -> shapeContainer.changeModeState(new MoveMode()));
    createMenuItem(menu, "Delete", e -> shapeContainer.changeModeState(new DeleteMode()));
    createMenuItem(menu, "Mark", e -> shapeContainer.changeModeState(new MarkMode()));
    createMenuItem(menu, "Unmark", e -> shapeContainer.changeModeState(new UnmarkMode()));
    createMenuItem(menu, "Resize", e -> shapeContainer.changeModeState(new ResizeMode()));
    
    JMenu shapeMenu = new JMenu("Shapes");
    createMenuItem(shapeMenu,"Circle", e -> shapeContainer.shapeMode(ShapeMode.CIRCLE));
    createMenuItem(shapeMenu,"Rectangle", e -> shapeContainer.shapeMode(ShapeMode.RECTANGLE));
    
    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
    menuBar.add(shapeMenu);
    this.setJMenuBar(menuBar);
    }
  
  private void createMenuItem(JMenu menu, String label, ActionListener listener)
    {
    JMenuItem menuItem = new JMenuItem(label);
    menuItem.addActionListener(listener);
    menu.add(menuItem);
    }

  public static void main(String args[])
    {
    new ShapeApp(); // obs egentligen SwingUtilities ...
    }
  }
