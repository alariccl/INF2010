import java.util.*;
import java.util.HashMap;

public final class Interview {

    /**
     * Expliquez votre complexité temporelle et spatiale à l'aide de commentaire
     * dans le code
     * n représente le nombre de charactère de `phrase` et m le nombre de charactère
     * de `stopwords`
     * Indiquez les équivalences telles que O(n + 1 + m + 1) => O(n+m) et O(2n+3m)
     * => O(n+m) lorsque possible
     *
     ** TODO Justify Time Complexity : Average Case O(n+m)
    // 1. Time Complexity :
     // La 1ère boucle insère les stopwords dans le HashSet, avec une complexité de O(m), avec m le nombre de stopwords.
     // La 2ème boucle parcourt les mots de la phrase, ce qui donne une complexité de O(n), avec n la taille de la phrase.
     // Ensuite, l'insertion et la mise à jour des occurrences dans le HashMap se font en O(1).
     // Enfin, la dernière boucle cherche le mot le plus fréquent. Elle parcourt les "k" mots "unique" de la phrase, avec une complexité de O(k). Dans le pire des cas, on peut considérer k proche de n, soit k ≈ n.
     // Donc, la complexité temporelle est O(n + m), car les opérations sont effectuées de manière indépendante. Leur contribution se combine, ce qui donne donc O(n + m).
    //    ** TODO Justify Space Complexity : Worst Case O(n+m)
    // 2. Space Complexity :
     // - La majeure partie de la mémoire utilisée provient du HashSet, qui stocke tous les stopwords. Cela prend O(m) d'espace, où m est le nombre de stopwords.
     // - Le HashMap quand a lui enregistre les occurrences des mots de la phrase. Dans le pire des cas, où chaque mot est unique, il occupe O(n) d'espace, où n est le nombre total de mots dans la phrase.
     // Ainsi, la quantité totale de mémoire requise est la somme de l'espace utilisé par le HashSet et le HashMap, ce qui donne une complexité spatiale globale de O(n + m).
     
     * @param phrase    String containing a sequence of words separated by a space
     * @param stopwords String array containing all the stop words
     * @return Pair containing two elements, first being the most common word not in
     *         the stop words,
     *         second being the number of occurences of this word
     */
    public static Pair findMostCommonValidWord(String phrase, String[] stopwords) {
        Set<String> setOfStopWords = new HashSet<>();
        for (String stopword : stopwords) {
            setOfStopWords.add(stopword.toLowerCase());}
    
            String[] wordsInSentence = phrase.split(" ");
            Map<String, Integer> wordOccurrences = new HashMap<>();
    
            for (String word : wordsInSentence) {
                String wordInLowerCase = word.toLowerCase();
                if (!setOfStopWords.contains(wordInLowerCase)) {
                    wordOccurrences.put(wordInLowerCase, wordOccurrences.getOrDefault(wordInLowerCase, 0) + 1);
                }
            }
    
            String mostRecurrentWord = null;
            int mostRecurrentWordOccurrences = 0;
    
            for(Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
                String word = entry.getKey();
                int occurrences = entry.getValue();
    
                if((occurrences == mostRecurrentWordOccurrences && word.compareTo(mostRecurrentWord) < 0) || (occurrences > mostRecurrentWordOccurrences) ) {
                    mostRecurrentWord = word;
                    mostRecurrentWordOccurrences = occurrences;
                }
            }
    
            if (phrase.isEmpty()) {
                return new Pair(null, null);
            }
    
            if(mostRecurrentWord == null) {
                return new Pair(null , null);
            }
    
            return new Pair(mostRecurrentWord, mostRecurrentWordOccurrences);
        }
    }
