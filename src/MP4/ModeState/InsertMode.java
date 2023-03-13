package MP4.ModeState;

import MP4.ShapeContainer;

public class InsertMode implements ModeState{
    private Mode mode;

    public InsertMode(Mode mode) {
        this.mode = mode;
    }

    @Override
    public void execute() {
        System.out.println("Do insert");
    }

    @Override
    public void insert() {
        System.out.println("Already in INSERT");
    }

    @Override
    public void move() {
        System.out.println("Change to MOVE");
        this.mode.setMode(new MoveMode(this.mode));
    }

    @Override
    public void delete() {
        System.out.println("Change to DELETE");
        this.mode.setMode(new DeleteMode(this.mode));
    }
}
