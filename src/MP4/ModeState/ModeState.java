package MP4.ModeState;

import static MP4.ShapeContainer.Mode;

public interface ModeState {
    //All the modes
    void execute();
    void insert();
    void move();
    void delete();

}
