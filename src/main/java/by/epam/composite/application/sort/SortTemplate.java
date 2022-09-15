package by.epam.composite.application.sort;

import java.util.Comparator;

/**
 * Defining the inherited appearance of SortTemplate from Comparator,
 * which are used by inherited sorting classes for Array.
 *
 * @param <T> the value Comparator (Array)
 */
@FunctionalInterface
public interface SortTemplate<T> extends Comparator<T> {
    int compare(T o1, T o2);
}
