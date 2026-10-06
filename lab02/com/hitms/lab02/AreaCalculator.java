package com.hitms.lab02;

/**
 * Calculates areas of simple shapes.
 */
public final class AreaCalculator {

    /** Sample rectangle length used by the demo. */
    private static final int SAMPLE_LENGTH = 5;

    /** Sample rectangle width used by the demo. */
    private static final int SAMPLE_WIDTH = 4;

    /** Prevents instantiation of this utility class. */
    private AreaCalculator() {
    }

    /**
     * Returns the area of a rectangle.
     *
     * @param length the length of the rectangle
     * @param width the width of the rectangle
     * @return the area (length multiplied by width)
     */
    public static int calculateArea(final int length, final int width) {
        int area = length * width;
        return area;
    }

    /**
     * Demonstrates the renamed method.
     *
     * @param args command line arguments (not used)
     */
    public static void main(final String[] args) {
        System.out.println("Area of 5 x 4 rectangle: "
            + calculateArea(SAMPLE_LENGTH, SAMPLE_WIDTH));
    }
}
