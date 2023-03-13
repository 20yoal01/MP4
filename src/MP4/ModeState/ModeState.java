package MP4.ModeState;

public class ModeState {
    ModeInterface currentState;

    public ModeState() {
        this.currentState = new InsertMode();
    }
    public void setMode(ModeInterface mode){
        this.currentState = mode;
    }
    public void drawShape(){
        this.currentState.execute();
    }

}
