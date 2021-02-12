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

    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArrayNullInput(){
        DataUtilities.createNumberArray(null);
    }

    @Test
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


    @Test(expected = IllegalArgumentException.class)
    public void testCreateNumberArray2dNullInput(){
        DataUtilities.createNumberArray2D(null);
    }

    @Test
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

    @After
    public void tearDown() throws Exception {
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}