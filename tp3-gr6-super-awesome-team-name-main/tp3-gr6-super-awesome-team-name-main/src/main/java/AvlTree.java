public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T>{

    /**
     * Adds a new value to the AVL tree and balances it if necessary
     * @param value the value to add
     */
    @Override
    public void add(T value) {
        this.root = add(value, this.root);
    }

    protected BinaryNode<T> add(T value, BinaryNode<T> curNode) {
        // TODO
        if (curNode == null) 
            return new BinaryNode<T>(value);

        if (contains(value))
            throw new RuntimeException("Value is duplicated");

        int compareResult = value.compareTo(curNode.value);

        if (compareResult < 0) 
            curNode.left = add(value, curNode.left);
        else if (compareResult > 0)
            curNode.right = add(value, curNode.right);
        else 
            ;

        return balance(curNode);
    }

    /**
     * Removes a value from the AVL tree and balances it if necessary
     * @param value the value to remove
     */
    @Override
    public void remove(T value) {
        this.root = remove(value, this.root);
    }

    protected BinaryNode<T> remove(T value, BinaryNode<T> curNode) {
        // TODO
        if (curNode == null) 
            return null;
        
        int compareResult = value.compareTo(curNode.value);

        if (compareResult < 0) 
            curNode.left = remove(value, curNode.left);
        else if (compareResult > 0) 
            curNode.right = remove(value, curNode.right);
        else if (curNode.left != null && curNode.right != null) {
            curNode.value = findMin(curNode.right).value;
            curNode.right = remove(curNode.value, curNode.right);
        } else 
            curNode = (curNode.left != null) ? curNode.left : curNode.right;

        return balance(curNode);
    }

    /**
     * Balances a node in the AVL tree if its balance factor is not in the range [-1, 1]
     * @param curNode the node to balance
     * @return curNode which might be updated depending on balancing operations
     */
    protected BinaryNode<T> balance(BinaryNode<T> curNode) {
        // TODO
        if (curNode == null) 
            return null;
        
        if (balanceFactor(curNode) < -1) {
            if (getHeight(curNode.left.left) >= getHeight(curNode.left.right)) 
                curNode = rotateRight(curNode);
            else 
                curNode.left = rotateLeft(curNode.left);
                curNode = rotateRight(curNode);
        } else if (balanceFactor(curNode) > 1) {
            if (getHeight(curNode.right.right) >= getHeight(curNode.right.left)) 
                curNode = rotateLeft(curNode);
            else 
                curNode.right = rotateRight(curNode.right);
                curNode = rotateLeft(curNode);
        }
        curNode.height = Math.max(getHeight(curNode.left), getHeight(curNode.right)) + 1;
        return curNode;
    }


    /**
     * Performs a right rotation on a node in the AVL tree to balance it
     * @param curNode the node to rotate
     * @return the node that replaces the rotated node in the tree
     */
    protected BinaryNode<T> rotateRight(BinaryNode<T> curNode) {
        // TODO
        BinaryNode<T> k1 = curNode.left;

        curNode.left = k1.right;
        k1.right = curNode;

        updateHeight(curNode);
        updateHeight(k1);

        return k1;
    }

    /**
     * Performs a left rotation on a node in the AVL tree to balance it
     * @param curNode the node to rotate
     * @return the node that replaces the rotated node in the tree
     */
    protected BinaryNode<T> rotateLeft(BinaryNode<T> curNode){
        // TODO
        BinaryNode<T> k1 = curNode.right;

        curNode.right = k1.left;
        k1.left = curNode;

        updateHeight(curNode);
        updateHeight(k1);

        return k1;
    }

    /**
     * Calculates the balance factor of a node in the AVL tree
     * @param node the node to calculate the balance factor for
     * @return the balance factor of the node
     */
    private int balanceFactor(BinaryNode<T> node) {
        return getHeight(node.right) - getHeight(node.left);
    }

    /**
     * Calculates the height of a node in the AVL tree
     * @param node the node to calculate the height for
     * @return the height of the node
     */
    private int getHeight(BinaryNode<T> node) {
        if(node == null) return 0;
        return node.height;
    }

    /**
     * Updates the height of a node in the AVL tree
     * @param node the node to update the height for
     */
    private void updateHeight(BinaryNode<T> node) {
        int leftChildHeight = getHeight(node.left);
        int rightChildHeight = getHeight(node.right);
        node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
    }
}
