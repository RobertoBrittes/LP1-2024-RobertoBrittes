package TCA;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Truco {
    final static Scanner Sc = new Scanner(System.in);
    final static Random rand = new Random();

    public static void main(String[] args) {
        limparTela();

        int[] pontuacaoJogo = criarVetorInt(2); // indice 0, é a pontuacão do jogador, indice 1 do computador

        char[] numeroCarta = criarVetorChar(10);
        numeroCarta = preencherCaractereCarta(numeroCarta);
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

        String vencedor = null;
        String perdedor = null;

        do {
            imprimirMenuIni();

            while (pontuacaoJogo[0] < 12 && pontuacaoJogo[1] < 12) {
                cartasBaralho = incicializarMatriz(cartasBaralho, true);

                cartasJog = distribuirCartas(cartasJog, cartasBaralho);
                cartaDiponivelJog = incicializarVetBool(true, cartaDiponivelJog);
                cartasBaralho = marcarCartasDistribuidas(cartasJog, cartasBaralho);

                cartasPc1 = distribuirCartas(cartasPc1, cartasBaralho);
                cartaDiponivelPc = incicializarVetBool(true, cartaDiponivelPc);
                cartasBaralho = marcarCartasDistribuidas(cartasPc1, cartasBaralho);

                jogarTento(pontuacaoJogo, cartasJog, cartasPc1, numeroCarta, naipeCarta, cartaDiponivelJog,
                        cartaDiponivelPc);
            }

            if (pontuacaoJogo[0] > pontuacaoJogo[1]) {
                vencedor = "Jogador";
                perdedor = "Computador";
            } else {
                vencedor = "Computador";
                perdedor = "Jogador";
            }
            imprimirVencedor(vencedor, perdedor, pontuacaoJogo);

        } while (pedirSeDesejaJogarNovamente() == 1);
        imprimirEncerramento();

    }

    public static void imprimirEncerramento() {
        limparTela();
        System.out.println("Obrigado por jogar truco, volte sempre!");
        System.out.print("Desenvolvido por: ");
        setColor(4);
        System.out.println("Roberto Brittes Gebauer");
        setColor(-1);
        System.out.print("Efeito sonoro do truco feito por: ");
        setColor(5);
        System.out.println("Murilo Senchechem(Xenxem)");
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        setColor(0);
        System.out.println("Tempo de desenvolvimento: 38h");

    }

    public static int[] jogarTento(int[] pontuacaoJogo, int[][] cartasJog, int[][] cartasPc1,
            char[] numeroCarta,
            String[] naipeCarta, boolean[] cartaDiponivelJog, boolean[] cartaDiponivelPc) {

        String vencedorRodada = "jogador";
        String jogadorNaVez = "jogador";

        int rodadaGanhaJog = 0;
        int rodadaGanhaPc = 0;

        int cartaSelecionada = 0;

        boolean trucado = false;

        int[] cartaJogadaJog = criarVetorInt(2);
        int[] cartaJogadaPc = criarVetorInt(2);

        while (rodadaGanhaJog < 2 && rodadaGanhaPc < 2) {
            setColor(6);
            imprimirPlacarRodadaPorRodada(rodadaGanhaJog, rodadaGanhaPc, pontuacaoJogo);

            imprimirCartaJogador(cartasJog, numeroCarta, naipeCarta, cartaDiponivelJog);
            setColor(-1);

            if (vencedorRodada.equals("jogador")) {
                jogadorNaVez = "jogador";
                if (trucado == false) {
                    trucado = pedirTruco(jogadorNaVez);
                    if (trucado) {
                        trucado = aceitarCorrerTruco(jogadorNaVez);
                        if (!trucado) {
                            pontuacaoJogo[0]++;
                            vencedorRodada = "jogador";
                            break;
                        }
                    }
                }
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
                if (trucado == false) {
                    trucado = pedirTruco(jogadorNaVez);
                    if (trucado) {
                        trucado = aceitarCorrerTruco(jogadorNaVez);
                        if (!trucado) {
                            pontuacaoJogo[1]++;
                            vencedorRodada = "computador";
                            break;
                        }
                    }
                }
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
                if (trucado == false) {
                    trucado = pedirTruco(jogadorNaVez);
                    if (trucado) {
                        trucado = aceitarCorrerTruco(jogadorNaVez);
                        if (!trucado) {
                            pontuacaoJogo[1]++;
                            vencedorRodada = "computador";
                            break;
                        }
                    }
                }
                do {
                    cartaSelecionada = rand.nextInt(3);
                    cartaJogadaPc = jogarCarta(cartaJogadaPc, cartasPc1, jogadorNaVez, cartaDiponivelPc,
                            cartaSelecionada);
                } while (!cartaDiponivelPc[cartaSelecionada]);
                cartaDiponivelPc[cartaSelecionada] = false;
                imprimirCartaJogada(cartaJogadaPc, numeroCarta, naipeCarta,
                        "Pc");
                setColor(-1);

                jogadorNaVez = "jogador";
                if (trucado == false) {
                    trucado = pedirTruco(jogadorNaVez);
                    if (trucado) {
                        trucado = aceitarCorrerTruco(jogadorNaVez);
                        if (!trucado) {
                            pontuacaoJogo[0]++;
                            vencedorRodada = "jogador";
                            break;
                        }
                    }
                }
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
                rodadaGanhaJog++;
                rodadaGanhaPc++;
            }

            if (rodadaGanhaJog == 2) {
                if (trucado) {
                    pontuacaoJogo[0] += 3;
                } else {
                    pontuacaoJogo[0]++;
                }
                break;
            }
            if (rodadaGanhaPc == 2) {
                if (trucado) {
                    pontuacaoJogo[1] += 3;
                } else {
                    pontuacaoJogo[1]++;
                }
                break;
            }

        }
        return pontuacaoJogo;
    }

    public static void imprimirVencedor(String vencedor, String perdedor, int[] pontuacaoJogo) {
        System.out
                .println(vencedor + " venceu " + perdedor + " pelo placar de:\n" + pontuacaoJogo[0] + " X "
                        + pontuacaoJogo[1]);
    }

    // define a cor que a carta vai ser impressa
    public static void definirCorPorNaipe(String naipe) {
        if (naipe.equals("OUROS") || naipe.equals("COPAS")) {
            setColor(1); // vermelho
        } else {
            setColor(0); // preto
        }
    }

    public static int pedirSeDesejaJogarNovamente() {
        int n = 0;
        System.out.println("Deseja jogar novamente?\n0 - Não\n1 - Sim");
        do {
            n = lerNumInt();
        } while (n != 0 && n != 1);
        return n;
    }

    public static int lerDesejaPedirTruco(String jogadorNaVez) {
        int n = 0;
        if (jogadorNaVez.equals("jogador")) {
            do {
                n = lerNumInt();
            } while (n < 0 || n > 1);
        } else {
            n = rand.nextInt(2);
        }
        return n;
    }

    public static void imprimirEsolhaPedirTruco() {
        System.out.println("Deseja trucar?\n0 - Não\n1 - Sim\n");
    }

    public static boolean pedirTruco(String jogadorNaVez) {
        boolean trucado = false;
        if (jogadorNaVez.equals("jogador")) {
            imprimirEsolhaPedirTruco();
        }
        switch (lerDesejaPedirTruco(jogadorNaVez)) {
            case 0:
                trucado = false;
                break;

            case 1:
                trucado = true;
                imprimirTruco();
                if (rand.nextInt(10) == 3) {
                    tocarSomTruco();
                }
                break;
        }
        return trucado;
    }

    public static void tocarSomTruco() {
        tocarSom("somTruco.wav");
    }

    public static void tocarSom(String caminhoArquivoSom) {

        try {
            // Abrindo o arquivo de som
            File soundFile = new File(caminhoArquivoSom);
            if (!soundFile.exists()) {
                System.out.println("Arquivo de som não encontrado: " + caminhoArquivoSom);
                return;
            }

            // Criando um AudioInputStream
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

            // Obtendo as informações do formato de áudio
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);

            // Criando o Clip e carregando o áudio
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);

            // Tocando o áudio
            // System.out.println("Tocando som...");
            audioClip.start();

            // Mantendo o programa ativo enquanto o som toca
            Thread.sleep(audioClip.getMicrosecondLength() / 1000);

            // Liberando recursos
            audioClip.close();
            audioStream.close();
            // System.out.println("Som finalizado.");
        } catch (UnsupportedAudioFileException e) {
            System.err.println("O formato de áudio não é suportado.");
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.err.println("Linha de áudio não disponível.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de áudio.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("O programa foi interrompido.");
            e.printStackTrace();
        }
    }

    public static void imprimirPlacarRodadaPorRodada(int rodadaGanhaJog, int rodadaGanhaPc, int[] pontuacaoJogo) {
        System.out.println();
        System.out.println("Pontuação - Tentos");
        System.out.println("Jogador X Computador\n" + //
                "   " + pontuacaoJogo[0] + "          " + pontuacaoJogo[1] + "\n");

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
        definirCorPorNaipe(naipeCarta[cartaJogada[1]]);
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

    // brute force para colocar os naipes no vetor
    public static String[] preencherNaipeCarta(String[] naipeCarta) {
        naipeCarta[0] = "OUROS";
        naipeCarta[1] = "ESPADAS";
        naipeCarta[2] = "COPAS";
        naipeCarta[3] = "PAUS";

        return naipeCarta;
    }

    // brute force para colocar o caractere da carta no vetor
    public static char[] preencherCaractereCarta(char[] numeroCarta) {

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
                definirCorPorNaipe(naipeCarta[cartasJog[i][1]]);
                System.out.println(i + " - " + numeroCarta[cartasJog[i][0]] + " de " + naipeCarta[cartasJog[i][1]]);
            }
        }
        System.out.println();
    }

    public static void imprimirMenuIni() {
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

    public static boolean aceitarCorrerTruco(String jogadorNaVez) {
        boolean trucado = false;
        if (jogadorNaVez.equals("jogador")) {
            if (rand.nextInt(2) == 1) {
                trucado = true;
                System.out.println("Computador aceitou o truco\n");
            } else {
                System.out.println("Computador correu...");
                trucado = false;
            }
        } else {
            System.out.println("Computador trucou, deseja aceitar?\n0 - Não\n1 - Sim\n");
            if (lerAceitarOuCorrer() == 1) {
                trucado = true;
            } else {
                trucado = false;
            }
        }
        return trucado;
    }

    public static int lerAceitarOuCorrer() {
        int n = 0;
        do {
            n = lerNumInt();
        } while (n < 0 || n > 1);
        return n;
    }

}