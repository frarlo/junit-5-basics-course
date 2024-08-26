package org.frarlo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When running MathUtils")
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @Nested
    @DisplayName("add method")
    class AddTest {

        @Test
        @DisplayName("when adding two positive numbers")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1), "should return the right sum");
        }

        @Test
        @DisplayName("when adding two negative numbers")
        void testAddNegative() {
            assertEquals(-2, mathUtils.add(-1, -1), "should return the right sum");
        }

    }

    @Test
    @DisplayName("multiply method")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }

    @Test
    @DisplayName("divide method")
    void testDivide() {
        // Exception class; executable -> lambda of the method; and message:
        assertThrows(ArithmeticException.class,
                () -> mathUtils.divide(1, 0),
                "Divide by zero should throw an Exception"
        );
    }

    @Test
    @DisplayName("circle area method")
    void testComputeCircleArea() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),
                "Should return circle area");
    }

    @Test
    @Disabled
    @DisplayName("TDD method. Yet to be implemented. Should not run.")
    void testDisabled(){
        fail("This test is disabled.");
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    @DisplayName("This test won't run on Windows.")
    void testWindowsOsDisabled(){
        fail("This test is disabled for Windows");
    }

}