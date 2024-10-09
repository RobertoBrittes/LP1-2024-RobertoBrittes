import java.util.Scanner;

public class Bee_1397 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int qtdRodadas = 0;
        int ptsJogadorA = 0;
        int ptsJogadorB = 0;
        int jogadaA = 0;
        int jogadaB = 0;

        while (true) {
            ptsJogadorA = 0;
            ptsJogadorB = 0;
            qtdRodadas = lerNumInt();
            if (qtdRodadas == 0) {
                break;
            }
            for (int i = 0; i < qtdRodadas; i++) {
                jogadaA = lerNumInt();
                jogadaB = lerNumInt();
                if (jogadaA > jogadaB) {
                    ptsJogadorA++;
                } else if (jogadaB > jogadaA) {
                    ptsJogadorB++;
                }
            }
            System.out.println(ptsJogadorA + " " + ptsJogadorB);
        }
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}

