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

    private ModeState modeState;
    public enum ShapeMode {
        CIRCLE, RECTANGLE;
    }

    public enum Mode {
        INSERT, MOVE, DELETE, MARK, UNMARK, RESIZE
    }

    ;

    private Mode mode = Mode.INSERT;
    private ShapeMode shapeMode = ShapeMode.CIRCLE;
    private Shape selected;

    public ShapeContainer() {
        super();
        modeState = new ModeState();
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
        if (mode == Mode.INSERT) {
            System.out.println("Insert");
            switch (shapeMode) {
                case CIRCLE -> shapes.add(new Circle(point, Math.random() * 50.0));
                case RECTANGLE -> shapes.add(new Rectangle(point, 40, 60));
            }
            repaint(); // uppmanar swing att måla om
        } else if (mode == Mode.MOVE) {
            System.out.println("Move");
            select(point);
        } else if (mode == Mode.DELETE) {
            System.out.println("Delete");
            select(point);
            if (selected != null)
                shapes.remove(selected);
            selected = null;
            repaint(); // uppmanar swing att måla om
        } else if (mode == Mode.MARK) {
            System.out.println("Mark");
            select(point);
            if (selected != null) {
                Shape markedShape = new ShapeDecorator(selected);
                shapes.remove(selected);
                shapes.add(markedShape);
                repaint();
            }
        } else if (mode == Mode.UNMARK) {
            System.out.println("Unmark");
            select(point);
            if (selected != null) {
                Shape unmarkedShape = selected.peel();
                shapes.remove(selected);
                shapes.add(unmarkedShape);
                repaint();
            }
        } else if (mode == Mode.RESIZE) {
            System.out.println("Resize");
            select(point);
        }
    }

    public void pointerUp(Point point) {
        selected = null;
    }

    public void pointerMoved(Point point, boolean pointerDown) {
        if (selected != null && pointerDown) {
            if (mode == Mode.MOVE) {
                selected.moveTo(point);
                repaint(); // uppmanar swing att måla om
            } else if (mode == Mode.RESIZE) {
                selected.resizeTo(point);
                repaint();
            }
        }
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    /* Detta är mina testmetoder för att se om det fungerar med state och med mindre if-else satser
     * PointerDownTest ska eventuellt ersätta hela pointerDown, changeModeState ska ersätta setMode
     *
     * Testa köra programmet, det ska visas i konsolen vilket mode som utförs
     */
    public void pointerDownTest(Point point){
        this.modeState.drawShape();
        select(point);
    }
    public void changeModeState(ModeInterface mode){
        this.modeState.setMode(mode);
    }
}
