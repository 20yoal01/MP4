package MP4.ModeState;

import MP4.Point;
import MP4.Pointable;
import MP4.ShapeContainer;

public class MoveMode extends Mode implements Pointable {

    public MoveMode(ShapeContainer shapeContainer){
        super(shapeContainer);
    }

    @Override
    public void pointerDown(Point point) {}

    @Override
    public void pointerUp(Point point) {}

    @Override
    public void pointerMoved(Point point, boolean pointerDown) {
        shapeContainer.getSelected().moveTo(point);
        shapeContainer.repaint(); // uppmanar swing att måla om
    }

}
