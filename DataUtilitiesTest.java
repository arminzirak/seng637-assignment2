package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;


import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class DataUtilitiesTest {
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

    @Test // testing the calculateRowTotal with random input
    public void testCalculateRowBasic() {
        double result = DataUtilities.calculateRowTotal(values2D, 0);
        assertEquals( "the number of rows should be 3",3, result, 0);
    }

    @Test // testing the calculateRowTotal with last row
    public void testCalculateRowLastRow() {
        double result = DataUtilities.calculateRowTotal(values2D, 1);
        assertEquals( "the number of rows should be 60",60, result, 0);
    }

    @Test // testing the calculateRowTotal with missing values
    public void testCalculateRowWithMissingValue() {
        double result = DataUtilities.calculateRowTotal(values2D_with_missing, 0);
        assertEquals( "the number of rows should be 2",2, result, 0);
    }

    @Test // testing the calculateRowTotal with one row
    public void testCalculateRowOneRow() {
        double result = DataUtilities.calculateRowTotal(values2D_one_row, 0);
        assertEquals( "the number of rows should be 3",3, result, 0);
    }

    @Test// testing calculateRowTotal with one column
    public void testCalculateRowOneColumn() {
        double result = DataUtilities.calculateRowTotal(values2D_one_column, 0);
        assertEquals( "the number of rows should be 30",30, result, 0);
    }

    @Test(expected = InvalidParameterException.class) // testing with null input
    public void testCalculateRowWithNullInput() {
        DataUtilities.calculateRowTotal(null, 1);
    }


//
    @Test // testing the calculateColumnTotal with one random input
    public void testCalculateColumnTotalBasic() {
        double result = DataUtilities.calculateColumnTotal(values2D, 1);
        assertEquals( "the number of columns should be 21",21, result, 0);
    }

    @Test // testing the calculateColumnTotal with last column
    public void testCalculateColumnTotalLastColumn() {
        double result = DataUtilities.calculateColumnTotal(values2D, 2);
        assertEquals( "the number of columns should be 32",32, result, 0);
    }

    @Test // testing calculateColumnTotal with zero column
    public void testCalculateColumnTotalWithColumnZero() {
        double result = DataUtilities.calculateColumnTotal(values2D, 0);
        assertEquals( "the number of columns should be 10", 10, result, 0);
    }

    @Test // testing the calculateColumnTotal with missing values
    public void testCalculateColumnTotalWithMissingValue() {
        double result = DataUtilities.calculateColumnTotal(values2D_with_missing, 1);
        assertEquals( "the total number of columns should be 20", 20, result, 0);
    }

    @Test // testing the total column values with one row
    public void testCalculateColumnTotalOneRow() {
        double result = DataUtilities.calculateColumnTotal(values2D_one_row, 1);
        assertEquals("the number of rows should be 1", 1, result, 0);
    }

    @Test // testing the total column values with one column
    public void testCalculateColumnTotalOneColumn() {
        double result = DataUtilities.calculateColumnTotal(values2D_one_column, 0);
        assertEquals( "the number of columns should be 30",30, result, 0);
    }

    @Test(expected = InvalidParameterException.class) // testing with null input
    public void testCalculateColumnTotalWithNullInput() {
        DataUtilities.calculateColumnTotal(null, 1);
    }
//
    @Test // testing a random key percentage in the key value
    public void testGetCumulativePercentagesNormal() {
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals(6.0/31.0, result.getValue(1));
    }

    @Test // testing the percentage of last value in the key value
    public void testGetCumulativePercentagesLastElement() {
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals(1.0, result.getValue(3));
    }

    @Test // testing the first key value percentage
    public void testGetCumulativePercentagesFirstElement() {
        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals(1.0/31.0, result.getValue(0));
    }

    @Test(expected = InvalidParameterException.class) // testing with the null input
    public void testGetCumulativePercentagesNull() {
        DataUtilities.getCumulativePercentages(null);
    }

    @Test // testing with the null input
    public void testCreateNumberArrayNullInput(){
        DataUtilities.createNumberArray(null);
    }


    @Test // testing the equivalence of the input and output values
    public void testCreateNumberArrayWithSizeMoreThanOne() {
        double[] list = new double[10];
        for (int i = 0; i < 10; i ++){
            list[i] = i  * 1.1;
        }
        Number[] generated_list = DataUtilities.createNumberArray(list);
        assertEquals("the input list length should be 10",list.length, 10);
        assertEquals("the generated number array length should be 10",generated_list.length, 10);
        for (int i = 0; i < 10; i++){
            assertEquals("all the values in input and generated list should be equal",list[i], generated_list[i]);
        }
    }

    @Test // testing the array with length of one
    public void testCreateNumberArrayWithSizeOne() {
        double[] list = new double[1];
        list[0] = 5;
        Number[] generated_list = DataUtilities.createNumberArray(list);
        assertEquals("the generated number array length should be 1 ",generated_list.length, 1);
        assertEquals("the generated number array first value should be 5",5, generated_list[0]);
    }

    @Test // testing the array with length of zero
    public void testCreateNumberArrayWithSizeZero() {
        double[] list = new double[0];
        Number[] generated_list = DataUtilities.createNumberArray(list);
        assertEquals("the length of the generated number array should be 0",0, generated_list.length);
    }

    @Test(expected = IllegalArgumentException.class) //testing the null input
    public void testCreateNumberArray2dNullInput(){
        DataUtilities.createNumberArray2D(null);
    }

    @Test // testing the equivalence of 2 array values
    public void testCreateNumberArray2d() {
        double[][] list = new double[10][10];
        for (int i = 0; i < 10; i ++){
            for(int j=0 ; j<10 ;j++)
            {
                list[i][j] = i  * 1.1 + j;
            }
        }
        Number[][] generated_list = DataUtilities.createNumberArray2D(list);
        assertEquals("the length of the input list row should be 10",list.length, 10);
        assertEquals("the length of the generated list row should be 10",generated_list.length, 10);
        for (int i = 0; i < 10; i++){
            for(int j = 0 ; j < 10; j++){
                assertEquals("all the values in input and generated list should be equal",list[i][j], generated_list[i][j]);
            }
        }
    }

    @Test // testing the array with One Row and 10 columns
    public void testCreateNumberArray2dWithOneRow() {
        double[][] list = new double[1][10];
        for(int i=0 ; i<10 ;i++)
        {
            list[0][i] = i  * 1.1;
        }
        Number[][] generated_list = DataUtilities.createNumberArray2D(list);
        assertEquals("the length of the generated list row should be 1",generated_list.length, 1);
        assertEquals("the length of the generated list column should be 10",generated_list[0].length, 10);
        for(int i=0 ; i<10 ;i++)
        {
            assertEquals("all the values in input and generated list should be equal",list[0][i], generated_list[0][i]);
        }
    }

    @Test // testing the array with One Column and 10 rows
    public void testCreateNumberArray2dWithOneColumn() {
        double[][] list = new double[10][1];
        for(int i=0 ; i<10 ;i++)
        {
            list[i][0] = i  * 1.1;
        }
        Number[][] generated_list = DataUtilities.createNumberArray2D(list);
        assertEquals("the length of the generated list column should be 10",generated_list.length, 10);
        assertEquals("the length of the generated list should be 1",generated_list[0].length, 1);
        for(int i=0 ; i<10 ;i++)
        {
            assertEquals("all the values in input and generated list should be equal",list[i][0], generated_list[i][0]);
        }
    }

    @Test // testing the array with Zero Column
    public void testCreateNumberArray2dWithZeroColumn() {
        double[][] list = new double[10][0];
        Number[][] generated_list = DataUtilities.createNumberArray2D(list);
        assertEquals("the length of the generated list column should be 10",generated_list.length, 10);
        assertEquals("the length of the generated list row should be 0",generated_list[0].length, 0);
    }

    @Test // testing the array with size Zero
    public void testCreateNumberArray2dWithSizeZero() {
        double[][] list = new double[0][0];

        Number[][] generated_list = DataUtilities.createNumberArray2D(list);
        assertEquals("the length of the input list should be 0",list.length, 0);
        assertEquals("the length of the generated list should be 0",generated_list.length, 0);

    }

    @After
    public void tearDown() throws Exception {
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}