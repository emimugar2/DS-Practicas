/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

public class MatrixFunctions {

    public static int max(int[][] a) {
        int max = a[0][0];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                max = Math.max(max, a[i][j]);
            }
        }
        return max;
    }

    public static int rowSum(int[][] a, int row) {
        int sum = 0;
        for (int i = 0; i < a[row].length; i++) {
            sum = Sum.sum(sum, a[row][i]);
        }
        return sum;
    }

    public static int columnSum(int[][] a, int column) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].length > column) {
                sum = Sum.sum(sum, a[i][column]);
            }
        }
        return sum;
    }

    public static int[] allRowSums(int[][] a) {
        int[] sum = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            sum[i] = rowSum(a, i);
        }
        return sum;
    }

    public static int[] allColumnSums(int[][] a) {
        int max = a.length;
        for (int i = 1; i < a.length; i++) {
            if (max < a[i].length) {
                max = a[i].length;
            }
        }
        int[] sum = new int[max];

        for (int i = 0; i < max; i++) {
            sum[i] = columnSum(a, i);
        }
        return sum;
    }

    public static boolean isRowMagic(int[][] a) {
        int aux;
        int[] result;

        result = allRowSums(a);

        aux = result[0];
        for (int i = 1; i < result.length; i++) {
            if (aux != result[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isColumnMagic(int[][] a) {
        int aux;
        int[] result;

        result = allColumnSums(a);

        aux = result[0];
        for (int i = 1; i < result.length; i++) {
            if (aux != result[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSquare(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].length != a.length) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMagic(int[][] a) {
        if (isRowMagic(a) && isColumnMagic(a) && isSquare(a)) {
            int comprobacion = allRowSums(a)[0];
            if (comprobacion == allColumnSums(a)[0]) {
                int j = 1;
                int k = a.length-2;
                int sumDiag1 = a[0][0];
                int sumDiag2 = a[0][a.length-1];
                for (int i = 1; i < a.length; i++) {
                    sumDiag1 += a[i][j];
                    sumDiag2 += a[i][k];
                    j++;
                    k--;
                }
                if ((sumDiag1 == sumDiag2) && sumDiag1 == comprobacion){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isSequence(int[][] a) {
        if (isSquare(a)) {
            int comprobante = 1;
            int ultimo = a.length * a.length;
            for (int c = 0; c < ultimo; c++) {
                for (int i = 0; i < a.length; i++) {
                    for (int j = 0; j < a[i].length; j++) {
                        if (comprobante == a[i][j]) {
                            comprobante++;
                        }
                    }
                }
            }
            if (comprobante > ultimo){
                return true;
            }
        }
        return false;
    }
}
