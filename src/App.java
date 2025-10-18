public class App {
    public static void main(String[] args) throws Exception {
        SquareMatrix myMatrix = new SquareMatrix(2, 0, 0, -3, 2, 0, -3, 2, 3);
        System.out.println(myMatrix.adjugate());
        System.out.println(myMatrix.determinant());
        System.out.println(myMatrix.inverse());
    }
}
