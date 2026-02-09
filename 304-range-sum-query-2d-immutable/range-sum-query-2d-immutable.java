class NumMatrix {

    public int[][] prefixMatrix; 

    public NumMatrix(int[][] matrix) {
         int rows = matrix.length, cols = matrix[0].length;
        prefixMatrix = new int[rows][cols];


            for(int i = 0; i< rows ; i++) {
                prefixMatrix[i][0] = matrix[i][0];
                for(int j = 1; j< cols ; j++) {
                    prefixMatrix [i][j] = matrix[i][j] + prefixMatrix[i][j-1];
                    
                }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int r = row1; r <= row2; r++) {
            if (col1 > 0) {
                sum += prefixMatrix[r][col2] - prefixMatrix[r][col1 - 1];
            } else {
                sum += prefixMatrix[r][col2];
            }
        }
    
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */