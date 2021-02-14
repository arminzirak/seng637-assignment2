package org.jfree.data;
/**
 *  
 *  Simple test cases for org.jfree.data.Range which has 15 methods.
 *   <p> Those test cases are mainly completed by Mingrui with some guidance from group partners, Armin and Sepehr.
 *   the test plan describe 5 methods.
 *   @author Mingrui
 *   @author Armin
 *   @author Sepehr
 */





import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range; import org.junit.*;

import org.junit.rules.ExpectedException;
public class RangeTest {
private Range exampleRange;
@BeforeClass public static void setUpBeforeClass()
throws Exception {
}
@Before
public void setUp() throws Exception { exampleRange = new Range(-1.0, 1.0);
}


/**
 * testing the central value to be zero
 * 
 */
@Test
public void centralValueShouldBeZero() {
    assertEquals("The central value of -1 and 1 should be 0",
            0, exampleRange.getCentralValue(), .000000001d);
}

/**
 * testing the bound with positive lower  band
 */
@Test
public void testGetLowerBoundWithPositiveLower() {
    Range range = new Range(1, 5);
    assertEquals("the lower range should be 1", 1.0,range.getLowerBound(),0.0000001);
}
/**
 * testing the bound with negative lower band
 */
@Test
public void testGetLowerBoundWithNegativeLower() {
    Range range = new Range(-1, 5);
    assertEquals("the lower range should be -1",-1.0,range.getLowerBound(),0.0000001);
}
/**
 * testing the bound with zero lower band
 */
@Test
public void testGetLowerBoundWithZeroLower() {
    Range range = new Range(0, 5);
    assertEquals("the lower range should be 0",0,range.getLowerBound(),0.0000001);
}
/**
 * testing the bound with positive upper  band
 */
@Test 
public void testGetUpperBoundWithPositiveUpper() {
    Range range = new Range(1, 5);
    assertEquals("the upper range should be 5", 5.0,range.getUpperBound(),0.0000001);
}

/**
 * testing the bound with negative upper  band
 */
@Test
public void testGetUpperBoundWithNegativeUpper() {
    Range range = new Range(-5, -1);
    assertEquals("the upper range should be -1", -1.0,range.getUpperBound(),0.0000001);
}
/**
 * testing the bound with negative upper  band
 */
@Test
public void testGetUpperBoundWithZeroUpper() {
    Range range = new Range(-5, 0);
    assertEquals("the upper range should be 0", 0,range.getUpperBound(),0.0000001);
}

/**
 * testing the Length with negative range
 */

@Test
public void testGetLengthWithNegativeRange() {
	Range range = new Range(-5, 0);
    assertEquals("the length of negative range should be 5",5.0,range.getLength(),0.001);
}
/**
 * testing the Length with positive range
 */
@Test
public void testGetLengthWithPositiveRange() {
	Range range = new Range(0, 5);
    assertEquals("the length of positive range should be 5",5.0,range.getLength(),0.001);
}

/**
 * testing whether it contains positive values in range
 */
@Test 
public void testContainsValueInRange() {
    assertTrue(exampleRange.contains(0.5));
}
/**
 * testing whether it contains zero in range
 */
@Test
public void testContainsValueZero() {
    assertTrue(exampleRange.contains(0));
}
/**
 * testing whether it contains equal upper range value in range
 */
@Test
public void testContainsValueEqualToUpperRange() {
    assertTrue(exampleRange.contains(1.0));
}
/**
 * testing whether it contains more than upper range values out of range
 */
@Test
public void testContainsValueMoreThanUpperRange() {
    assertFalse(exampleRange.contains(5.0));
}
/**
 * testing whether it contains equal lower range value in range
 */
@Test
public void testContainsValueEqualToLowerRange() {
    assertTrue(exampleRange.contains(-1.0));
}

/**
 * testing whether it intersects positive values in range
 */
@Test
public void testOverlappedPositiveValuesintersectsInRange() {
    assertTrue(exampleRange.intersects(0.0,0.50));
    
}
/**
 * testing whether it intersects positive values out of range
 */
@Test
public void testOverlappedPositiveValuesintersectsOutOfRange() {
   assertTrue(exampleRange.intersects(0.0,4.0));
   assertFalse(exampleRange.intersects(2.0,5.0)); 
    
}
/**
 * testing whether it intersects negative values in range
 */
@Test
public void testOverlappedNegativeValuesintersectsInRange() {   
   assertTrue(exampleRange.intersects(-0.5,0.0)); 
}

/**
 * testing whether it intersects negative values out of range
 */
@Test
public void testOverlappedNegativeValuesintersectsOutofRange() {
    assertTrue(exampleRange.intersects(-2.0,5.0));
}

/**
 * testing whether it intersects values which equal in upper band
 */
@Test
public void testOverlappedValuesintersectsUpperRange() {
    assertTrue(exampleRange.intersects(-1.0,1.0));
    assertTrue(exampleRange.intersects(-2.0,1.0));
    assertFalse(exampleRange.intersects(1.0,5.0)); 
}

/**
 * testing whether it intersects values which equal in lower band
 */
@Test
public void testOverlappedValuesintersectsLowerRange() {
    assertTrue(exampleRange.intersects(-1.0,5.0));
    assertTrue(exampleRange.intersects(-1.0,0.0));  
    assertFalse(exampleRange.intersects(-5.0,-1.0)); 
}
/**
 * testing the positive input within range
 */

@Test
public void testPositiveValuesconstrainWithinRange() {
	assertEquals("the constrain value should be 0.2",0.2,exampleRange.constrain(0.2),0.001);	
}
/**
 * testing the positive input out of range
 */
@Test
public void testPositiveValuesconstrainOutofRange() {
    assertEquals("the constrain value should be 1.0",1,exampleRange.constrain(1.2),0.001);
    assertEquals("the constrain value should be 1.0",1,exampleRange.constrain(5.0),0.001);
    assertEquals("the constrain value should be 1.0",1,exampleRange.constrain(Double.POSITIVE_INFINITY),0.001);
    
}
/**
 * testing the input with lower and upper band
 */
@Test
public void testNegativeValuesconstrainWthBand() {
	assertEquals("the constrain value should be -1.0",-1,exampleRange.constrain(-1.0),0.001);
	assertEquals("the constrain value should be 1.0",1,exampleRange.constrain(1.0),0.001);
}
/**
 * testing the negative input out of range
 */
@Test
public void testNegativeValuesconstrainOutofRange() {
    assertEquals("the constrain value should be -1.0",-1,exampleRange.constrain(-5.0),0.001);
    assertEquals("the constrain value should be -1.0",-1,exampleRange.constrain(Double.NEGATIVE_INFINITY),0.001);    
}


/**
 * testing tow intersecting range
 */
@Test
public void testintersectCombine() {
    Range firstRange  = new Range(-1.0, 6.0);
    Range secondRange  = new Range(-3.0, 5.0);
    Range resultRange  = Range.combine(firstRange,secondRange);
    assertEquals(new Range(-3,6),Range.combine(firstRange,secondRange));
    assertEquals("the lower bound should be -3.0",-3.0,resultRange.getLowerBound(),0.001);
    assertEquals("the lower bound should be 1.0",1.0,resultRange.getUpperBound(),0.001);
}
/**
 * testing tow disjoint range
 */
@Test
public void testdisjointCombine() {
    Range firstRange  = new Range(-1.0, 5.0);
    Range secondRange  = new Range(4.0, 8.0);
    try{
    Range resultRange  = Range.combine(firstRange,secondRange);
   
    assertEquals(new Range(-1,8),Range.combine(firstRange,secondRange));
    assertEquals("the lower bound should be -1.0",-1.0,resultRange.getLowerBound(),0.001);
    assertEquals("the upper bound should be 8.0",8.0,resultRange.getUpperBound(),0.001);
    }
    catch(IllegalArgumentException e) {
      fail("Fail to combine, error:"+e.getMessage());
    }   
}
/**
 * testing tow NULL range
 */
@Test
public void NULLtestCombine() {
	Range firstRange  = new Range(-1.0, 1.0);
    Range secondRange  = new Range(-3.0, 0.0);
    assertNull(Range.combine(null, null));
    assertEquals("the combined range should be (-1.0, 1.0) ",firstRange, Range.combine(firstRange, null));
    assertEquals("the combined range should be (-3.0, 0.0) ",secondRange, Range.combine(null, secondRange));
    
}
/**
 * testing positive input our of range
 */
@Test
public void testPositiveValuesOutofRangeexpandToInclude() {
	Range expandRange  = new Range(-2, 2);
    Range resultRange  = Range.expandToInclude(expandRange,3.0);
    assertEquals("the lower bound should be -2.0",-2.0,resultRange.getLowerBound(),0.001);
    assertEquals("the upper bound should be 3.0",3.0,resultRange.getUpperBound(),0.001);
    
}
/**
 * testing positive input out of range
 */
@Test
public void testPositiveValuesInRangeexpandToInclude() {
    Range expandRange  = new Range(-2, 2);
    Range resultRange  = Range.expandToInclude(expandRange,1.0);
    assertEquals("the lower bound should be -2.0",-2.0,resultRange.getLowerBound(),0.001);
    assertEquals("the upper bound should be 2.0",2.0,resultRange.getUpperBound(),0.001);
    
}
/**
 * testing negative input out of range
 */
@Test
public void testNegativeValuesexpandToInclude() {
	Range expandRange  = new Range(-2.0, 2.0);
    Range resultRange  = Range.expandToInclude(expandRange,-3.0);
    assertEquals("the lower bound should be -3.0",-3.0,resultRange.getLowerBound(),0.001);
    assertEquals("the upper bound should be -3.0",2.0,resultRange.getUpperBound(),0.001);    
}
/**
 * testing null range with one input
 */
@Test
public void testNULLRangeValuesexpandToInclude() {
    assertEquals("the range should be (3.0,3.0)",new Range(3.0,3.0), Range.expandToInclude(null, 3.0));
}

/**
 * testing {@code expand} with a normal range
 */
@Test
public void expand() {
	Range expandRange  = new Range(2.0, 6.0);
	Range expandedRange = Range.expand(expandRange, 0.25, 0.5);
	assertEquals("the expanded length should be 7.0",7.0,expandedRange.getLength(),0.001);
}
/**
 * testing {@code NULLexpand} with null range
 */

@Test(expected = IllegalArgumentException.class)
public void NULLexpand() {
	Range.expand(null, 1.0, 2.0);	
}

/**
 * testing {@code shift} with positive delta
 */
@Test
public void testPositiveShift() {
  Range shifted= Range.shift(exampleRange, 2.0);
  assertEquals("the lower bound should be -1.0",1.0,shifted.getLowerBound(), 0.001);
  assertEquals("the lower bound should be 3.0",3.0,shifted.getUpperBound(),0.001);
}

/**
 * testing {@code shift} with zero delta
 */
@Test
public void testZeroShift() {
  Range shifted= Range.shift(exampleRange, 0.0);
  assertEquals("the lower bound should be -1.0",-1.0,shifted.getLowerBound(), 0.001);
  assertEquals("the upper bound should be 1.0",1.0,shifted.getUpperBound(),0.001);
}
/**
 * testing {@code shift} with negative delta
 */
@Test
public void testNegativeShift() {
  Range shifted= Range.shift(exampleRange, -2.0);
  assertEquals("the lower bound should be -1.0",-1.0,shifted.getLowerBound(), 0.001);
  assertEquals("the upper bound should be -3.0",-3.0,shifted.getUpperBound(),0.001);
}

/**
 * testing {@code shift} with null range
 */
@Test(expected =NullPointerException.class)
public void NULLshift() {
    Range.shift(null, 1);
    Range.shift(null, 0);
}

/**
 * testing {@code shift} following NoAllowZeroCrossing rule with positive delta
 */
@Test
public void NONallowZeroPositiveDeltaCrossingshift() {
  Range shifted= Range.shift(exampleRange, 2, false);
  assertEquals("the lower bound should be 0.0",0.0,shifted.getLowerBound(), 0.001);
  assertEquals("the lower bound should be 3.0",3.0,shifted.getUpperBound(),0.001);      
}

/**
 * testing {@code shift} following NoAllowZeroCrossing rule with negative delta
 */
@Test
public void NONallowZeroNegativeDeltaCrossingshift() {    
    Range shift3=new Range(-10.0,10.0);
    Range shift4=Range.shift(shift3,-20.0, false);
    assertEquals("the lower bound should be -30",-30.0,shift3.getLowerBound(), 0.001);
    assertEquals("the upper bound should be 0",0.0,shift4.getUpperBound(),0.001);
}

/**
 * testing equals with same Lower and different Upper
 */
@Test
public void testEqualsWithSameLowerDifferentUpper() {
    Range equals1=new Range(0.0,1.0);
    Range equals2=new Range(0.0,2.0);
    assertFalse(equals1.equals(equals2));
    assertFalse(equals1.equals(-3.0));
}
/**
 * testing equals with same Lower and same Upper
 */
@Test
public void testEqualsWithSameLowerSameUpper() {
    Range equals1= new Range(0,1);
    Range equals2= new Range(0,1);  
    assertTrue(equals1.equals(equals2));
}
/**
 * testing equals with different Lower and same Upper
 */
@Test
public void testEqualsWithDifferentLowerSameUpper() {
    Range equals1= new Range(0,1);
    Range equals2= new Range(-1,1);  
    assertFalse(equals1.equals(equals2));
}
/**
 * testing equals with different Lower and different Upper
 */
@Test
public void testEqualsWithDifferentLowerDifferentUpper  () {
    Range equals1= new Range(0,2);
    Range equals2= new Range(-1,1);  
    assertFalse(equals1.equals(equals2));
    assertFalse(equals1.equals(-3.0));
}

/**
 * testing equals with null input
 */
@Test
public void testEqualsWithNullInput  () {
    Range equals1= new Range(0,2);
    assertFalse(equals1.equals(null));
}

/**
 * testing equals with null range
 */

@Test(expected =NullPointerException.class)
public void testEqualsWithNonRangeInput() {
  Range equals1= null;
  assertFalse(equals1.equals(2));
}

/**
 * testing hashcode with positive value
 */

@Test
public void testPositiveValueshashCode() {
	Range hash1= new Range(0.0,50.0);
	Range hash2= new Range(0.0,50.0);
	assertEquals(hash1.hashCode(), hash2.hashCode());
}
/**
 * testing hashcode with negative value
 */
@Test
public void testNegativeValueshashCode() {
	Range hash1= new Range(-50.0,0.0);
	Range hash2= new Range(-50.0,0.0);
	assertEquals(hash1.hashCode(), hash2.hashCode());
}
/**
 * testing string representation of the range of input
 */

@Test
public void testtoString() {
	String expected="Range[-1,1]";
	assertEquals("a string should be 'Range[-1,1]'", expected,exampleRange.toString());	
}



@After
public void tearDown() throws Exception {
}
@AfterClass
public static void tearDownAfterClass() throws Exception {
}
}