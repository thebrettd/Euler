package test.java;

import org.junit.Test;

public class TriangleNumberTest {

    @Test
    public void testComputeTriangleNumber() throws Exception {

        assert (1 == TriangleNumber.computeTriangleNumber(1));
        assert (3 == TriangleNumber.computeTriangleNumber(2));
        assert (28 ==  TriangleNumber.computeTriangleNumber(7));

    }
}
