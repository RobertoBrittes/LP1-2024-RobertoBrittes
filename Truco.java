import java.util.Random;
import java.util.Scanner;

public class Truco {
    final static Scanner Sc = new Scanner(System.in);
    final static Random rand = new Random();

    public static void main(String[] args) {
        int pontuacaoJog = 0;
        int pontuacaoPc = 0;

        String[] numeroCarta = criarVetorString(10);
        String[] naipeCarta = criarVetorString(4);

        boolean jogarDupla = false;

        int[][] cartasJog = criarMatrizInt(3, 2);
        int[][] cartasDuo = criarMatrizInt(3, 2);

        int[][] cartasPc1 = criarMatrizInt(3, 2);
        int[][] cartasPc2 = criarMatrizInt(3, 2);

        boolean[][] cartasBaralho = criarMatrizBool(10, 4);
        cartasBaralho = incicializarMatriz(cartasBaralho, true);

        int[][] cartaVira = criarMatrizInt(1, 2);

        int[] cartaFazendo = criarVetorInt(2);

        jogarDupla = escolherSeVaiJogarDupla();

        if (jogarDupla) {
            while (pontuacaoJog < 12 && pontuacaoPc < 12) {
                limparTela();

                cartasBaralho = incicializarMatriz(cartasBaralho, true);

                cartasJog = distribuirCartas(cartasJog, cartasBaralho);
                cartasBaralho = marcarCartasDistribuidas(cartasJog, cartasBaralho);

                cartasPc1 = distribuirCartas(cartasPc1, cartasBaralho);
                cartasBaralho = marcarCartasDistribuidas(cartasPc1, cartasBaralho);

                cartasDuo = distribuirCartas(cartasDuo, cartasBaralho);
                cartasBaralho = marcarCartasDistribuidas(cartasDuo, cartasBaralho);

                cartasPc2 = distribuirCartas(cartasPc2, cartasBaralho);
                cartasBaralho = marcarCartasDistribuidas(cartasPc2, cartasBaralho);

                // vira a carta para definir os manilhas;
                cartaVira = virarCarta(cartaVira, cartasBaralho);
                cartasBaralho = marcarCartasDistribuidas(cartaVira, cartasBaralho);

                imprimirCarta
            }

        } else {
            limparTela();

            cartasBaralho = incicializarMatriz(cartasBaralho, true);

            cartasJog = distribuirCartas(cartasJog, cartasBaralho);
            cartasBaralho = marcarCartasDistribuidas(cartasJog, cartasBaralho);

            cartasPc1 = distribuirCartas(cartasPc1, cartasBaralho);
            cartasBaralho = marcarCartasDistribuidas(cartasPc1, cartasBaralho);

            // vira a carta para definir os manilhas;
            cartaVira = virarCarta(cartaVira, cartasBaralho);
            cartasBaralho = marcarCartasDistribuidas(cartaVira, cartasBaralho);
        }
    }

    public static void imprimirMenuIni() {
        imprimirTruco();

        System.out.println(
                "Olá, bem vindo ao jogo de TRUCO\n\nEscolha se deseja jogar em dupla ou individual\n1 - Individual\n2 - Dupla\n");
    }

    public static boolean escolherSeVaiJogarDupla() {
        boolean jogarDupla = false;
        imprimirMenuIni();
        switch (lerEscolhaTipoJogo()) {
            case 1:
                jogarDupla = false;
                break;

            case 2:
                jogarDupla = true;
                break;
        }
        return jogarDupla;
    }

    // metodo que verifica se a escolha do jogador é valida
    public static int lerEscolhaTipoJogo() {
        int n = 0;
        do {
            n = lerNumInt();
        } while (n > 2 || n < 1);
        return n;
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }

    public static void imprimirTruco() {
        setColor(4);
        System.out.println("┌────────────────────────────────────────────┐\n" + //
                "│ ████████╗██████╗ ██╗   ██╗ ██████╗ ██████╗ │\n" + //
                "│ ╚══██╔══╝██╔══██╗██║   ██║██╔════╝██╔═══██╗│\n" + //
                "│    ██║   ██████╔╝██║   ██║██║     ██║   ██║│\n" + //
                "│    ██║   ██╔══██╗██║   ██║██║     ██║   ██║│\n" + //
                "│    ██║   ██║  ██║╚██████╔╝╚██████╗╚██████╔╝│\n" + //
                "│    ╚═╝   ╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═════╝ │\n" + //
                "└────────────────────────────────────────────┘\n");
    }

    public static void limparTela() {
        for (int i = 0; i < 40; ++i) {
            System.out.println();
        }
        System.out.print("\033\143");

    }

    public static void setColor(int cor) {
        String s = "[0m";
        switch (cor) {
            case 0:
                s = "[30m";// preto
                break;
            case 1:
                s = "[31m";// vermelho
                break;
            case 2:
                s = "[32m";// verde
                break;
            case 3:
                s = "[303m";// amarelo
                break;
            case 4:
                s = "[34m";// azul
                break;
            case 5:
                s = "[35m";// magenta
                break;
            case 6:
                s = "[36m";// ciano
                break;
            case 7:
                s = "[97m";// branco
                break;
        }

        System.out.print((char) 27 + s);
    }

    public static int[][] virarCarta(int[][] cartaVira, boolean[][] cartasBaralho) {
        do {
            cartaVira[0][0] = rand.nextInt(10);
            cartaVira[0][1] = rand.nextInt(4);
        } while (!cartasBaralho[cartaVira[0][0]][cartaVira[0][1]]);
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

    public static String[] criarVetorString(int n) {
        return new String[n];
    }

    public static boolean[][] marcarCartasDistribuidas(int[][] cartas, boolean[][] cartasBaralho) {
        for (int i = 0; i < cartas.length; i++) {
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