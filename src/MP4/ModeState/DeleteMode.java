package MP4.ModeState;

import MP4.ShapeContainer;

public class DeleteMode implements ModeState{
    private Mode mode;

    public DeleteMode(Mode mode) {
        this.mode = mode;
    }

    @Override
    public void execute() {
        System.out.println("Do delete");
    }

    @Override
    public void insert() {
        System.out.println("Change to INSERT");
        this.mode.setMode(new InsertMode(this.mode));
    }

    @Override
    public void move() {
        System.out.println("Change to MOVE");
        this.mode.setMode(new MoveMode(this.mode));
    }

    @Override
    public void delete() {
        System.out.println("Already in DELETE");
    }
}
