import java.util.Random;
import java.util.Scanner;

public class Truco {
    final static Scanner Sc = new Scanner(System.in);
    final static Random rand = new Random();

    public static void main(String[] args) {
        int pontuacaoJog = 0;
        int pontuacaoPc = 0;

        int[][] cartasJog = criarMatrizInt(3, 2);
        int[][] cartasDuo = criarMatrizInt(3, 2);

        int[][] cartasPc1 = criarMatrizInt(3, 2);
        int[][] cartasPc2 = criarMatrizInt(3, 2);

        boolean[][] cartasBaralho = criarMatrizBool(10, 4);
        cartasBaralho = incicializarMatriz(cartasBaralho, true);

        int[] cartaFazendo = criarVetorInt(2);
        int[] cartaVira = criarVetorInt(2);

        while (pontuacaoJog < 12 || pontuacaoPc < 12) {
            cartasJog = distribuirCartas(cartasJog, cartasBaralho);
            cartasBaralho = marcarCartasDistribuidas(cartasJog, cartasBaralho);

            cartasPc1 = distribuirCartas(cartasPc1, cartasBaralho);
            cartasBaralho = marcarCartasDistribuidas(cartasPc1, cartasBaralho);

            cartasDuo = distribuirCartas(cartasDuo, cartasBaralho);
            cartasBaralho = marcarCartasDistribuidas(cartasDuo, cartasBaralho);

            cartasPc2 = distribuirCartas(cartasPc2, cartasBaralho);
            cartasBaralho = marcarCartasDistribuidas(cartasPc2, cartasBaralho);

            cartaVira = virarCarta(cartaVira, cartasBaralho);
            
        }
    }

    public static int[] virarCarta(int[] cartaVira, boolean[][] cartasBaralho) {
        do {
            cartaVira[0] = rand.nextInt(10);
            cartaVira[1] = rand.nextInt(4);
        } while (!cartasBaralho[cartaVira[0]][cartaVira[1]]);
        return cartaVira;
    }

    public static int[] incicializarVetInt(int v, int[] vetInt) {
        for (int i = 0; i < vetInt.length; i++) {
            vetInt[i] = v;
        }
        return vetInt;
    }

    public static int[] criarVetorInt(int n) {
        return new int[n];
    }

    public static boolean[][] marcarCartasDistribuidas(int[][] cartas, boolean[][] cartasBaralho) {
        for (int i = 0; i < cartas[0].length; i++) {
            cartasBaralho[cartas[i][0]][cartas[i][1]] = false;
        }
        return cartasBaralho;
    }

    public static int[][] distribuirCartas(int[][] cartas, boolean[][] cartasBaralho) {
        for (int i = 0; i < cartas.length; i++) {
            do {
                cartas[i][0] = rand.nextInt(10);
                cartas[i][1] = rand.nextInt(4);
            } while (!cartasBaralho[cartas[i][0]][cartas[i][1]]);
            cartasBaralho[cartas[i][0]][cartas[i][1]] = false;
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