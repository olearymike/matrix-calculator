import java.text.DecimalFormat;

public class SquareMatrix{
    int m, n;
    double a11, a12, a13, a21, a22, a23, a31, a32, a33;
    DecimalFormat forvm = new DecimalFormat("#.##");

    SquareMatrix(){
    }

    /**
     * 2x2 Matrix Constructor
     * @param a11 First row first column of the matrix.
     * @param a12 First row second column of the matrix.
     * @param a21 Second row first column of the matrix.
     * @param a22 Second row second column of the 2x2.
     */
    SquareMatrix(double a11, double a12, double a21, double a22){
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
    SquareMatrix(double a11, double a12, double a13, double a21, double a22, double a23, double a31, double a32, double a33){
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
    
    /**
     * 
     * @return Returns the cofactor of the matrix as a new matrix object.
     */
    public SquareMatrix cofactor(){
        double c11, c12, c13, c21, c22, c23, c31, c32, c33;
        switch (this.n) {
            case 3:
            c11 = (1) * (this.a22*this.a33 - this.a32*this.a23);
            c12 = (-1) * (this.a21*this.a33 - this.a31*this.a23);
            c13 = (1) * (this.a21*this.a32 - this.a31*this.a22);

            c21 = (-1) * (this.a12*this.a33 - this.a32*this.a13);
            c22 = (1) * (this.a11*this.a33 - this.a31*this.a13);
            c23 = (-1) * (this.a11*this.a32-this.a31*this.a12);

            c31 = (1) * (this.a12*this.a23-this.a22*this.a13);
            c32 = (-1) * (this.a11*this.a23-this.a21*this.a13);
            c33 = (1) * (this.a11*this.a22-this.a21*this.a12);

            return new SquareMatrix(c11, c12, c13, c21, c22, c23, c31, c32, c33);
        
            case 2:
            c11 = (1) * this.a22;
            c12 = (-1) * this.a21;

            c21 = (-1) * this.a12;
            c22 = (1) * this.a11;

            return new SquareMatrix(c11, c12, c21, c22);
        }
        return null;
    }

    /**
     * 
     * @return Returns the transose of the matrix as a new matrix object.
     */
    public SquareMatrix transpose(){
        switch (this.n) {
            case 3:
            return new SquareMatrix(this.a11, this.a21, this.a31,
            this.a12, this.a22, this.a32,
            this.a13, this.a23, this.a33);

        
            case 2:
            return new SquareMatrix(this.a11, this.a21, this.a12, this.a22);

        }  
        return null; 
    }

    /**
     * 
     * @param matrix An object of type Matrix that you would like to find the adjugate of.
     * @return A new Matrix object of the Matrix adjugate.
     */
    public SquareMatrix adjugate(){
        return (this.cofactor()).transpose();
    }

    /**
     * 
     * @param matrix An object of type Matrix that you would like to find the determinant of.
     * @return The determinant of your Matrix.
     */
    public int determinant(){
        switch (this.n) {
            case 3:
                return (int) (this.a11 * ((this.a22*this.a33) - (this.a32*this.a23))
                 - this.a12 * ((this.a21*this.a33) - (this.a31*this.a23))
                  + this.a13 * ((this.a21*this.a32) - (this.a31*this.a22)));
        
            case 2:
                return (int) ((this.a11*this.a22) - (this.a21*this.a12));
        }
        return 0;
    }

    /**
     * 
     * @return Returns the inverse of the matrix as a new matrix object.
     */
    public SquareMatrix inverse(){
        SquareMatrix adj = this.adjugate();
        double det = this.determinant();

        switch (this.n) {
            case 3:
                return new SquareMatrix((1/det) * adj.a11, (1/det) * adj.a12, (1/det) * adj.a13, 
                (1/det) * adj.a21, (1/det) * adj.a22, (1/det) * adj.a23,
                (1/det) * adj.a31, (1/det) * adj.a32, (1/det) * adj.a33);
        
            case 2:
                return new SquareMatrix((1/det) * adj.a11, (1/det) * adj.a12, (1/det) * adj.a21, (1/det) * adj.a22);
        }
        return null;
    }

    @Override
    public String toString() {
        return ("|" + form.format(a11) + " " + form.format(a12) + " " + form.format(a13) + "|\n|" 
        + form.format(a21) + " " + form.format(a22) + " " + form.format(a23) + "|\n|" 
        + form.format(a31) + " " + form.format(a32) + " " + form.format(a33) + "|");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + m;
        result = prime * result + n;
        long temp;
        temp = Double.doubleToLongBits(a11);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(a12);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(a13);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(a21);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(a22);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(a23);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(a31);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(a32);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(a33);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SquareMatrix other = (SquareMatrix) obj;
        if (m != other.m)
            return false;
        if (n != other.n)
            return false;
        if (Double.doubleToLongBits(a11) != Double.doubleToLongBits(other.a11))
            return false;
        if (Double.doubleToLongBits(a12) != Double.doubleToLongBits(other.a12))
            return false;
        if (Double.doubleToLongBits(a13) != Double.doubleToLongBits(other.a13))
            return false;
        if (Double.doubleToLongBits(a21) != Double.doubleToLongBits(other.a21))
            return false;
        if (Double.doubleToLongBits(a22) != Double.doubleToLongBits(other.a22))
            return false;
        if (Double.doubleToLongBits(a23) != Double.doubleToLongBits(other.a23))
            return false;
        if (Double.doubleToLongBits(a31) != Double.doubleToLongBits(other.a31))
            return false;
        if (Double.doubleToLongBits(a32) != Double.doubleToLongBits(other.a32))
            return false;
        if (Double.doubleToLongBits(a33) != Double.doubleToLongBits(other.a33))
            return false;
        return true;
    }



}