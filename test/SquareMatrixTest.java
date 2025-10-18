import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class SquareMatrixTest {
    @Test
    public void testDeterminant(){
        assertEquals(12, new SquareMatrix(2, 0, 0, -3, 2, 0, -3, 2, 3).determinant());
        assertEquals(0, new SquareMatrix(0, 0, 0, -3, 2, 0, -3, 2, 0).determinant());
        assertEquals(62, new SquareMatrix(5, 4, -3, 10).determinant());
        assertEquals(0, new SquareMatrix(0, 0, 5, -7).determinant());

    }
}
