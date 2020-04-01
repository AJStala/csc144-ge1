package com.eonsahead.operator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperatorTest {

    public OperatorTest() {
    }

    @Test
    public void testRotation() {
        System.out.println("rotation");
        double angle = 0.0;
        Operator instance = new Operator();
        instance.rotation(angle);
        fail("The test case is a prototype.");
    }

    @Test
    public void testMultiply() {
        System.out.println("multiply");
        Operator otherOperator = new Operator();
        Operator instance = new Operator();
        Operator expResult = new Operator();
        Operator result = instance.multiply(otherOperator);
        assertEquals(expResult.get(0, 0), result.get(0, 0), 1E-8);
        assertEquals(expResult.get(0, 1), result.get(0, 1), 1E-8);
        assertEquals(expResult.get(1, 0), result.get(1, 0), 1E-8);
        assertEquals(expResult.get(1, 1), result.get(1, 1), 1E-8);
    }

}
