import java.util.Scanner;

public class CaraCoroa {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int qtdJogadas = 0;
        int maria = 0;
        int joao = 0;
        int moeda = 0;

        while (true) {
            qtdJogadas = lerNumInt();
            
            if (qtdJogadas == 0) {
                break;
            }

            maria = 0;
            joao = 0;

            for (int i = 0; i < qtdJogadas; i++) {
                moeda = lerNumInt();

                switch (moeda) {
                    case 0:
                        maria++;
                        break;

                    case 1:
                        joao++;
                        break;
                }
            }
            imprimir("Mary won " + maria + " times and John won " + joao + " times");
        }
    }

    public static void imprimir(String string) {
        System.out.println(string);
    }

    public static int lerNumInt() {
        int valorInt = 0;
        valorInt = Sc.nextInt();
        return valorInt;
    }
}