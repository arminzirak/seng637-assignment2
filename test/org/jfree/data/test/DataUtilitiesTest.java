package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;


import java.security.InvalidParameterException;
import java.security.Key;

import static org.junit.Assert.assertEquals;

public class DataUtilitiesTest {
    private DataUtilities dataUtilities;
    private Mockery mockery, mockery_missing, mockery_one_row, mockery_one_column, mockery_key_values;
    private Values2D values2D, values2D_with_missing, values2D_one_row, values2D_one_column;
    private KeyedValues keyedValues;
    @BeforeClass public static void setUpBeforeClass()
            throws Exception {
    }
    @Before
    public void setUp() throws Exception {
        mockery = new Mockery();
        values2D = mockery.mock(Values2D.class);
        mockery.checking(new Expectations(){{
            one(values2D).getColumnCount();
            will(returnValue(3));

            one(values2D).getRowCount();
            will(returnValue(2));


            one(values2D).getValue(0, 0);
            will(returnValue(0));

            one(values2D).getValue(0, 1);
            will(returnValue(1));

            one(values2D).getValue(0, 2);
            will(returnValue(2));

            one(values2D).getValue(1, 0);
            will(returnValue(10));

            one(values2D).getValue(1, 1);
            will(returnValue(20));

            one(values2D).getValue(1, 2);
            will(returnValue(30));
        }});

        mockery_missing = new Mockery();
        values2D_with_missing = mockery_missing.mock(Values2D.class);
        mockery_missing.checking(new Expectations(){{
            one(values2D_with_missing).getColumnCount();
            will(returnValue(3));

            one(values2D_with_missing).getRowCount();
            will(returnValue(2));


            one(values2D_with_missing).getValue(0, 0);
            will(returnValue(0));

            one(values2D_with_missing).getValue(0, 1);
            will(returnValue(null));

            one(values2D_with_missing).getValue(0, 2);
            will(returnValue(2));

            one(values2D_with_missing).getValue(1, 0);
            will(returnValue(10));

            one(values2D_with_missing).getValue(1, 1);
            will(returnValue(20));

            one(values2D_with_missing).getValue(1, 2);
            will(returnValue(30));
        }});

        mockery_one_row = new Mockery();
        values2D_one_row = mockery_one_row.mock(Values2D.class);
        mockery_one_row.checking(new Expectations(){{
            one(values2D_one_row).getColumnCount();
            will(returnValue(3));

            one(values2D_one_row).getRowCount();
            will(returnValue(1));


            one(values2D_one_row).getValue(0, 0);
            will(returnValue(0));

            one(values2D_one_row).getValue(0, 1);
            will(returnValue(1));

            one(values2D_one_row).getValue(0, 2);
            will(returnValue(2));
        }});

        mockery_one_column = new Mockery();
        values2D_one_column = mockery_one_column.mock(Values2D.class);
        mockery_one_column.checking(new Expectations(){{
            one(values2D_one_column).getColumnCount();
            will(returnValue(1));

            one(values2D_one_column).getRowCount();
            will(returnValue(2));


            one(values2D_one_column).getValue(0, 0);
            will(returnValue(10));

            one(values2D_one_column).getValue(1, 0);
            will(returnValue(20));
        }});

        mockery_key_values = new Mockery();
        keyedValues = mockery_key_values.mock(KeyedValues.class);
        mockery_key_values.checking(new Expectations(){{
            atLeast(1).of(keyedValues).getItemCount();
            will(returnValue(4));

            atLeast(1).of(keyedValues).getKey(0);
            will(returnValue(0));

            atLeast(1).of(keyedValues).getKey(1);
            will(returnValue(1));

            atLeast(1).of(keyedValues).getKey(2);
            will(returnValue(2));

            atLeast(1).of(keyedValues).getKey(3);
            will(returnValue(3));


            atLeast(1).of(keyedValues).getValue(0);
            will(returnValue(1.0));

            atLeast(1).of(keyedValues).getValue(1);
            will(returnValue(5.0));

            atLeast(1).of(keyedValues).getValue(2);
            will(returnValue(10.0));

            atLeast(1).of(keyedValues).getValue(3);
            will(returnValue(15.0));
        }});
    }


    @Test
    public void testCreateNumberArray() {
        double[] list = new double[10];
        for (int i = 0; i < 10; i ++){
            list[i] = i  *1.1;
        }
        Number[] generated_list = DataUtilities.createNumberArray(list);
        assertEquals(list.length, 10);
        assertEquals(generated_list.length, 10);
        for (int i = 0; i < 10; i++){
            assertEquals(list[i], generated_list[i]);
        }
    }

    @Test
    public void testCalculateRowBasic() {
        double result = DataUtilities.calculateRowTotal(values2D, 0);
        assertEquals( 3, result, 0);
    }

    @Test
    public void testCalculateRowLastRow() {
        double result = DataUtilities.calculateRowTotal(values2D, 1);
        assertEquals( 60, result, 0);
    }

    @Test
    public void testCalculateRowWithMissingValue() {
        double result = DataUtilities.calculateRowTotal(values2D_with_missing, 0);
        assertEquals( 2, result, 0);
    }

    @Test
    public void testCalculateRowOneRow() {
        double result = DataUtilities.calculateRowTotal(values2D_one_row, 0);
        assertEquals( 3, result, 0);
    }

    @Test
    public void testCalculateRowOneColumn() {
        double result = DataUtilities.calculateRowTotal(values2D_one_column, 0);
        assertEquals( 30, result, 0);
    }

    @Test(expected = InvalidParameterException.class)
    public void testCalculateRowWithNullInput() {
        DataUtilities.calculateRowTotal(null, 1);
    }


//
    @Test
    public void testCalculateColumnBasic() {
        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        assertEquals( 10, result, 0);
    }

    @Test
    public void testCalculateColumnLastColumn() {
        double result = DataUtilities.calculateColumnTotal(values2D, 2);
        assertEquals( 32, result, 0);
    }

    @Test
    public void testCalculateColumnNonBoundaryColumn() {
        double result = DataUtilities.calculateColumnTotal(values2D, 1);
        assertEquals( 21, result, 0);
    }

    @Test
    public void testCalculateColumnWithMissingValue() {
        double result = DataUtilities.calculateColumnTotal(values2D_with_missing, 1);
        assertEquals( 20, result, 0);
    }

    @Test
    public void testCalculateColumnOneRow() {
        double result = DataUtilities.calculateColumnTotal(values2D_one_row, 1);
        assertEquals( 1, result, 0);
    }

    @Test
    public void testCalculateColumnOneColumn() {
        double result = DataUtilities.calculateColumnTotal(values2D_one_column, 0);
        assertEquals( 30, result, 0);
    }

    @Test(expected = InvalidParameterException.class)
    public void testCalculateColumnWithNullInput() {
        DataUtilities.calculateColumnTotal(null, 1);
    }
//
    @Test
    public void testGetCumulativePercentagesNormal() {
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals(6.0/31.0, result.getValue(1));
    }

    @Test
    public void testGetCumulativePercentagesLastElement() {
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals(1.0, result.getValue(3));
    }

    @Test
    public void testGetCumulativePercentagesFirstElement() {
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals(1.0/31.0, result.getValue(0));
    }

    @Test(expected = InvalidParameterException.class)
    public void testGetCumulativePercentagesNull() {
        DataUtilities.getCumulativePercentages(null);
    }

    @After
    public void tearDown() throws Exception {
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}