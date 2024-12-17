import java.util.Random;
import java.util.Scanner;

public class Truco {
    final static Scanner Sc = new Scanner(System.in);
    final static Random rand = new Random();

    public static void main(String[] args) {
        limparTela();

        int pontuacaoJog = 0;
        int pontuacaoPc = 0;

        char[] numeroCarta = criarVetorChar(10);
        numeroCarta = preencherNumeroCarta(numeroCarta);
        String[] naipeCarta = criarVetorString(4);
        naipeCarta = preencherNaipeCarta(naipeCarta);

        int[][] cartasJog = criarMatrizInt(3, 2);

        int[][] cartasPc1 = criarMatrizInt(3, 2);

        boolean[][] cartasBaralho = criarMatrizBool(10, 4);
        cartasBaralho = incicializarMatriz(cartasBaralho, true);

        int[][] cartaVira = criarMatrizInt(1, 2);

        int[] cartaFazendo = criarVetorInt(2);

        int[] cartaJogadaJog = criarVetorInt(2);
        int[] cartaJogadaPc = criarVetorInt(2);

        int rodadaGanhaJog = 0;
        int rodadaGanhaPc = 0;

        String vencedorRodada = null;

        imprimirMenuIni();

        while (pontuacaoJog < 12 && pontuacaoPc < 12) {
            limparTela();

            cartasBaralho = incicializarMatriz(cartasBaralho, true);

            cartasJog = distribuirCartas(cartasJog, cartasBaralho);
            cartasBaralho = marcarCartasDistribuidas(cartasJog, cartasBaralho);

            cartasPc1 = distribuirCartas(cartasPc1, cartasBaralho);
            cartasBaralho = marcarCartasDistribuidas(cartasPc1, cartasBaralho);

            // vira a carta para definir os manilhas;
            cartaVira = virarCarta(cartaVira, cartasBaralho);
            cartasBaralho = marcarCartasDistribuidas(cartaVira, cartasBaralho);

            for (int i = 0; i < 3; i++) {
                imprimirCartaJogador(cartasJog, numeroCarta, naipeCarta);
                if (i == 0) {

                } else {

                    cartaFazendo[0] = 0;
                    cartaFazendo[1] = 0;

                    if (rodadaGanhaJog == 2) {
                        pontuacaoJog++;
                    }
                    if (rodadaGanhaPc == 2) {
                        pontuacaoPc++;
                    }

                }
            }
        }
    }

    public static int randomizarDescarte() {
        int num = 0;
        do {
            num = rand.nextInt(4);
        } while (num < 1 || num > 3 && num != 0);
        return num;
    }

    public static int[] jogarCartajog(int[] cartaJogada, int[][] cartas, String jogadorNaVez) {
        if (jogadorNaVez.equals("jogador")) {
            switch (lerNumInt()) {
                case 1:
                    cartaJogada[0] = cartas[0][0];
                    cartaJogada[1] = cartas[0][1];
                    break;
                case 2:
                    cartaJogada[0] = cartas[1][0];
                    cartaJogada[1] = cartas[1][1];

                    break;
                case 3:
                    cartaJogada[0] = cartas[2][0];
                    cartaJogada[1] = cartas[2][1];
                    break;
            }
        } else {
            switch (lerNumInt()) {
                case 1:
                    cartaJogada[0] = cartas[0][0];
                    cartaJogada[1] = cartas[0][1];
                    break;
                case 2:
                    cartaJogada[0] = cartas[1][0];
                    cartaJogada[1] = cartas[1][1];

                    break;
                case 3:
                    cartaJogada[0] = cartas[2][0];
                    cartaJogada[1] = cartas[2][1];
                    break;
            }
        }
        return cartaJogada;
    }

    public static String[] preencherNaipeCarta(String[] naipeCarta) {
        naipeCarta[0] = "OUROS";
        naipeCarta[1] = "ESPADAS";
        naipeCarta[2] = "COPAS";
        naipeCarta[3] = "PAUS";

        return naipeCarta;
    }

    public static char[] preencherNumeroCarta(char[] numeroCarta) {

        numeroCarta[0] = '4';
        numeroCarta[1] = '5';
        numeroCarta[2] = '6';
        numeroCarta[3] = '7';
        numeroCarta[4] = 'Q';
        numeroCarta[5] = 'J';
        numeroCarta[6] = 'K';
        numeroCarta[7] = 'A';
        numeroCarta[8] = '2';
        numeroCarta[9] = '3';

        return numeroCarta;
    }

    public static void imprimirCartaJogador(int[][] cartasJog, char[] numeroCarta, String[] naipeCarta) {
        System.out.println("Suas cartas:");

        for (int i = 0; i < cartasJog.length; i++) {
            System.out.println(numeroCarta[cartasJog[i][0]] + " de " + naipeCarta[cartasJog[i][1]]);
        }
        System.out.println();
    }

    public static void imprimirMenuIni() {
        gotoXY(0, 30);
        imprimirTruco();

        setColor(-1);
        System.out.println(
                "Olá, bem vindo ao jogo de TRUCO\n");
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

    public static void gotoXY(int linha, int coluna) {
        char escCode = 0x1B;
        System.out.print(String.format("%c[%d;%df", escCode, linha, coluna));
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

    public static char[] criarVetorChar(int n) {
        return new char[n];
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