import java.util.Random;
import java.util.Scanner;

public class Truco {
    final static Scanner Sc = new Scanner(System.in);
    final static Random rand = new Random();

    public static void main(String[] args) {
        int pontuacaoJog = 0;
        int pontuacaoComp = 0;

        boolean[][] cartasBaralho = criarMatrizString(10, 4);
        cartasBaralho = incicializarMatriz(cartasBaralho, true);

    }

    public static boolean[][] incicializarMatriz(boolean[][] matriz, boolean booleano) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = booleano;
            }
        }
        return matriz;
    }

    public static boolean[][] criarMatrizString(int l, int c) {
        return new boolean[l][c];
    }
}