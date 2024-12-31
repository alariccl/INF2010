import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryHeapTest {

    @Test
    public void testInsertAndDeleteMin() {
        int numItems = 10;
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        int[] expectedOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9, 37};

        for (int i = 37; i != 0; i = (i + 37) % numItems) {
            heap.insert(i);
        }

        for (int i = 0; i < numItems; i++) {
            assertEquals(expectedOrder[i], heap.deleteMin());
        }
    }

    @Test
    public void testFindMin() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Integer[]{5, 9, 3, 7, 2});
        assertEquals(2, heap.findMin());
    }

    @Test
    public void testFindMax() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Integer[]{5, 9, 3, 7, 2});
        assertEquals(9, heap.findMax());
    }

    @Test
    public void testIsEmpty() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        assertTrue(heap.isEmpty());
        heap.insert(1);
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testMakeEmpty() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Integer[]{5, 9, 3, 7, 2});
        heap.makeEmpty();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testHeapArray() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Integer[]{5, 9, 3, 7, 2});
        Integer[] expectedArray = {null, 2, 5, 3, 9, 7};
        for (int i = 1; i <= heap.currentSize; i++) {
            assertEquals(expectedArray[i], heap.array[i]);
        }
    }
}