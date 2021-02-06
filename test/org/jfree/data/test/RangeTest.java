package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.*;

import static org.junit.Assert.assertEquals;
public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass()
            throws Exception {
    }
    @Before
    public void setUp() throws Exception {
        exampleRange = new Range(-1, 1);
    }
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
                0, exampleRange.getCentralValue(), .000000001d);
    }

    @Test
    public void testCombine() {
        Range firstRange  = new Range(-1, 2);
        Range secondRange  = new Range(-3, 0);
        Range resultRange  = Range.combine(firstRange,secondRange);
        assertEquals(resultRange.getLowerBound(), -3.0,0);
        assertEquals(resultRange.getUpperBound(), 2.0,0);
    }
    @After
    public void tearDown() throws Exception {
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
