package MP4.ModeState;

import MP4.ShapeContainer;

public class MoveMode implements ModeState{
    private Mode mode;

    public MoveMode(Mode mode) {
        this.mode = mode;
    }

    @Override
    public void execute() {
        System.out.println("Do Move");
    }

    @Override
    public void insert() {
        System.out.println("Change to INSERT");
        this.mode.setMode(new InsertMode(this.mode));
    }

    @Override
    public void move() {
        System.out.println("Already in MOVE");
    }

    @Override
    public void delete() {
        System.out.println("Change to DELETE");
        this.mode.setMode(new DeleteMode(this.mode));
    }
}
