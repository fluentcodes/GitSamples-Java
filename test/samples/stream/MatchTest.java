package samples.stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Test;

/**
 * Beispielprogramm demonstriert verschiedene Matching-Strategien.
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class MatchTest {
    final static List<String> NAMES = Arrays.asList("Tim", "Tom", "Micha");
    final static Predicate<String> START_WITH_T = str -> str.toUpperCase().startsWith("T");
    @Test
    public void allMatch() {
        final boolean found = NAMES.stream().allMatch(START_WITH_T);
        assertFalse(found);
    }

    @Test
    public void noneMatch() {
        final boolean found = NAMES.stream().noneMatch(START_WITH_T);
        assertFalse(found);
    }

    @Test
    public void anyMatch() {
        final boolean found = NAMES.stream().anyMatch(START_WITH_T);
        assertTrue(found);
    }
}