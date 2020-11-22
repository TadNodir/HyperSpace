package edu.kit.informatik;

public class ProgramTester extends Exception {
    /**
     * Serial version uid for serialization purposes
     */
    private static final long serialVersionUID = 228856233157699880L;

    /**
     * A new Semantic exception, with corresponding message.
     *
     * @param message some detailed error message (null is not allowed)
     */
    public ProgramTester(String message) {
        super(message);
    }
}
