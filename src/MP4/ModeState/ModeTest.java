package MP4.ModeState;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


class ModeTest {

    Mode mode;

    @BeforeEach
    void setUp() {
        mode = new Mode();
    }

    @AfterEach
    void tearDown() {
        mode = null;
    }

    @Test
    void SwitchToDeleteAndConfirmInstance() {
        mode.doDelete();
        assertInstanceOf(DeleteMode.class, mode.currentState, "Successfully changed mode");

    }

    @Test
    void SwitchToMoveAndConfirmInstance(){
        mode.doMove();
        assertInstanceOf(MoveMode.class, mode.currentState, "Successfully changed mode");
    }

    @Test
    void ExecuteInsertWithoutSwitchMode(){
        mode.doStuff();
        assertInstanceOf(InsertMode.class, mode.currentState, "Successfully changed mode");
    }
}