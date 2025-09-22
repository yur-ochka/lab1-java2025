public class MatrixLab {

    public static void main(String[] args) {
        try {
            float[][] A = {
                {1.5f, 2.8f, 3.2f},
                {4.1f, 5.9f, 6.3f},
                {7.4f, 8.6f, 9.0f}
            };
            
            float[][] B = {
                {9.0f, 8.6f, 7.4f},
                {6.3f, 5.9f, 4.1f},
                {3.2f, 2.8f, 1.5f}
            };
            
            System.out.println("Matrix A:");
            printMatrix(A);
            System.out.println("Matrix B:");
            printMatrix(B);
            
            if (B == null || B.length == 0) {
                throw new IllegalArgumentException("Matrix B cannot be empty");
            }
            
            float[][] C = transposeMatrix(B);
            System.out.println("Matrix C (B transpose):");
            printMatrix(C);
            
            if (C == null || C.length == 0) {
                throw new IllegalArgumentException("Matrix C cannot be empty");
            }
            
            float result = calculateSpecialSum(C);
            System.out.println("Result: " + result);
            
        } catch (NullPointerException e) {
            System.err.println("Error: Null reference encountered - " + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Error of info " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Index out of bounds - " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpecter error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Program has ended.");
        }
    }
    
    private static float[][] transposeMatrix(float[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (matrix.length == 0) {
            throw new IllegalArgumentException("Matrix cannot be empty");
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for (int i = 1; i < rows; i++) {
            if (matrix[i].length != cols) {
                throw new IllegalArgumentException("Matrix is not rectangular: rows have different lengths");
            }
        }
        
        float[][] result = new float[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    
    private static float calculateSpecialSum(float[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (matrix.length == 0) {
            throw new IllegalArgumentException("Matrix cannot be empty");
        }
        
        int cols = matrix[0].length;
        
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != cols) {
                throw new IllegalArgumentException("Matrix is not rectangular: rows have different lengths");
            }
        }
        
        float sum = 0;
        
        for (int j = 0; j < cols; j++) {
            if (j % 2 == 1) { 
                float max = matrix[0][j];
                for (int i = 1; i < matrix.length; i++) {
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                }
                sum += max;
            } else { 
                float min = matrix[0][j];
                for (int i = 1; i < matrix.length; i++) {
                    if (matrix[i][j] < min) {
                        min = matrix[i][j];
                    }
                }
                sum += min;
            }
        }
        return sum;
    }
    
    private static void printMatrix(float[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix: null");
            return;
        }
        if (matrix.length == 0) {
            System.out.println("Matrix: []");
            return;
        }
        
        for (float[] row : matrix) {
            if (row == null) {
                System.out.println("null");
                continue;
            }
            for (float value : row) {
                System.out.printf("%8.2f", value);
            }
            System.out.println();
        }
    }
    
}