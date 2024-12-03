
import java.util.Random;
import java.util.Scanner;

public class Ex01_Matriz {
    final static Scanner Sc = new Scanner(System.in);
    final static Random rand = new Random();

    public static void main(String[] args) {
        int n = lerNumInt();
        int m = lerNumInt();
        int k = lerNumInt();
        int somaMatriz = 0;
        int maiorElemento = 0;
        int menorElemento = 10000000;
        float mediaMatriz = 0f;
        int[] posMaiorElemento = criarVetorInt(2);
        int[] posMenorElemento = criarVetorInt(2);

        int[][] matriz = criarMatriz(n, m);

        // matriz = inicializarMatriz(matriz, k);
        matriz = gerarMatriz(matriz);
        // matriz = lerMatriz(matriz);

        imprimirMatriz(matriz);
        somaMatriz = somarMatriz(matriz);
        mediaMatriz = calcularMedia(somaMatriz, matriz);

        maiorElemento = encontrarMaiorElemento(matriz);
        menorElemento = encontrarMenorElemento(matriz);
        posMaiorElemento = encontrarPosMaiorElemento(matriz, maiorElemento, posMaiorElemento);
        posMenorElemento = encontrarPosMenorElemento(matriz, menorElemento, posMenorElemento);

        imprimir("Soma: " + somaMatriz);
        imprimir("Media: " + mediaMatriz);
        imprimir("Maior: " + maiorElemento + " Posição: " + posMaiorElemento[0] + " " + posMaiorElemento[1]);
        imprimir("Menor: " + menorElemento + " Posição: " + posMenorElemento[0] + " " + posMenorElemento[1]);

    }

    public static int[] encontrarPosMenorElemento(int[][] matriz, int menorElemento, int[] posMenorElemento) {
        posMenorElemento[0] = 0;
        posMenorElemento[1] = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (menorElemento == matriz[i][j]) {
                    posMenorElemento[0] = i;
                    posMenorElemento[1] = j;
                    break;
                }
            }
        }
        return posMenorElemento;
    }

    public static int[] criarVetorInt(int n) {
        return new int[n];
    }

    public static int[] encontrarPosMaiorElemento(int[][] matriz, int maiorElemento, int[] posMaiorElemento) {
        posMaiorElemento[0] = 0;
        posMaiorElemento[1] = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (maiorElemento == matriz[i][j]) {
                    posMaiorElemento[0] = i;
                    posMaiorElemento[1] = j;
                    break;
                }
            }
        }
        return posMaiorElemento;
    }

    public static int encontrarMaiorElemento(int[][] matriz) {
        int maiorElemento = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] > maiorElemento) {
                    maiorElemento = matriz[i][j];
                }
            }
        }
        return maiorElemento;
    }

    public static int encontrarMenorElemento(int[][] matriz) {
        int maiorElemento = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] < maiorElemento) {
                    maiorElemento = matriz[i][j];
                }
            }
        }
        return maiorElemento;
    }

    public static float calcularMedia(int somaMatriz, int[][] matriz) {
        return (float) somaMatriz / (matriz.length * matriz[0].length);
    }

    public static int somarMatriz(int[][] matriz) {
        int somaMatriz = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                somaMatriz += matriz[i][j];
            }
        }
        return somaMatriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        /*
         * System.out.println();
         * for (int i = 0; i < matriz.length; i++) {
         * for (int j = 0; j < matriz[0].length; j++) {
         * if (matriz[i][j] == 1) {
         * System.out.print("*");
         * } else {
         * System.out.print(" ");
         * }
         * System.out.print(" ");
         * }
         * System.out.println();
         * }
         * System.out.println();
         */
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] gerarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = rand.nextInt(100);
            }
        }
        return matriz;
    }

    public static int[][] lerMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = lerNumInt();
            }
        }
        return matriz;
    }

    public static int[][] inicializarMatriz(int[][] matriz, int k) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = k;
            }
        }
        return matriz;
    }

    public static int[][] criarMatriz(int n, int m) {
        return new int[n][m];
    }

    public static void imprimir(String msg) {
        System.out.println(msg);
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}