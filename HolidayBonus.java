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

import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * The HolidayBonus class provides methods to calculate holiday bonuses 
 * for a district of stores based on sales data. Bonuses are calculated 
 * for each store in each category based on the highest, lowest, or other 
 * sales values.
 * 
 * <p>
 * It also provides a method to compute the total holiday bonuses for the 
 * district. The class uses constants for the bonus amounts for the highest, 
 * lowest, and other stores.
 * </p>
 * 
 * <p>
 * This class depends on the TwoDimRaggedArrayUtility class to perform operations 
 * on the two-dimensional array of sales data.
 * </p>
 * 
 * @author Johan Mbouwa Fokoua
 * @version 1.0
 */
public class HolidayBonus {

    /**
     * Bonus amount for the store with the highest sales in a category.
     */
    public static final double HIGH_BONUS = 5000.0;

    /**
     * Bonus amount for the store with the lowest sales in a category.
     */
    public static final double LOW_BONUS = 1000.0;

    /**
     * Bonus amount for stores with sales that are neither the highest nor the lowest.
     */
    public static final double OTHER_BONUS = 2000.0;

    /**
     * Calculates the holiday bonuses for each store in the district.
     * 
     * @param data the two-dimensional array of sales data where each row represents a store
     *             and each column represents a category.
     * @return an array of doubles representing the holiday bonuses for each store.
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        for (int col = 0; col < getMaxColumns(data); col++) {
            int highest = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            int lowest = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);

            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length) {
                    if (row == highest) {
                        bonuses[row] += HIGH_BONUS;
                    } else if (row == lowest) {
                        bonuses[row] += LOW_BONUS;
                    } else {
                        bonuses[row] += OTHER_BONUS;
                    }
                }
            }
        }

        return bonuses;
    }

    /**
     * Calculates the total holiday bonuses for all stores in the district.
     * 
     * @param data the two-dimensional array of sales data where each row represents a store
     *             and each column represents a category.
     * @return the total holiday bonuses for the district.
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        return Arrays.stream(calculateHolidayBonus(data)).sum();
    }

    /**
     * Helper method to determine the maximum number of columns in the sales data.
     * 
     * @param data the two-dimensional array of sales data.
     * @return the maximum number of columns across all rows.
     */
    private static int getMaxColumns(double[][] data) {
        return Arrays.stream(data).mapToInt(row -> row.length).max().orElse(0);
    }
}
