package KthSmallestElement;

import java.util.PriorityQueue;

public class KthSmallestElement {
    /**
     * Explication de votre complexité temporelle
     * La complexite temporelle est O(k log max(m,n)) car l'algorithme utilise une file de priorite (min-heap) pour
     * suivre les plus petits elements. Chaque insertion dans le tas necessite un temps de O(log max(m,n)).
     * L'algorithme effectue k iterations pour trouver le k-eme plus petit element, avec une operation d'extraction
     * et eventuellement une operation d'insertion dans le tas a chaque iteration. En combinant les deux, on obtient
     * une complexite temporelle de O(k log max(m,n)).
     *
     * Explication de votre complexité spatiale
     * La complexite spatiale est O(max(m,n)) car l'algorithme utilise une file de priorite (min-heap) pour
     * suivre les plus petits elements. La taille de la file de priorite est au plus max(m,n), donc la complexite
     * spatiale est O(max(m,n)).
     *
     */
    /** TODO Worst case
     *      Time complexity : O ( k log max(m,n) )
     *      Space complexity : O ( log max(m,n) )
     *
     * Returns the `k`th smallest element in `matrix`
     * @param matrix 2D table of shape M x N respecting the following rules
     *               matrix[i][j] <= matrix[i+1][j]
     *               matrix[i][j] <= matrix[i][j + 1]
     * @param k Index of the smallest element we want
     * @return `K`th smallest element in `matrix`, null if non-existent
     */
    static public <T extends Comparable<T>> T findKthSmallestElement(final T[][] matrix, final int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k < 0 || k >= matrix.length * matrix[0].length) {
            return null;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Element<T>> minHeap = new PriorityQueue<>();

        // Add the first element of each row to the heap
        for (int i = 0; i < rows; i++) {
            minHeap.add(new Element<>(matrix[i][0], i, 0));
        }

        Element<T> current = null;
        for (int i = 0; i <= k; i++) {
            current = minHeap.poll();
            if (current.col + 1 < cols) {
                minHeap.add(new Element<>(matrix[current.row][current.col + 1], current.row, current.col + 1));
            }
        }

        return current.value;
    }

    private static class Element<T extends Comparable<T>> implements Comparable<Element<T>> {
        T value;
        int row;
        int col;

        Element(T value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Element<T> other) {
            return this.value.compareTo(other.value);
        }
    }
}