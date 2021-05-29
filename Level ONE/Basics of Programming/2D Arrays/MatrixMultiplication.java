// package Basics of Programming.2D Arrays;
import java.util.*;
public class MatrixMultiplication {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int m1 = scn.nextInt();
        int[][] a1 = new int[n1][m1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                a1[i][j] = scn.nextInt();
            }
        }

        int n2 = scn.nextInt();
        int m2 = scn.nextInt();
        int[][] a2 = new int[n2][m2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                a2[i][j] = scn.nextInt();
            }
        }

        if (m1 == n2) {
            int[][] a3 = new int[n1][m2];

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m2; j++) {
                    int ans = 0;
                    for (int a = 0; a < n2; a++) {
                        ans = ans + a1[i][a] * a2[a][j];
                    }
                    a3[i][j] = ans;
                }
            }

            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < m2; j++) {
                    System.out.print(a3[i][j] + " ");
                }
                System.out.println();
            }

        } else {
            System.out.println("Invalid input");
        }

    }
}
