package MP4.ModeState;

import MP4.Point;
import MP4.Pointable;
import MP4.ShapeContainer;

public abstract class Mode implements Pointable {
    ShapeContainer shapeContainer;

    Mode(ShapeContainer shapeContainer){
        this.shapeContainer = shapeContainer;
    }

    @Override
    abstract public void pointerDown(Point point);

    @Override
    abstract public void pointerUp(Point point);

    @Override
    abstract public void pointerMoved(Point point, boolean pointerDown);
}
