package collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Beispielprogramm zur Demonstration der Methode removeIf()
 * 
 * @author Michael Inden
 * 
 * Copyright 2014 by Michael Inden 
 */
public class CollectionsRemoveIfExample 
{
	@Test
	public void removeIfEmpty() {
	   final List<String> list = Arrays.asList("A","", "B");
		 assertEquals(Arrays.asList("A", "", "B"), list);
	   list.removeIf(String::isEmpty);
	   assertEquals(Arrays.asList("A", "B"), list);
	}

	@Test
	public void removeIfTrimmedEmpty() {
		final List<String> list = Arrays.asList("A", "", "B");
		assertEquals(Arrays.asList("A", "", "B"), list);
		list.removeIf(str -> str.trim().isEmpty());
		assertEquals(Arrays.asList("A", "B"), list);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void removeIfEmptyNull_UnsupportedOperationException() {
		final List<String> list = Arrays.asList("A", null, "B");
		assertEquals(Arrays.asList("A", null, "B"), list);
		list.removeIf(String::isEmpty);
	}
}