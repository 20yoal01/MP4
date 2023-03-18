package MP4.ModeState;

import MP4.*;

public class MarkMode extends Mode implements Pointable {

    public MarkMode(ShapeContainer shapeContainer){
        super(shapeContainer);
    }

    @Override
    public void pointerDown(Point point) {
        Shape selected = shapeContainer.getSelected();
        if (selected != null) {
            Shape markedShape = new ShapeDecoratorCrossHair(selected);
            shapeContainer.getShapes().remove(selected);
            shapeContainer.getShapes().add(markedShape);
            shapeContainer.repaint();
        }
    }

    @Override
    public void pointerUp(Point point) {}

    @Override
    public void pointerMoved(Point point, boolean pointerDown) {}


}
