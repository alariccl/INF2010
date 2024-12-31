package Alphabet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Alphabet {

    /**
     * From the words contained in the dictionary of a fictitious language, find the lexical order of
     * the symbols composing the language.
     *
     * @param dictionary Contains all the words of a language
     * @return The lexicalOrder of the symbols composing this language
     */
    public static ArrayList<Character> lexicalOrder(String[] dictionary) {
        ArrayList<Character> lexicalOrder = new ArrayList<>();
        Graph<Character> graph = new Graph<Character>();

        for (int i = 0; i < dictionary.length - 1; i++) {
            String word1 = dictionary[i];
            String word2 = dictionary[i + 1];
            int minLength = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLength; j++) {
                char char1 = word1.charAt(j);
                char char2 = word2.charAt(j);
                if (char1 != char2) {
                    graph.connect(char1, char2);
                    break;
                }
            }
        }

        Queue<Vertex<Character>> queue = new LinkedList<>();
        for (Vertex<Character> vertex : graph.vertices) {
            if (vertex.indegree == 0) {
                queue.add(vertex);
            }
        }

        while (!queue.isEmpty()) {
            Vertex<Character> vertex = queue.poll();
            lexicalOrder.add(vertex.label);

            for (Vertex<Character> neighbor : vertex.toVertex) {
                neighbor.indegree--;
                if (neighbor.indegree == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return lexicalOrder;
    }
}