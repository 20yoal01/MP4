package MP4;

import MP4.ModeState.*;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class ShapeContainer extends JPanel implements Pointable {
    private static final long serialVersionUID = 1L;
    private List<Shape> shapes = new LinkedList<Shape>();

    private Mode mode;

    /*public enum Mode {
        INSERT, MOVE, DELETE, MARK, UNMARK, RESIZE
    }*/

    ;

    //private Mode mode = Mode.INSERT;
    private ShapeMode shapeMode = ShapeMode.CIRCLE;
    private Shape selected;

    public ShapeContainer() {
        super();
        mode = new InsertMode(this);
        MouseHandler mouseHandler = new MouseHandler(this);
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
        this.setBackground(Color.white);
    }


    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void paintComponent(Graphics g) // anropas av Swing när det är dags att
    // rendera
    {
        super.paintComponent(g);

        for (Shape shape : shapes)
            shape.draw(g);

    }


    private void select(Point point) {
        for (Shape shape : shapes) {
            if (shape.intersects(point)) {
                selected = shape;
                return;
            }
        }
    }

    public void shapeMode(ShapeMode shapeMode) {
        this.shapeMode = shapeMode;
    }

    public void pointerDown(Point point) {
        select(point);
        mode.pointerDown(point);
    }

    public void pointerUp(Point point) {
        selected = null;
        mode.pointerUp(point);
    }

    public void pointerMoved(Point point, boolean pointerDown) {
        if (selected != null && pointerDown) {
            mode.pointerMoved(point, true);
        }
    }

    public List<Shape> getShapes(){
        return shapes;
    }

    public Shape getSelected(){
        return selected;
    }

    public ShapeMode getShapeMode(){
        return shapeMode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    /* Detta är mina testmetoder för att se om det fungerar med state och med mindre if-else satser
     * PointerDownTest ska eventuellt ersätta hela pointerDown, changeModeState ska ersätta setMode
     *
     * Testa köra programmet, det ska visas i konsolen vilket mode som utförs
     */

    public void changeModeState(Mode newMode){
        mode = newMode;
    }
}
