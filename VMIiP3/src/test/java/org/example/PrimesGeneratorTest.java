package org.example;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimesGeneratorTest {

    @Test
    public void testGeneratePrimes() {
        PrimesGenerator primesGenerator = new PrimesGenerator(5);
        Iterator<Integer> iterator = primesGenerator.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(5, iterator.next());
        assertEquals(7, iterator.next());
        assertEquals(11, iterator.next());
        assertTrue(!iterator.hasNext());
    }

    @Test
    public void testReverseIterator() {
        PrimesGenerator primesGenerator = new PrimesGenerator(5);
        Iterator<Integer> reverseIterator = primesGenerator.reverseIterator();

        assertTrue(reverseIterator.hasNext());
        assertEquals(11, reverseIterator.next());
        assertEquals(7, reverseIterator.next());
        assertEquals(5, reverseIterator.next());
        assertEquals(3, reverseIterator.next());
        assertEquals(2, reverseIterator.next());
        assertTrue(!reverseIterator.hasNext());
    }
}
