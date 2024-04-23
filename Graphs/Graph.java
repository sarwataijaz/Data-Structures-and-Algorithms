// adjacency matrix

public class Graph {
    int size;
    String[] vertices;
    boolean[][] a;

    public Graph(String[] args) {
        size = args.length;
        vertices = new String[size];
        System.arraycopy(args,0,vertices,0,size);
        a = new boolean[size][size];
    }

    // obtain the indices of these strings from array, make the connection and set the boolean value

    public void add(String v, String w) {
        int i = index(v);
        int j = index(w);
        a[i][j] = a[j][i] = true;
    }

    private int index(String v) {
        for(int i=0; i<size; i++) {
            if(vertices[i].equals(v))
                return i;
        }
        return vertices.length;
    }

    public String toString() {
        if(size==0)
            return "{ }";
        StringBuffer sb = new StringBuffer("{"+vertex(0));
        for(int i=1; i<size; i++) {
            sb.append(", "+vertex(i));
        }
        return sb + "}";
    }

    public String vertex(int i) {
        StringBuffer sb = new StringBuffer(vertices[i]+": ");
        for(int j=0; j<size; j++) {
            if (a[i][j]) {
                sb.append(vertices[j]);
            }
        }
        return sb+" ";
    }
}
