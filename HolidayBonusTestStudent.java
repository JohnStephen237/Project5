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
 * Test cases for HolidayBonus class.
 * Covers various scenarios for calculating holiday bonuses.
 * 
 * @author Your Name
 */
public class HolidayBonusTestStudent {

    private double[][] dataSet1 = { { 10, 20, 30 }, { 15, 25 }, { 40, 50, 60 } };
    private double[][] dataSet2 = { { 5 }, { 10 }, { 15 } };
    private double[][] dataSet3 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

    @Before
    public void setUp() throws Exception {
        // Setup code if required
    }

    @After
    public void tearDown() throws Exception {
        // Cleanup code if required
    }

    /**
     * Test calculateHolidayBonus with varying data sets.
     */
    @Test
    public void testCalculateHolidayBonus() {
        try {
            // Test dataset 1
            double[] result1 = HolidayBonus.calculateHolidayBonus(dataSet1);
            assertEquals(9000.0, result1[0], .001);
            assertEquals(8000.0, result1[1], .001);
            assertEquals(15000.0, result1[2], .001);

            // Test dataset 2
            double[] result2 = HolidayBonus.calculateHolidayBonus(dataSet2);
            assertEquals(5000.0, result2[0], .001);
            assertEquals(7000.0, result2[1], .001);
            assertEquals(3000.0, result2[2], .001);

            // Test dataset 3
            double[] result3 = HolidayBonus.calculateHolidayBonus(dataSet3);
            assertEquals(9000.0, result3[0], .001);
            assertEquals(8000.0, result3[1], .001);
            assertEquals(7000.0, result3[2], .001);

        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    /**
     * Test calculateTotalHolidayBonus for various data sets.
     */
    @Test
    public void testCalculateTotalHolidayBonus() {
        assertEquals(32000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
        assertEquals(15000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2), .001);
        assertEquals(24000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet3), .001);
    }
}
