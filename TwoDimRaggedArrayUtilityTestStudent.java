/*
 * Class: CMSC203 
 * Instructor: Professor Thai
 * Description: Project 5
 * Due: 11/25/2024
 * Platform/compiler: Visual Studio code
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here:Johan Mbouwa Fokoua
*/


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for TwoDimRaggedArrayUtility class.
 * Covers various scenarios for working with ragged arrays.
 * 
 * @author Your Name
 */
public class TwoDimRaggedArrayUtilityTestStudent {

    private double[][] dataSet1 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };
    private double[][] dataSet2 = { { 10, 20 }, { 30 }, { 40, 50, 60 } };
    private double[][] dataSet3 = { { 5 }, { 10, 15 }, { 20, 25, 30 } };

    @Before
    public void setUp() throws Exception {
        // Setup code if required
    }

    @After
    public void tearDown() throws Exception {
        // Cleanup code if required
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0), .001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), .001);
        assertEquals(30.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 2), .001);
    }

    @Test
    public void testGetColumnTotal() {
        assertEquals(12.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), .001);
        assertEquals(37.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet3, 1), .001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 3), .001);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), .001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2), .001);
        assertEquals(60.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 2), .001);
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0), .001);
        assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 1), .001);
        assertEquals(30.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 1), .001);
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), .001);
        assertEquals(60.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet2), .001);
        assertEquals(30.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet3), .001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), .001);
        assertEquals(10.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet2), .001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet3), .001);
    }

    @Test
    public void testReadFileAndWriteToFile() {
        try {
            File tempFile = new File("testFile.txt");
            TwoDimRaggedArrayUtility.writeToFile(dataSet1, tempFile);
            double[][] readData = TwoDimRaggedArrayUtility.readFile(tempFile);
            assertArrayEquals(dataSet1, readData);
            tempFile.delete(); // Clean up
        } catch (Exception e) {
            fail("File operations should not throw exceptions.");
        }
    }
}
