package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class DataUtilitiesTest {
    private DataUtilities dataUtilities;
    @BeforeClass public static void setUpBeforeClass()
            throws Exception {
    }
    @Before
    public void setUp() throws Exception {

    }

    @Test(expected = IllegalArgumentException.class) //testing the null input
    public void testCreateNumberArrayNullInput(){
        DataUtilities.createNumberArray(null);
    }

    @Test // testing the equivalence of the input and output values
    public void testCreateNumberArray() {
        double[] list = new double[10];
        for (int i = 0; i < 10; i ++){
            list[i] = i  * 1.1;
        }
        Number[] generated_list = DataUtilities.createNumberArray(list);
        assertEquals(list.length, 10);
        assertEquals(generated_list.length, 10);
        for (int i = 0; i < 10; i++){
            assertEquals(list[i], generated_list[i]);
        }
    }

    @Test // testing the array with length of one
    public void testCreateNumberArrayWithSizeOne() {
        double[] list = new double[1];
        list[0] = 5;
        Number[] generated_list = DataUtilities.createNumberArray(list);
        assertEquals(generated_list.length, 1);
        assertEquals(5, generated_list[0]);
    }

    @Test // testing the array with length of zero
    public void testCreateNumberArrayWithSizeZero() {
        double[] list = new double[0];
        Number[] generated_list = DataUtilities.createNumberArray(list);
        assertEquals(0, generated_list.length);
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
        assertEquals(list.length, 10);
        assertEquals(generated_list.length, 10);
        for (int i = 0; i < 10; i++){
            for(int j = 0 ; j < 10; j++){
                assertEquals(list[i][j], generated_list[i][j]);
            }
        }
    }

    @Test // testing the array with One Row
    public void testCreateNumberArray2dWithOneRow() {
        double[][] list = new double[1][10];
        for(int i=0 ; i<10 ;i++)
        {
            list[0][i] = i  * 1.1;
        }
        Number[][] generated_list = DataUtilities.createNumberArray2D(list);
        assertEquals(generated_list.length, 1);
        assertEquals(generated_list[0].length, 10);
        for(int i=0 ; i<10 ;i++)
        {
            assertEquals(list[0][i], generated_list[0][i]);
        }
    }

    @Test // testing the array with One Column
    public void testCreateNumberArray2dWithOneColumn() {
        double[][] list = new double[10][1];
        for(int i=0 ; i<10 ;i++)
        {
            list[i][0] = i  * 1.1;
        }
        Number[][] generated_list = DataUtilities.createNumberArray2D(list);
        assertEquals(generated_list.length, 10);
        assertEquals(generated_list[0].length, 1);
        for(int i=0 ; i<10 ;i++)
        {
            assertEquals(list[i][0], generated_list[i][0]);
        }
    }

    @Test // testing the array with Zero Column
    public void testCreateNumberArray2dWithZeroColumn() {
        double[][] list = new double[10][0];
        Number[][] generated_list = DataUtilities.createNumberArray2D(list);
        assertEquals(0, generated_list[0].length);

    }

    @Test // testing the array with Zero Row
    public void testCreateNumberArray2dWithZeroRow() {
        double[][] list = new double[0][10];
        Number[][] generated_list = DataUtilities.createNumberArray2D(list);
        assertEquals(0,generated_list.length);
    }

    @After
    public void tearDown() throws Exception {
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}