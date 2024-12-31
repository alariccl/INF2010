public class findNonDuplicate {
    /**
     * Complexité temporelle :
     * - La boucle for traverse le tableau avec un saut de 2, donc elle fait  n/2  itérations au maximum.
     * Ceci reste asymptotiquement O(n) dans le pire cas, car on vérifie chaque paire jusqu’à l’élément unique.
     * - Pire cas : L’élément unique est à la fin du tableau, forçant la boucle à vérifier toutes les paires
     * La complexité reste O(n).
     * Cas moyen : En moyenne, l’élément unique est situé quelque part au milieu du tableau, mais la complexite
     * reste O(n), car elle dépend du nombre total d’éléments.
     * - Complexité spatiale :
     * Nous n’utilisons aucun espace supplémentaire, donc la complexité spatiale est  O(1)  en pire comme en moyen cas.
    */
    public static Object findNonDuplicateIterativeLinear(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        for (int i = 0; i < nums.length; i += 2) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }

        return null;
    }

    /**
     * Complexité temporelle :
     * - Chaque itération réduit la recherche par moitié, donc la complexité est O(\log(n)) dans le pire et
     * le moyen cas.
     * - Pire cas et cas moyen : L’élément unique est positionné à n’importe quel endroit dans le tableau,
     * et l’algorithme utilise la recherche binaire pour réduire l’espace de recherche.
     * Complexité spatiale:
     * - Aucun espace supplémentaire n’est utilisé à part les variables de suivi (left, right et mid),
     * donc la complexité spatiale est O(1) dans tous les cas.
     */
    public static Object findNonDuplicateIterative(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Assurer que mid est pair pour aligner la paire
            if (mid % 2 == 1) mid--;

            // Si la paire est correcte, l'élément unique est dans la seconde moitié
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    /**
     *Complexité temporelle :
     * - La récursivité divise l’espace de recherche en deux à chaque appel, donc la complexité temporelle est
     * O(log(n)) en pire et moyen cas, similaire à la version itérative.
     * - Pire cas et cas moyen : La fonction de recherche utilise la récursion pour atteindre O(log(n)) appels.
     * Complexité spatiale :
     * - Contrairement à la version itérative, chaque appel récursif consomme de l’espace sur la pile d’appel.
     * Dans le pire des cas, il y a O(log(n)) appels imbriqués, donc la complexité spatiale est O(log(n)).
     */
    public static Object findNonDuplicateRecursive(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0) return null;

        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        if (mid % 2 == 1) mid--;

        if (nums[mid] == nums[mid + 1]) {
            return findNonDuplicateRecursive(nums, mid + 2, right);
        } else {
            return findNonDuplicateRecursive(nums, left, mid);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 5, 6, 6};
        int[] nums1 = {1};
        int[] nums2 = {};
        System.out.println(findNonDuplicateIterativeLinear(nums2));
        System.out.println(findNonDuplicateIterative(nums2));
        System.out.println(findNonDuplicateRecursive(nums2, 0, nums2.length - 1));
    }
}
