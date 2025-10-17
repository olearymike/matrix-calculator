import java.util.List;
import java.util.ArrayList;

public class Matrix{
    int m, n;
    double a11, a12, a13, a21, a22, a23, a31, a32, a33;
    List<ArrayList<Double>> matrix;

    public Matrix(){
        this.matrix = new ArrayList<ArrayList<Double>>();
    }

    public Matrix(int m, int n){
        for (int i = 0; i < m; i++){
            this.matrix.set(i, new ArrayList<Double>());
            for (int j = 0; j < n; j++){
                this.matrix.get(i).add(null);
            }
        }
    }

    /**
     * 2x2 Matrix Constructor
     * @param a11 First row first column of the matrix.
     * @param a12 First row second column of the matrix.
     * @param a21 Second row first column of the matrix.
     * @param a22 Second row second column of the 2x2.
     */
    public Matrix(double a11, double a12, double a21, double a22){
        this.n = 2;
        this.a11 = a11;
        this.a12 = a12;
        this.a21 = a21;
        this.a22 = a22;
    }

    /**
     * 3x3 Matrix Constructor
     * @param a11 First row first column of the matrix.
     * @param a12 First row second column of the matrix.
     * @param a13 First row third column of the matrix.
     * @param a21 Second row first column of the matrix.
     * @param a22 Second row second column of the matrix.
     * @param a23 Second row third column of the matrix.
     * @param a31 Third row first column of the matrix.
     * @param a32 Third row second column of the matrix.
     * @param a33 Third row third column of the matrix.
     */
    public Matrix(double a11, double a12, double a13, double a21, double a22, double a23, double a31, double a32, double a33){
        this.n = 3;
        this.a11 = a11;
        this.a12 = a12;
        this.a13 = a13;
        this.a21 = a21;
        this.a22 = a22;
        this.a23 = a23;
        this.a31 = a31;
        this.a32 = a32;
        this.a33 = a33;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return ("|" + Double.toString(a11) + " " + Double.toString(a12) + " "  + Double.toString(a13) + "|\n|" 
        + Double.toString(a21) + " " + Double.toString(a22) + " " + Double.toString(a23) + "|\n|" 
        + Double.toString(a31) + " " + Double.toString(a32) + " " + Double.toString(a33) + "|");
    }


}