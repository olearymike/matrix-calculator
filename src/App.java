public class App {

    /**
     * 
     * @param matrix An object of type Matrix that you would like to find the adjugate of.
     * @return A new Matrix object of the Matrix adjugate.
     */
    public static Matrix matrixAdjugator(Matrix matrix){
        Matrix newMatrix;
        double cf11, cf12, cf13, cf21, cf22, cf23, cf31, cf32, cf33;
        switch (matrix.n) {
            case 3:
            cf11 = (1) * (matrix.a22*matrix.a33 - matrix.a32*matrix.a23);
            cf12 = (-1) * (matrix.a21*matrix.a33 - matrix.a31*matrix.a23);
            cf13 = (1) * (matrix.a21*matrix.a32 - matrix.a31*matrix.a22);

            cf21 = (-1) * (matrix.a12*matrix.a33 - matrix.a32*matrix.a13);
            cf22 = (1) * (matrix.a11*matrix.a33 - matrix.a31*matrix.a13);
            cf23 = (-1) * (matrix.a11*matrix.a32-matrix.a31*matrix.a12);

            cf31 = (1) * (matrix.a12*matrix.a23-matrix.a22*matrix.a13);
            cf32 = (-1) * (matrix.a11*matrix.a23-matrix.a21*matrix.a13);
            cf33 = (1) * (matrix.a11*matrix.a22-matrix.a21*matrix.a12);

            newMatrix = new Matrix(cf11, cf21, cf31, cf12, cf22, cf32, cf13, cf23, cf33);
            return newMatrix;
        
            case 2:
            cf11 = (1) * matrix.a22;
            cf12 = (-1) * matrix.a21;

            cf21 = (-1) * matrix.a12;
            cf22 = (1) * matrix.a11;

            newMatrix = new Matrix(cf11, cf21, cf12, cf22);
            return newMatrix;
        }
        return null;
    }

    /**
     * 
     * @param matrix An object of type Matrix that you would like to find the determinant of.
     * @return The determinant of your Matrix.
     */
    public static int determinantFinder(Matrix matrix){
        switch (matrix.n) {
            case 3:
                return (int) (matrix.a11 * ((matrix.a22*matrix.a33) - (matrix.a32*matrix.a23))
                 - matrix.a12 * ((matrix.a21*matrix.a33) - (matrix.a31*matrix.a23))
                  + matrix.a13 * ((matrix.a21*matrix.a32) - (matrix.a31*matrix.a22)));
        
            case 2:
                return (int) ((matrix.a11*matrix.a22) - (matrix.a21*matrix.a12));
        }
        return 0;
    }

    /**
     * 
     * @param matrix An object of type Matrix that you would like to find the inverse of.
     * @return A new Matrix object of the inverted matrix.
     */
    public static Matrix matrixInverseFinder(Matrix matrix){
        Matrix adj = matrixAdjugator(matrix);
        double det = determinantFinder(matrix);

        switch (matrix.n) {
            case 3:
                return new Matrix((1/det) * adj.a11, (1/det) * adj.a12, (1/det) * adj.a13, 
                (1/det) * adj.a21, (1/det) * adj.a22, (1/det) * adj.a23,
                (1/det) * adj.a31, (1/det) * adj.a32, (1/det) * adj.a33);
        
            case 2:
                return new Matrix((1/det) * adj.a11, (1/det) * adj.a12, (1/det) * adj.a21, (1/det) * adj.a22);
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
        Matrix myMatrix = new Matrix(2, 0, 0, -3, 2, 0, -3, 2, 3);
        System.out.println(matrixAdjugator(myMatrix));
        System.out.println(determinantFinder(myMatrix));
        System.out.println(matrixInverseFinder(myMatrix));
    }
}
