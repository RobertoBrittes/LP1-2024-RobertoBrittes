import java.util.Random;
import java.util.Scanner;

public class Truco {
    final static Scanner Sc = new Scanner(System.in);
    final static Random rand = new Random();

    public static void main(String[] args) {
        int pontuacaoJog = 0;
        int pontuacaoPc = 0;

        int[][] cartasJog = criarMatrizInt(3, 2);
        int[][] cartasDupla = criarMatrizInt(3, 2);

        int[][] cartasPc1 = criarMatrizInt(3, 2);
        int[][] cartasPc2 = criarMatrizInt(3, 2);

        boolean[][] cartasBaralho = criarMatrizBool(10, 4);
        cartasBaralho = incicializarMatriz(cartasBaralho, true);

        cartasJog = distribuirCartas(cartasJog);

    }

    public static int[][] distribuirCartas(int[][] cartas) {
        for (int i = 0; i < cartas[0].length; i++) {
            for (int j = 0; j < cartas.length; j++) {
                if (j == 0) {
                    cartas[i][j] = rand.nextInt(4);
                } else {
                    cartas[i][j] = rand.nextInt(10);
                }
            }
        }
        return cartas;
    }

    public static int[][] criarMatrizInt(int l, int c) {
        return new int[l][c];
    }

    public static boolean[][] criarMatrizBool(int l, int c) {
        return new boolean[l][c];
    }

    public static boolean[][] incicializarMatriz(boolean[][] matriz, boolean booleano) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = booleano;
            }
        }
        return matriz;
    }

}