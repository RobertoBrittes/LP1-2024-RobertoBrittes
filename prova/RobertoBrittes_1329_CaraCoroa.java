package prova;

// Prof. Odair - 16:51
import java.util.Scanner;

public class RobertoBrittes_1329_CaraCoroa {

    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        // inicialização de variaveis
        int qtdJogadas = 0;
        int maria = 0;
        int joao = 0;
        int moeda = 0;
        boolean ehZero = false;

        while (true) {
            do {
                qtdJogadas = lerNumInt();
            } while (qtdJogadas <= 0 || qtdJogadas > 1000); // fazer a validação no método

            if (qtdJogadas == 0) { // verifica se o programa deve encerrar
                break;
            }

            maria = 0; // zera as pontuações
            joao = 0;

            for (int i = 0; i < qtdJogadas; i++) {
                do {
                    moeda = lerNumInt();
                } while (moeda > 1 || moeda < 0);
                
                ehZero = verificarCaraCoroa(moeda); // verifica se é zero ou um
                
                if (ehZero) { // verifica para quem vai a pontuação
                    maria++;
                } else {
                    joao++;
                }
            }
            imprimir("Mary won " + maria + " times and John won " + joao + " times"); // imprime a qtd de vitorias de
                                                                                      // cada
        }
    }

    // metodo para verificar se é zero ou um
    public static boolean verificarCaraCoroa(int moeda) {
        boolean ehZero = false;
        if (moeda == 0) {
            ehZero = true;
        }
        return ehZero;
    }

    // metodo para imprimir
    public static void imprimir(String string) {
        System.out.println(string);
    }

    // metodo para ler num inteiro
    public static int lerNumInt() {
        int valorInt = 0;
        valorInt = Sc.nextInt();
        return valorInt;
    }
}
/*
 * Conceito A
 * 
 * Melhorar a separação dos métodos.
 * Fazer as validações no métodos.
 * 
 */