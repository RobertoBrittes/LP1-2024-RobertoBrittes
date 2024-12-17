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
        boolean[] cartaDiponivelJog = criarVetorBool(3);
        cartaDiponivelJog = incicializarVetBool(true, cartaDiponivelJog);

        int[][] cartasPc1 = criarMatrizInt(3, 2);
        boolean[] cartaDiponivelPc = criarVetorBool(3);
        cartaDiponivelPc = incicializarVetBool(true, cartaDiponivelPc);

        boolean[][] cartasBaralho = criarMatrizBool(10, 4);
        cartasBaralho = incicializarMatriz(cartasBaralho, true);

        int[][] cartaVira = criarMatrizInt(1, 2);

        int[] cartaJogadaJog = criarVetorInt(2);
        int[] cartaJogadaPc = criarVetorInt(2);

        int rodadaGanhaJog = 0;
        int rodadaGanhaPc = 0;

        int cartaSelecionada = 0;

        String vencedorRodada = "jogador";

        String jogadorNaVez = null;

        imprimirMenuIni();

        while (pontuacaoJog < 12 && pontuacaoPc < 12) {
            limparTela();

            rodadaGanhaJog = 0;
            rodadaGanhaPc = 0;

            cartasBaralho = incicializarMatriz(cartasBaralho, true);

            cartasJog = distribuirCartas(cartasJog, cartasBaralho);
            cartaDiponivelJog = incicializarVetBool(true, cartaDiponivelJog);
            cartasBaralho = marcarCartasDistribuidas(cartasJog, cartasBaralho);

            cartasPc1 = distribuirCartas(cartasPc1, cartasBaralho);
            cartaDiponivelPc = incicializarVetBool(true, cartaDiponivelPc);
            cartasBaralho = marcarCartasDistribuidas(cartasPc1, cartasBaralho);

            // vira a carta para definir os manilhas;
            cartaVira = virarCarta(cartaVira, cartasBaralho);
            cartasBaralho = marcarCartasDistribuidas(cartaVira, cartasBaralho);

            while (rodadaGanhaJog < 2 && rodadaGanhaPc < 2) {
                setColor(6);
                imprimirPlacarRodadaPorRodada(rodadaGanhaJog, rodadaGanhaPc, pontuacaoJog, pontuacaoPc);

                imprimirCartaJogador(cartasJog, numeroCarta, naipeCarta, cartaDiponivelJog);
                setColor(-1);

                if (vencedorRodada.equals("jogador")) {
                    jogadorNaVez = "jogador";
                    do {
                        cartaSelecionada = lerCartaDescarte();
                        cartaJogadaJog = jogarCarta(cartaJogadaJog, cartasJog, jogadorNaVez,
                                cartaDiponivelJog, cartaSelecionada);
                    } while (!cartaDiponivelJog[cartaSelecionada]);
                    cartaDiponivelJog[cartaSelecionada] = false;
                    imprimirCartaJogada(cartaJogadaJog, numeroCarta, naipeCarta,
                            "Jogador");
                    setColor(-1);

                    jogadorNaVez = "pc";
                    do {
                        cartaSelecionada = randomizarDescarte();
                        cartaJogadaPc = jogarCarta(cartaJogadaPc, cartasPc1, jogadorNaVez, cartaDiponivelPc,
                                cartaSelecionada);
                    } while (!cartaDiponivelPc[cartaSelecionada]);
                    cartaDiponivelPc[cartaSelecionada] = false;
                    imprimirCartaJogada(cartaJogadaPc, numeroCarta, naipeCarta,
                            "Pc");
                    setColor(-1);

                } else {
                    jogadorNaVez = "pc";
                    do {
                        cartaSelecionada = randomizarDescarte();
                        cartaJogadaPc = jogarCarta(cartaJogadaPc, cartasPc1, jogadorNaVez, cartaDiponivelPc,
                                cartaSelecionada);
                    } while (!cartaDiponivelPc[cartaSelecionada]);
                    cartaDiponivelPc[cartaSelecionada] = false;
                    imprimirCartaJogada(cartaJogadaPc, numeroCarta, naipeCarta,
                            "Pc");
                    setColor(-1);

                    jogadorNaVez = "jogador";
                    do {
                        cartaSelecionada = lerCartaDescarte();
                        cartaJogadaJog = jogarCarta(cartaJogadaJog, cartasJog, jogadorNaVez,
                                cartaDiponivelJog, cartaSelecionada);
                    } while (!cartaDiponivelJog[cartaSelecionada]);
                    cartaDiponivelJog[cartaSelecionada] = false;
                    imprimirCartaJogada(cartaJogadaJog, numeroCarta, naipeCarta,
                            "Jogador");
                    setColor(-1);
                }

                if (cartaJogadaJog[0] > cartaJogadaPc[0]) {
                    vencedorRodada = "jogador";
                    rodadaGanhaJog++;
                } else if (cartaJogadaJog[0] < cartaJogadaPc[0]) {
                    vencedorRodada = "pc";
                    rodadaGanhaPc++;
                } else {
                    vencedorRodada = "empate";
                    rodadaGanhaJog++;
                    rodadaGanhaPc++;
                }

                if (rodadaGanhaJog == 2) {
                    pontuacaoJog++;
                    break;
                }
                if (rodadaGanhaPc == 2) {
                    pontuacaoPc++;
                    break;
                }

            }
        }
        
    }

    public static void imprimirPlacar(int pontuacaoJog, int pontuacaoPc) {
        System.out.println();
        System.out.println("Pontuação - Tempos");
        System.out.println("Jogador X Computador\n" + //
                "   " + pontuacaoJog + "          " + pontuacaoPc + "\n");

    }

    public static void imprimirPlacarRodadaPorRodada(int rodadaGanhaJog, int rodadaGanhaPc, int pontuacaoJog, int pontuacaoPc) {
        System.out.println();
        System.out.println("Pontuação - Tempos");
        System.out.println("Jogador X Computador\n" + //
                "   " + pontuacaoJog + "          " + pontuacaoPc + "\n");

        System.out.println("Pontuação - Rodadas");
        System.out.println("Jogador X Computador\n" + //
                "   " + rodadaGanhaJog + "          " + rodadaGanhaPc + "\n");
    }

    public static int lerCartaDescarte() {
        int n = 0;
        do {
            n = lerNumInt();
        } while (n < 0 || n > 2);
        return n;
    }

    public static void imprimirCartaJogada(int[] cartaJogada, char[] numeroCarta, String[] naipeCarta,
            String jogadorNaVez) {
        System.out.print("Carta do " + jogadorNaVez + ": ");
        if (cartaJogada[1] == 0 || cartaJogada[1] == 2) {
            setColor(1);
        } else {
            setColor(0);
        }
        System.out.println(numeroCarta[cartaJogada[0]] + " de " + naipeCarta[cartaJogada[1]]);
    }

    public static boolean[] incicializarVetBool(boolean bool, boolean[] vetBool) {
        for (int i = 0; i < vetBool.length; i++) {
            vetBool[i] = bool;
        }
        return vetBool;
    }

    public static boolean[] criarVetorBool(int n) {
        return new boolean[n];
    }

    public static int randomizarDescarte() {
        return rand.nextInt(3);
    }

    public static int[] jogarCarta(int[] cartaJogada, int[][] cartas, String jogadorNaVez, boolean[] cartaDiponivel,
            int cartaSelecionada) {
        switch (cartaSelecionada) {
            case 0:
                cartaJogada[0] = cartas[0][0];
                cartaJogada[1] = cartas[0][1];
                break;
            case 1:
                cartaJogada[0] = cartas[1][0];
                cartaJogada[1] = cartas[1][1];
                break;
            case 2:
                cartaJogada[0] = cartas[2][0];
                cartaJogada[1] = cartas[2][1];
                break;
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

    public static void imprimirCartaJogador(int[][] cartasJog, char[] numeroCarta, String[] naipeCarta,
            boolean[] cartaDiponivel) {
        System.out.println("Suas cartas:\n");

        for (int i = 0; i < cartasJog.length; i++) {
            if (cartaDiponivel[i]) {
                if (naipeCarta[cartasJog[i][1]].equals(naipeCarta[0])
                        || naipeCarta[cartasJog[i][1]].equals(naipeCarta[2])) {
                    setColor(1);
                } else {
                    setColor(0);
                }
                System.out.println(i + " - " + numeroCarta[cartasJog[i][0]] + " de " + naipeCarta[cartasJog[i][1]]);
            }
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
                s = "[33m";// amarelo
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