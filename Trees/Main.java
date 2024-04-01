public class Main {
    public static void main(String[] args) {
        BinaryTree D = new BinaryTree("D");
        BinaryTree E = new BinaryTree("E");
        BinaryTree F = new BinaryTree("F");
        BinaryTree C = new BinaryTree("C",E,F);
        BinaryTree B = new BinaryTree("B",D,null);
        BinaryTree A = new BinaryTree("A",B,C);

        System.out.println(A.InOrder());
        System.out.println(A.getLeft().InOrder());
        System.out.println(A.getRight().InOrder());
    }
}
