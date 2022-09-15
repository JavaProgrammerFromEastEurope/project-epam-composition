package by.epam.composite.application.util;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * The <em><b>Input</b></em> class
 * - provides methods for efficient console input.
 */
public final class Input {

    private static final Scanner scanner = new Scanner(in);
    private static Object inputObject;

    /**
     * Gives the ability to input the required int object
     */
    public static int getInteger() {
        if (scanner.hasNextInt()) {
            inputObject = scanner.nextInt();
            if ((int) inputObject >= 0) {
                return (int) inputObject;
            }
        }
        getWarningString();
        return getInteger();
    }

    /**
     * Gives the ability to input the required double object
     */
    public static double getDouble() {
        if (scanner.hasNextDouble()) {
            inputObject = scanner.nextDouble();
            if ((double) inputObject >= 0) {
                return (double) inputObject;
            }
        }
        getWarningString();
        return getDouble();
    }

    public static double getDouble(String message) {
        out.println(message);
        return getDouble();
    }
    /**
     * Gives the ability to input the required int object
     *
     * @param message - informed the user before input int object
     */
    public static int getInteger(String message) {
        out.println(message);
        return getInteger();
    }

    public static String getString() {
        return scanner.next();
    }

    /**
     * Gives the ability to input the required string object
     *
     * @param message - informed the user before input the string object
     */
    public static String getString(String message) {
        out.println(message);
        return getString();
    }

    /**
     * Gives the ability to input the required int object (below zero)
     */
    public static int anyIntInitialize() {
        if (scanner.hasNextInt()) {
            inputObject = scanner.nextInt();
            return (int) inputObject;
        }
        getWarningString();
        return anyIntInitialize();
    }

    /**
     * Gives the ability to input the required string object
     *
     * @param message - informed the user before input any integer object
     */
    public static int anyIntInitialize(String message) {
        out.println(message);
        return anyIntInitialize();
    }

    public static int inputPosition(int bound) {
        if (scanner.hasNextInt()) {
            inputObject = scanner.nextInt();
            if ((int) inputObject > 0
                    && (int) inputObject <= bound)
                return (int) inputObject;
        }
        getWarningString();
        return inputPosition(bound);
    }

    public static int inputPosition(int start, int bound) {
        if (scanner.hasNextInt()) {
            inputObject = scanner.nextInt();
            if ((int) inputObject >= start
                    && (int) inputObject <= bound)
                return (int) inputObject;
        }
        getWarningString();
        return inputPosition(start, bound);
    }

    public static int inputPosition(int bound, String message) {
        out.printf("%s", message);
        return inputPosition(bound);
    }

    public static int inputPosition(int start, int bound, String message) {
        out.printf("%s", message);
        return inputPosition(start, bound);
    }

    /**
     * Print warning message
     */
    private static void getWarningString() {
        if (inputObject == null) {
            inputObject = scanner.next();
        }
        String repeatInput = "Please enter the correct data: ";
        String warningMessage = "this is an invalid value!";
        out.printf(" %s - %s %n %s", inputObject, warningMessage, repeatInput);
        inputObject = null;
    }
}