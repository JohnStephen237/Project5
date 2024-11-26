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
 * A utility class for working with two-dimensional ragged arrays of doubles. 
 * Provides methods for reading and writing arrays from/to files, calculating 
 * totals, averages, and finding specific values such as the highest or lowest 
 * values in rows, columns, and the entire array.
 * 
 * <p>
 * This class is designed to handle arrays where rows can have different lengths.
 * </p>
 * 
 * <p>
 * All methods are static and can be accessed without instantiating the class.
 * </p>
 * 
 * @author Johan Mbouwa Fokoua
 * @version 1.0
 */
public final class TwoDimRaggedArrayUtility {

    /**
     * Reads a two-dimensional ragged array of doubles from a file.
     * 
     * @param file the file to read from.
     * @return a two-dimensional ragged array of doubles.
     * @throws FileNotFoundException if the file cannot be found.
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        List<double[]> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                double[] row = Arrays.stream(line).mapToDouble(Double::parseDouble).toArray();
                data.add(row);
            }
        }
        return data.toArray(new double[0][]);
    }

    /**
     * Writes a two-dimensional ragged array of doubles to a file.
     * Each row is written on a separate line, with values separated by spaces.
     * 
     * @param data the two-dimensional array to write.
     * @param file the file to write to.
     * @throws FileNotFoundException if the file cannot be created or opened.
     */
    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (double[] row : data) {
                for (int i = 0; i < row.length; i++) {
                    writer.print(row[i]);
                    if (i < row.length - 1) writer.print(" ");
                }
                writer.println();
            }
        }
    }

    /**
     * Calculates the total of all elements in the array.
     * 
     * @param data the two-dimensional array.
     * @return the total of all elements.
     */
    public static double getTotal(double[][] data) {
        return Arrays.stream(data).flatMapToDouble(Arrays::stream).sum();
    }

    /**
     * Calculates the average of all elements in the array.
     * 
     * @param data the two-dimensional array.
     * @return the average of all elements.
     */
    public static double getAverage(double[][] data) {
        return getTotal(data) / Arrays.stream(data).mapToInt(row -> row.length).sum();
    }

    /**
     * Calculates the total of the elements in a specific row.
     * 
     * @param data the two-dimensional array.
     * @param row the row index.
     * @return the total of the specified row.
     */
    public static double getRowTotal(double[][] data, int row) {
        return Arrays.stream(data[row]).sum();
    }

    /**
     * Calculates the total of the elements in a specific column.
     * Rows that do not contain the column index are ignored.
     * 
     * @param data the two-dimensional array.
     * @param col the column index.
     * @return the total of the specified column.
     */
    public static double getColumnTotal(double[][] data, int col) {
        return Arrays.stream(data)
                     .filter(row -> col < row.length)
                     .mapToDouble(row -> row[col])
                     .sum();
    }

    /**
     * Finds the highest value in a specific row.
     * 
     * @param data the two-dimensional array.
     * @param row the row index.
     * @return the highest value in the row.
     */
    public static double getHighestInRow(double[][] data, int row) {
        return Arrays.stream(data[row]).max().orElse(Double.NaN);
    }

    /**
     * Finds the index of the highest value in a specific row.
     * 
     * @param data the two-dimensional array.
     * @param row the row index.
     * @return the index of the highest value in the row.
     */
    public static int getHighestInRowIndex(double[][] data, int row) {
        double max = getHighestInRow(data, row);
        return IntStream.range(0, data[row].length).filter(i -> data[row][i] == max).findFirst().orElse(-1);
    }

    /**
     * Finds the lowest value in a specific row.
     * 
     * @param data the two-dimensional array.
     * @param row the row index.
     * @return the lowest value in the row.
     */
    public static double getLowestInRow(double[][] data, int row) {
        return Arrays.stream(data[row]).min().orElse(Double.NaN);
    }

    /**
     * Finds the index of the lowest value in a specific row.
     * 
     * @param data the two-dimensional array.
     * @param row the row index.
     * @return the index of the lowest value in the row.
     */
    public static int getLowestInRowIndex(double[][] data, int row) {
        double min = getLowestInRow(data, row);
        return IntStream.range(0, data[row].length).filter(i -> data[row][i] == min).findFirst().orElse(-1);
    }

    /**
     * Finds the highest value in a specific column.
     * Rows that do not contain the column index are ignored.
     * 
     * @param data the two-dimensional array.
     * @param col the column index.
     * @return the highest value in the column.
     */
    public static double getHighestInColumn(double[][] data, int col) {
        return Arrays.stream(data)
                     .filter(row -> col < row.length)
                     .mapToDouble(row -> row[col])
                     .max()
                     .orElse(Double.NaN);
    }

    /**
     * Finds the index of the highest value in a specific column.
     * Rows that do not contain the column index are ignored.
     * 
     * @param data the two-dimensional array.
     * @param col the column index.
     * @return the index of the highest value in the column.
     */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        double max = getHighestInColumn(data, col);
        return IntStream.range(0, data.length)
                        .filter(row -> col < data[row].length && data[row][col] == max)
                        .findFirst()
                        .orElse(-1);
    }

    /**
     * Finds the lowest value in a specific column.
     * Rows that do not contain the column index are ignored.
     * 
     * @param data the two-dimensional array.
     * @param col the column index.
     * @return the lowest value in the column.
     */
    public static double getLowestInColumn(double[][] data, int col) {
        return Arrays.stream(data)
                     .filter(row -> col < row.length)
                     .mapToDouble(row -> row[col])
                     .min()
                     .orElse(Double.NaN);
    }

    /**
     * Finds the index of the lowest value in a specific column.
     * Rows that do not contain the column index are ignored.
     * 
     * @param data the two-dimensional array.
     * @param col the column index.
     * @return the index of the lowest value in the column.
     */
    public static int getLowestInColumnIndex(double[][] data, int col) {
        double min = getLowestInColumn(data, col);
        return IntStream.range(0, data.length)
                        .filter(row -> col < data[row].length && data[row][col] == min)
                        .findFirst()
                        .orElse(-1);
    }

    /**
     * Finds the highest value in the entire array.
     * 
     * @param data the two-dimensional array.
     * @return the highest value in the array.
     */
    public static double getHighestInArray(double[][] data) {
        return Arrays.stream(data).flatMapToDouble(Arrays::stream).max().orElse(Double.NaN);
    }

    /**
     * Finds the lowest value in the entire array.
     * 
     * @param data the two-dimensional array.
     * @return the lowest value in the array.
     */
    public static double getLowestInArray(double[][] data) {
        return Arrays.stream(data).flatMapToDouble(Arrays::stream).min().orElse(Double.NaN);
    }
}
