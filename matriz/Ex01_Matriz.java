package matriz;

import java.util.Random;
import java.util.Scanner;

public class Ex01_Matriz {
    final static Scanner Sc = new Scanner(System.in);
    final static Random rand = new Random();

    public static void main(String[] args) {
        int n = lerNumInt();
        int m = lerNumInt();
        int k = lerNumInt();

        int[][] matriz = criarMatriz(n, m);

        imprimirMatriz(matriz);

    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] criarMatriz(int n, int m) {
        return new int[n][m];
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}