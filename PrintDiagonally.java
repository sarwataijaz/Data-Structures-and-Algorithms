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
    
