import java.util.ArrayList;
public class PrintDiagonally {
        static ArrayList<Integer> downwardDiagonal(int N, int A[][])
        {
            ArrayList<Integer> num = new ArrayList<>();

            int row = 0;
            int col = 0;

            while(row < N && col < N) {

                for(int i = row, j = col; i <= col; i++, j--) {
                    num.add(A[i][j]);
                }

                if(col < N-1) {
                    col++;
                }
                else {
                    row++;
                }


            }

            return num;

        }
    }
       class Main {
            public static void main(String[] args) {
                int N = 4; // Adjust the size of the square matrix as needed
                int[][] matrix = {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 16}
                };
        
                ArrayList<Integer> diagonalElements = PrintDiagonally.downwardDiagonal(N, matrix);
        
                // Print the elements of the downward diagonal
                System.out.println("Elements of the downward diagonal:");
                for (Integer num : diagonalElements) {
                    System.out.print(num + " ");
                }
            }
        }
        
    
