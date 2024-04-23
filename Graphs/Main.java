public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(new String[]{"A","B","C","D","E"});
        System.out.println(g);
        g.add("A","B");
        g.add("A","C");
        g.add("B","C");
        g.add("B","D");
        g.add("C","D");
        g.add("D","E");
        System.out.println(g);
    }
}
