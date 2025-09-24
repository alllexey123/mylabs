import java.util.Arrays;

import static java.lang.Math.*;

public class Lab1 {

    public static void main(String[] args) {
        long[] e = new long[17 - 6 + 1];
        for (int i = 0; i < e.length; i++) {
            e[i] = 17 - i;
        }

        double[] x = new double[20];
        for (int i = 0; i < x.length; i++) {
            x[i] = Math.random() * 14 - 11;
        }

        double[][] l = new double[12][20];
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l[i].length; j++) {
                double xj = x[j];

                double v = asin((xj - 4) / 14);
                l[i][j] = e[i] == 15
                        ? asin(pow(E, pow(-pow(tan(xj), 2), 1 / 3D)))
                        : Arrays.binarySearch(new long[]{6, 7, 8, 9, 12, 16}, e[i]) >= 0
                        ? pow(pow(tan(xj), (v + 1 / 4D) / v) / 2, 2)
                        : pow(tan(pow(4 * atan((xj - 4) / 14), 2)), 1 / 3D);
            }
        }

        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < l[i].length; j++) {
                System.out.printf("%.5f ", l[i][j]);
            }
            System.out.println();
        }
    }
}

