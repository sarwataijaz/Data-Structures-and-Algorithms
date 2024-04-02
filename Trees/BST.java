public class BST {
    int root;
    BST left;
    BST right;
    public BST(int root) {
        this.root= root;
    }

    public BST(int root, BST left, BST right) {
        this.root = root;
        if (left.root > root || right.root < root) {
            throw new IllegalArgumentException("Invalid arguments.");
        }
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return (this.left==null && this.right==null);
    }
    public boolean setLeft(BST leftValue) {
        boolean set=true;
        if(root>leftValue.root) {
            if(left==null) {
                this.left = leftValue;
                return true;
            }
            if(left.isLeaf()) {
                this.left.left = leftValue;
            } else {
                set = left.setLeft(leftValue);
            }
        } else {
            set = false;
        }
       return set;
    }

    public boolean setRight(BST rightValue) {
        boolean set=true;
        if(root>rightValue.root) {
            if(right==null) {
                this.right = rightValue;
                return true;
            }
            if(right.isLeaf()) {
                this.right.right = rightValue;
            } else {
                set = right.setRight(rightValue);
            }
        } else {
            set = false;
        }
        return set;
    }

}
