package Q2AsymptomaticAnalysisII;

public class MatrixOperation {
    public int operationOnMatrix(int[][] matrix) {
        int rows = 0;
        int columns = 0;
        int maximumRow = 0;
        int maximumColumn=0;
        do {
            if(matrix[rows][columns]==1) {
                columns++;
                if(columns>maximumColumn) {
                    maximumColumn=columns;
                    maximumRow=rows;
                }
            }
            else {
                rows++;
            }
        }
        while( rows<matrix.length && columns<matrix.length);
        System.out.println("Row number "+ maximumRow+ " has the most '1s");
        return maximumRow;
    }

    public static void main(String[] args) {
        MatrixOperation mO = new MatrixOperation();
        //Test

    }
}
