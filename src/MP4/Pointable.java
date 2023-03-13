package MP4;

public interface Pointable {
    public void pointerDown(Point point);

    public void pointerUp(Point point);

    public void pointerMoved(Point point, boolean pointerDown);

    void pointerDownTest(Point point);
}
