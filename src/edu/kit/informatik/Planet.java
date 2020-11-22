package edu.kit.informatik;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains the whole functionality of program,
 * which is represented as adjacent matrix. The program counts the needed amount of droids
 * by counting an amount of columns which consist only of zeroes. The data is taken from text data,
 * which is given by user in command line.
 *
 * @author Nodirjon Tadjiev
 * @version 1.0
 */
class Planet {
    // regular expression of any number
    private String NUMBER = "[-+]?[0-9]*\\.?[0-9]+$";

    // Representation of adjacent matrix
    private int[][] adjacent;

    // Representation of arrays starting from 2nd element for each row of file data.
    private List<HyperSpace> bridgeList = new ArrayList<>();

    // Representation of transposed adjacent matrix
    private int[][] transposed;

    // pattern to compile a regular expression of number representation
    private Pattern pattern = Pattern.compile(NUMBER);

    /**
     * Initializing elements needed for representation of adjacent matrix
     *
     * @param elements array of string elements taken from data file
     */
    public Planet(String[] elements) throws ProgramTester {

        Matcher matcher = pattern.matcher(elements[0]);
        if (!matcher.matches()) {
            throw new ProgramTester("the first input is not a number");
        }
        int length = Integer.parseInt(elements[0]);
        if (length != elements.length - 1) {
            throw new ProgramTester("an amount of hyper space routes must be equal to an amount of rows - 1.");
        }
        for (int i = 1; i < length + 1; i++) {
            String strElements = elements[i];
            // Creates new string array out of elements of file, which ignores spaces
            String[] newString = strElements.split("\\u0020");
            //Creates from this string array a new array, including all elements
            String[] bridge = new String[Integer.parseInt(newString[0])];
            // Creates an integer array consisting elements starting from 2nd position in file for each row
            int[] intElements = new int[Integer.parseInt(newString[0])];
            for (int k = 0; k < bridge.length; k++) {
                // Parses this string elements into integer elements
                bridge[k] = newString[k + 1];
                Matcher checkString = pattern.matcher(bridge[k]);
                if (!checkString.matches()) {
                    throw new ProgramTester("hyper space is not a number.");
                }
                intElements[k] = Integer.parseInt(bridge[k]);
            }
            // These integer elements are added to array list
            // E.g. [1], [2], [], [1] for first example. Later bridgeList
            bridgeList.add(new HyperSpace(intElements));
        }
        // Creates an adjacent matrix with the size of very first element of text data
        adjacent = new int[length][length];
    }

    /*
     * Turns the element of matrix into 1, only if the number in bridgeList and its index match
     * y and x positions in matrix respectively
     */
    public void estimate() {
        // Converting bridgeList to Object array for easier approach
        Object[] array = bridgeList.toArray();
        for (int i = 0; i < array.length; i++) {
            // Converting each element of object array to HyperSpace object
            Object o = array[i];
            HyperSpace s = (HyperSpace) o;

            for (int x = 0; x < this.adjacent.length; x++) {
                for (int y = 0; y < this.adjacent[x].length; y++) {
                    // looping through arrays of each hyper space
                    for (int v = 0; v < s.getIn().length; v++) {
                        // if the number in bridgeList array and its index match
                        // y and x positions in matrix respectively, set the number to 1
                        if (s.getIn()[v] == y && x == i) {
                            adjacent[x][y] = 1;
                        }
                    }
                }
            }
        }
    }


    // Transposing an adjacent matrix to loop easily through columns
    private void transpose() {
        transposed = new int[adjacent.length][adjacent.length];
        for (int x = 0; x < this.adjacent.length; x++) {
            for (int y = 0; y < this.adjacent[x].length; y++) {
                transposed[x][y] = adjacent[y][x];
            }
        }
    }

    /*
     * Counts the amount of droids, what is equal to the number of columns of matrix,
     * where all elements equal to 0
     */
    public void countDroids() {
        // transpose matrix for easier looping through columns
        transpose();
        // represents an amount of 0s in each column
        int k;
        // represents an amount of droids
        int droid = 0;
        // looping through transposed matrix
        for (int[] ints : this.transposed) {
            // initialization of amount of 0s after moving to next column
            k = 0;
            for (int anInt : ints) {
                // if the number of position x, y in matrix is equal to 0, count 0s
                if (anInt == 0) {
                    k++;
                }
            }
            // if the amount of 0s in column is equal to its size, count droids
            if (k == transposed.length) {
                droid++;
            }
        }
        Terminal.printLine(droid);
    }
}