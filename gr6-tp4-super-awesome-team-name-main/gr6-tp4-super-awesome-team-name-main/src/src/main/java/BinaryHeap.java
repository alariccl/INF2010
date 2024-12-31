public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {

    private static final int DEFAULT_CAPACITY = 10;

    public int currentSize;
    public AnyType[] array;
    private boolean isMaxHeap;

    /**
     * Construct the binary heap.
     * 
     * @param isMaxHeap true if is a max heap, false if is a min heap.
     */
    public BinaryHeap(boolean isMaxHeap) {
        this(DEFAULT_CAPACITY, isMaxHeap);
        this.isMaxHeap = isMaxHeap;
    }

    /**
     * Construct the binary heap.
     * 
     * @param capacity  the capacity of the binary heap.
     * @param isMaxHeap true if is a max heap, false if is a min heap.
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap(int capacity, boolean isMaxHeap) {
        this.isMaxHeap = isMaxHeap;
        currentSize = 0;
        array = (AnyType[]) new Comparable[capacity + 1];
    }

    /**
     * Construct the binary heap given an array of items.
     * 
     * @param items     the array of items.
     * @param isMaxHeap true if is a max heap, false if is a min heap.
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap(AnyType[] items, boolean isMaxHeap) {
        this.isMaxHeap = isMaxHeap;
        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (AnyType item : items)
            array[i++] = item;
        buildHeap();
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * 
     * @param x the item to insert.
     */
    public void insert(AnyType x) {
        if (currentSize == array.length - 1)
            enlargeArray(array.length * 2 + 1);

        if (this.isMaxHeap) {
            insertMaxHeap(x);
        } else {
            insertMinHeap(x);
        }
    }

    /**
     * Internal Mehtod to insert into a min heap.
     * 
     * @param x the item to insert.
     */
    private void insertMinHeap(AnyType x) {
        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;
    }

    /**
     * Internal Mehtod to insert into a max heap.
     * 
     * @param x the item to insert.
     */
    private void insertMaxHeap(AnyType x) {
        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) > 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;
    }

    /**
     * Internal method to enlarge the array.
     * 
     * @param newSize the new size.
     */
    @SuppressWarnings("unchecked")
    private void enlargeArray(int newSize) {
        AnyType[] old = array;
        array = (AnyType[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++)
            array[i] = old[i];
    }

    /**
     * Find the smallest item in the priority queue.
     * 
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType findMin() {
        if (isEmpty())
            throw new UnderflowException();

        return array[1];
    }

    /**
     * Find the biggest item in the priority queue.
     * 
     * @return the biggest item, or throw an UnderflowException if empty.
     */
    public AnyType findMax() {
        if (isEmpty())
            throw new UnderflowException();

        AnyType maxItem = array[1];

        for (int i = currentSize / 2 + 1; i <= currentSize; i++) {
            if (array[i].compareTo(maxItem) > 0) {
                maxItem = array[i];
            }
        }

        return maxItem;
    }

    /**
     * Remove the smallest item from the priority queue.
     * 
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType deleteMin() {
        if (isEmpty())
            throw new UnderflowException();

        AnyType minItem = findMin();

        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    /**
     * Remove the biggest item from the priority queue.
     * 
     * @return the biggest item, or throw an UnderflowException if empty.
     */
    public AnyType deleteMax() {
        if (isEmpty())
            throw new UnderflowException();

        AnyType maxItem = findMax();

        array[1] = array[currentSize--];
        percolateDown(1);

        return maxItem;
    }

    /**
     * Internal method to percolate down in the heap.
     * 
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown(int hole) {
        if (this.isMaxHeap) {
            percolateDownMaxHeap(hole);
        } else {
            percolateDownMinHeap(hole);
        }
    }

    /**
     * Internal method to percolate down in a min heap.
     * 
     * @param hole the index at which the percolate begins.
     */
    private void percolateDownMinHeap(int hole) {
        int child;
        AnyType tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize &&
                    array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }

        array[hole] = tmp;
    }

    /**
     * Internal method to percolate down in a max heap.
     * 
     * @param hole the index at which the percolate begins.
     */
    private void percolateDownMaxHeap(int hole) {
        int child;
        AnyType tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize &&
                    array[child + 1].compareTo(array[child]) > 0)
                child++;
            if (array[child].compareTo(tmp) > 0)
                array[hole] = array[child];
            else
                break;
        }

        array[hole] = tmp;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    /**
     * Test if the priority queue is logically empty.
     * 
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty() {
        currentSize = 0;
    }

    /**
     * Print the heap array.
     */
    public void printHeap() {
        for (int i = 1; i <= currentSize; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Internal method for heapsort.
     * 
     * @param i the index of an item in the heap.
     * @return the index of the left child.
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Internal method to swap two elements in an array.
     * 
     * @param a      an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static <AnyType extends Comparable<? super AnyType>> void swapReferences(AnyType[] a, int index1,
            int index2) {
        AnyType tmp = a[index1];
        a[index1] = a[index2];
        a[index2] = tmp;
    }

    /**
     * Internal method for heapsort
     * 
     * @param a: un tableau dont les éléments sont de type Comparable.
     * @int i: la position de l’élément à percoler.
     * @int n: la position après le dernier élément du monceau.
     */
    private static <AnyType extends Comparable<? super AnyType>> void percDown(AnyType[] a, int i, int n) {
        int child;
        AnyType tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0)
                child++;
            if (tmp.compareTo(a[child]) < 0)
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
    }

    /**
     * Standard heapsort.
     * 
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>> void heapsort(AnyType[] a) {
        for (int i = a.length / 2; i >= 0; i--) /* construire le monceau */
            percDown(a, i, a.length);
        for (int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0, i); /*
                                      * permuter le maximum (racine)
                                      * et dernière élément du monceau
                                      */
            percDown(a, 0, i);
        }
    }

    /**
     * Standard heapsort for strings.
     * 
     * @param a an array of strings.
     */
    public static void heapsortString(String[] a) {
        for (int i = a.length / 2; i >= 0; i--) /* construire le monceau */
            percDownString(a, i, a.length);
        for (int i = a.length - 1; i > 0; i--) {
            swapReferences(a, 0, i); /*
                                      * permuter le maximum (racine)
                                      * et dernière élément du monceau
                                      */
            percDownString(a, 0, i);
        }
    }

    /**
     * Internal method for heapsort
     * 
     * @param a an array of Comparable items.
     * @param i the position of the element to percolate.
     * @param n the position after the last element of the heap.
     */
    private static void percDownString(String[] a, int i, int n) {
        int child;
        String tmp;
        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && countA(a[child]) < countA(a[child + 1]))
                child++;
            if (countA(tmp) < countA(a[child]))
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
    }

    /**
     * Count the number of 'a' in a string.
     * 
     * @param str the string.
     * @return the number of 'a' in the string.
     */
    private static int countA(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a') {
                count++;
            }
        }
        return count;
    }

    /**
     * Find the Kth largest element in an array using a heap.
     * 
     * @param array the array of integers.
     * @param k     the rank of the element to find.
     * @return the Kth largest element.
     */
    public static <AnyType extends Comparable<? super AnyType>> AnyType findKthLargestInt(AnyType[] array, int k) {
        heapsort(array);
        return array[array.length - k];
    }

    /**
     * Find the Qth largest string based on the frequency of the letter 'a'.
     * 
     * @param array the array of strings.
     * @param q     the rank of the string to find.
     * @return the Qth largest string based on 'a' frequency.
     */
    public static String findQthLargestString(String[] array, int q) {
        heapsortString(array);
        return array[array.length - q];
    }

    // Test program
    public static void main(String[] args) {
        // Part 1 :
        System.out.println("Part 1");

        Integer[] array = new Integer[] { 5, 6, 7, 2, 43, 22, 34, 90, 9, 10 };
        System.out.println("Origninal array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Min Heap:");
        BinaryHeap<Integer> h = new BinaryHeap<>(array, false);
        h.printHeap();
        
        System.out.println("Min Heap after inserting 1:");
        h.insert(1);
        h.printHeap();

        System.out.println("Max Heap:");
        BinaryHeap<Integer> h2 = new BinaryHeap<>(array, true);
        h2.printHeap();
        
        System.out.println("Max Heap after inserting 100:");
        h2.insert(100);
        h2.printHeap();
        System.out.println();

        // Part 2 :
        System.out.println("Part 2");

        Integer[] array1 = new Integer[25];
        Integer[] array2 = new Integer[25];
        Integer[] array3 = new Integer[25];
        java.util.Random rand = new java.util.Random();

        for (int i = 0; i < 25; i++) {
            array1[i] = rand.nextInt(100);
            array2[i] = rand.nextInt(100);
            array3[i] = rand.nextInt(100);
        }

        System.out.println("Original array 1:");
        for (int i : array1) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        BinaryHeap.heapsort(array1);
        System.out.println("Sorted array 1:");
        for (int i : array1) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Original array 2:");
        for (int i : array2) {
            System.out.print(i + " ");
        }
        System.out.println();
       
        BinaryHeap.heapsort(array2);
        System.out.println("Sorted array 2:");
        for (int i : array2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        System.out.println("Original array 3:");
        for (int i : array3) {
            System.out.print(i + " ");
        }
        System.out.println();

        BinaryHeap.heapsort(array3);
        System.out.println("Sorted array 3:");
        for (int i : array3) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        // Part 3 :
        System.out.println("Part 3");

        Integer[] intArray = { 5, 1, 2, 1, 4, 3, 2, 5, 5, 6, 7, 8, 8, 9, 9, 10, 11, 43, 43, 23, 1, 21, 3, 34, 56, 70 };
        int k = 2;
        System.out.println("Original int array:");
        for (int i : intArray) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("The " + k + "th largest element is: " + findKthLargestInt(intArray, k));

        String[] strArray = { "aaa", "abc", "aab", "AaaaaAb", "zswaaaaa", "aaa" };
        int q = 2;
        System.out.println("Original string array:");
        for (String str : strArray) {
            System.out.print(str + " ");
        }
        System.out.println();

        System.out.println(
                "The " + q + "th largest string based on 'a' frequency is: " + findQthLargestString(strArray, q));
    }
}

/**
 * Exception thrown to indicate that an operation has been attempted on an empty
 * data structure
 * where such an operation is not allowed.
 */
class UnderflowException extends RuntimeException {
    public UnderflowException() {
        super();
    }

    public UnderflowException(String message) {
        super(message);
    }
}
