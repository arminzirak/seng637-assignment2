/**
 * @author_MingruiYu yumin
 *
 **/

package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass()
            throws Exception {
    }

    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1.0, 1.0);
    }

    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
                0, exampleRange.getCentralValue(), .000000001d);
    }


    @Test
    public void testGetLowerBound() {
        assertEquals(-1.0,exampleRange.getLowerBound(),0.0000001);
    }

    @Test
    public void testGetUpperBound() {
        assertEquals(1.0,exampleRange.getUpperBound(),0.0000001);
    }

    @Test
    public void testGetLength() {
        assertEquals(2.0,exampleRange.getLength(),0.001);
    }

    @Test
    public void testContainsHasValue() {
        assertTrue(exampleRange.contains(1.0));
    }

    @Test
    public void testContainsHasNotValue() {
        assertFalse(exampleRange.contains(5.0));
    }

    @Test
    public void testIntersectCombinations() {
        assertTrue(exampleRange.intersects(0.0,0.50));
        assertTrue(exampleRange.intersects(0.0,4.0));
        assertTrue(exampleRange.intersects(-1.0,0.0));
        assertTrue(exampleRange.intersects(-1.0,1.0));
        assertTrue(exampleRange.intersects(-1.0,5.0));
        assertFalse(exampleRange.intersects(1.0,2.0));
        assertFalse(exampleRange.intersects(-2.0,-1.0));
        assertTrue(exampleRange.intersects(-2.0,0.0));
        assertTrue(exampleRange.intersects(-2.0,1.0));
        assertTrue(exampleRange.intersects(-2.0,5.0));
        assertFalse(exampleRange.intersects(2.0,5.0));
    }

    @Test
    public void testConstrainAboveUpper() {
        assertEquals(1,exampleRange.constrain(1.2),0.001);
    }

    @Test
    public void testConstrainUpper() {
        assertEquals(1,exampleRange.constrain(1),0.001);
    }

    @Test
    public void testConstrainInRange() {
        assertEquals(0.5,exampleRange.constrain(0.5),0.001);
    }

    @Test
    public void testConstrainZeroValuesConstrain() {
        assertEquals(0,exampleRange.constrain(0),0);
    }

    @Test
    public void testConstrainLower() {
        assertEquals(-1,exampleRange.constrain(-1),0.001);
    }

    @Test
    public void testConstrainBelowLower() {
        assertEquals(-1,exampleRange.constrain(-5.0),0.001);
    }


    @Test
    public void testCombine() {
        Range firstRange  = new Range(-1.0, 6.0);
        Range secondRange  = new Range(-3.0, 5.0);
        Range resultRange  = Range.combine(firstRange,secondRange);
        assertEquals(new Range(-3,6),Range.combine(firstRange,secondRange));
        assertEquals(-3.0,resultRange.getLowerBound(),0.001);
        assertEquals(1.0,resultRange.getUpperBound(),0.001);
    }

    @Test
    public void NULLtestCombine() {
        Range firstRange  = new Range(-1.0, 1.0);
        Range secondRange  = new Range(-3.0, 0.0);
        assertNull(Range.combine(null, null));
        assertEquals(firstRange, Range.combine(firstRange, null));
        assertEquals(secondRange, Range.combine(null, secondRange));

    }

    @Test
    public void testPositiveValuesexpandToInclude() {
        Range expandRange  = new Range(-2, 2);
        Range resultRange  = Range.expandToInclude(expandRange,3.0);
        assertEquals(-2.0,resultRange.getLowerBound(),0.001);
        assertEquals(3.0,resultRange.getUpperBound(),0.001);

    }

    @Test
    public void testNegativeValuesexpandToInclude() {
        Range expandRange  = new Range(-2.0, 2.0);
        Range resultRange  = Range.expandToInclude(expandRange,-3.0);
        assertEquals(-3.0,resultRange.getLowerBound(),0.001);
        assertEquals(2.0,resultRange.getUpperBound(),0.001);
        assertEquals(new Range(3.0,3.0), Range.expandToInclude(null, 3.0));

    }

    @Test
    public void expand() {
        Range expandRange  = new Range(2.0, 6.0);
        Range expandedRange = Range.expand(expandRange, 0.25, 0.5);
        assertEquals(7.0,expandedRange.getLength(),0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void NULLexpand() {
        Range.expand(null, 1.0, 2.0);
    }

    @Test
    public void shift() {
        Range shifted= Range.shift(exampleRange, 2.0);
        assertEquals(1.0,shifted.getLowerBound(), 0.001);
        assertEquals(3.0,shifted.getUpperBound(),0.001);
        Range shift1=new Range(-10.0,10.0);
        Range shift2=Range.shift(shift1,10.0, true);
        assertEquals(0.0,shift1.getLowerBound(), 0.001);
        assertEquals(20.0,shift2.getUpperBound(),0.001);
        Range shift3=new Range(-10.0,0.0);
        Range shift4=Range.shift(shift3,-10.0, true);
        assertEquals(-20.0,shift3.getLowerBound(), 0.001);
        assertEquals(-10.0,shift4.getUpperBound(),0.001);




    }

    @Test
    public void NONallowZeroCrossingshift() {
        Range shifted= Range.shift(exampleRange, 2, false);
        assertEquals(0.0,shifted.getLowerBound(), 0.001);
        assertEquals(3.0,shifted.getUpperBound(),0.001);
        Range shift3=new Range(-10.0,10.0);
        Range shift4=Range.shift(shift3,-20.0, false);
        assertEquals(-30.0,shift3.getLowerBound(), 0.001);
        assertEquals(0.0,shift4.getUpperBound(),0.001);
    }

    @Test(expected =NullPointerException.class)
    public void NULLshift() {
        Range.shift(null, 1);
    }

    @Test
    public void testEqualsWithSameLowerDifferentUpper() {
        Range range1= new Range(0,1);
        Range range2= new Range(0,2);
        assertFalse(range1.equals(range2));
    }

    @Test
    public void testEqualsWithSameLowerSameUpper() {
        Range range1= new Range(0,1);
        Range range2= new Range(0,1);
        assertTrue(range1.equals(range2));
    }

    @Test
    public void testEqualsWithDifferentLowerSameUpper() {
        Range range1= new Range(-1,1);
        Range range2= new Range(0,1);
        assertFalse(range1.equals(range2));
    }

    @Test
    public void testEqualsWithDifferentLowerDifferentUpper() {
        Range range1= new Range(-1,2);
        Range range2= new Range(0,1);
        assertFalse(range1.equals(range2));
    }

    @Test
    public void testEqualsWithNullInput() {
        Range range1= new Range(-1,2);
        assertFalse(range1.equals(null));
    }

    @Test
    public void testEqualsWithNonRangeInput() {
        Range range1= new Range(-1,2);
        assertFalse(range1.equals(new Object()));
    }



    @Test
    public void testPositiveValueshashCode() {
        Range hash1= new Range(0.0,50.0);
        Range hash2= new Range(0.0,50.0);
        assertEquals(hash1.hashCode(), hash2.hashCode());
    }

    @Test
    public void testNegativeValueshashCode() {
        Range hash1= new Range(-50.0,0.0);
        Range hash2= new Range(-50.0,0.0);
        assertEquals(hash1.hashCode(), hash2.hashCode());
    }

    @Test
    public void testToString() {
        String expected="Range[-1,1]";
        assertEquals(expected,exampleRange.toString());
    }

    @After
    public void tearDown() throws Exception {
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}