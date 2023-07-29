import java.util.*;
public class ZerosInMatrix {
  
    public static void setZeroes(int[][] matrix) {
     
     int rows = matrix.length;
     int cols = matrix[0].length;
        
        
        for(int i = 0; i < rows; i++) {
           for(int j = 0; j < cols; j++) {
            
               if(matrix[i][j] == 0) {
                
                // if we directly assign all elements zero, then the loop will make all the newly assigned zeros row/col also zero
                for(int k = 0; k < rows; k++) {
                    
                    if(matrix[k][j] != 0) {
                        matrix[k][j] = -99; // set all rows corresponding that zeroth element to a specific value
                    }
                    
                }
            }
        } 
    }
        
          for(int i = 0; i < rows; i++) {
           for(int j = 0; j < cols; j++) {
            
               if(matrix[i][j] == 0) {
                
                for(int k = 0; k < cols; k++) {
                    
                    if(matrix[i][k] != 0) {
                        matrix[i][k] = -99; // set all coloumns corresponding that zeroth element to a specific value
                    }
                    
                }
            }
        } 
    }
        
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                
                if(matrix[i][j] == -99) {
                    matrix[i][j] = 0;
                }
            }
        } 
     
    }


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        setZeroes(matrix);
    }
}