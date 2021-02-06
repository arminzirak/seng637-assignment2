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
    @After
    public void tearDown() throws Exception {
    }
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}