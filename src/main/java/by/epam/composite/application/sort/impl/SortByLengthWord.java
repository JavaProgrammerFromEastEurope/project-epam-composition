package by.epam.composite.application.sort.impl;

import by.epam.composite.application.sort.SortTemplate;

/**
 * Overriding Compare method of the Comparator interface
 * to compare two List<String> by elements length.
 */
public class SortByLengthWord implements SortTemplate<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();
    }
}