package game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessProblemTest {

    Exception e = new Exception();

    @Test
    public void ShouldReturnFalseWhenToDo(){
        assertEquals(ProcessProblem.toDo(e), Boolean.FALSE);
    }
}
