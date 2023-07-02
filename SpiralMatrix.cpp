class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        
        int rows = matrix.size();
        int columns = matrix[0].size();
        vector<int> spiralMatrix;

        int row_s = 0;
        int row_e = rows - 1;
        int column_s = 0;
        int column_e = columns - 1;

        while(row_s <= row_e && column_s <= column_e) {

            for(int col = column_s; col <= column_e; col++) {
                spiralMatrix.push_back(matrix[row_s][col]);
            }

            row_s++;

            for(int row = row_s; row <= row_e; row++) {
                spiralMatrix.push_back(matrix[row][column_e]);
            }

            column_e--;
            
            if(row_s <= row_e) {

            for(int col = column_e; col >= column_s; col--) {
                spiralMatrix.push_back(matrix[row_e][col]);
            }
        }

            row_e--;
            
            if(column_s <= column_e) {

            for(int row = row_e; row >= row_s; row--) {
                spiralMatrix.push_back(matrix[row][column_s]);
            }
        }

            column_s++;
        }

        return spiralMatrix;
    }
};
