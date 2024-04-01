public class BinaryTree {
    Object root;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(Object root) {
        this.root = root;
    }

    public BinaryTree(Object root, BinaryTree left, BinaryTree right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    public Object setRoot(Object obj) {
        Object temp = root;
        root = obj;
        return temp; // previous root
    }

    public BinaryTree setLeft(BinaryTree left) {
        BinaryTree temp = this.left;
        this.left = left;
        return temp; // previous left-subtree
    }

    public BinaryTree setRight(BinaryTree right) {
        BinaryTree temp = this.right;
        this.right = right;
        return temp; // previous right-subtree
    }

    public Object getRoot() {
        return root;
    }

    public BinaryTree getLeft() {
        return left;
    }

    public BinaryTree getRight() {
        return right;
    }

    // traversal

    public String InOrder() { // left, root, right
        StringBuilder sb = new StringBuilder("");
        if(left!=null)
            sb.append(left.InOrder()+" "); // keep traversing the left side
        sb.append(root+" ");
        if(right!=null)
            sb.append(right.InOrder()+" ");
        return sb+" ";
    }

    public int size() {
        int count = 1; // as the root exists
        if(left!=null) {
            count+=left.size();
        }
        if(right!=null) {
            count+=right.size();
        }
        return count;
    }

    public boolean isLeaf() {
        return (left==null && right==null);
    }

    public int height() {
        int leftH=0, rightH=0;
        if(left!=null) {
            leftH = left.height();
        }
        if(right!=null) {
            rightH = right.height();
        }
        return Math.max(leftH,rightH)+1;
    }

    public boolean search(Object obj) {
        if(root == obj)
            return true;
        boolean found = false;
        if(left!=null)
            found = left.search(obj);
        if(!found && right!=null)
            found = right.search(obj);
        return found;
    }
}

