package MP4.ModeState;

public class Mode {
    ModeState currentState;

    public Mode() {
        this.currentState = new InsertMode(this);
    }
    public void setMode(ModeState mode){
        this.currentState = mode;
    }

    public void doStuff(){
        this.currentState.execute();
    }

    public void doInsert(){
        currentState.insert();
    }
    public void doMove(){
        currentState.move();
    }
    public void doDelete(){
        currentState.delete();
    }
}
