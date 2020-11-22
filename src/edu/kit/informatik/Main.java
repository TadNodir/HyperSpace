package edu.kit.informatik;

/**
 * This class reads elements from given file and runs the program
 *
 * @author Nodirjon Tadjiev
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new ProgramTester("The link to the text file is not provided.");
            }
            // Assigns the first element of command line, which is path to file, to string
            String theFile = args[0];
            if (theFile.length() < 4) {
                throw new ProgramTester("The link to the text file is too short.");
            }
            if (!theFile.substring(theFile.length() - 3).equals("txt")) {
                throw new ProgramTester("The link to the text file is false.");
            }
            // Assigns an array in text file to string array after reading it
            String[] fileElements = Terminal.readFile(theFile);

            // Creates an object of Planet class to run its functions
            Planet planet = new Planet(fileElements);

            // Running an estimate function from Planet class
            planet.estimate();

            // Running countDroids function from Planet class
            planet.countDroids();
        } catch (ProgramTester p) {
            Terminal.printError(p.getMessage());
        }
    }
}