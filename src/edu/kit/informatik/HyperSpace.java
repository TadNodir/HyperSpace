package edu.kit.informatik;

/**
 * This class serves as container for array of edges going out from each node of graph
 *
 * @author Nodirjon Tadjiev
 * @version 1.0
 */
public class HyperSpace {

    // represents an array of edges going out from each node of graph
    private int[] in;

    /**
     * Initialization of an array of edges
     *
     * @param in initializes an array of edges
     */
    public HyperSpace(int[] in) {
        this.in = in;
    }

    /**
     * @return returns an array of output edges
     */
    int[] getIn() {
        return in;
    }
}