
import java.util.Scanner;

public class Bee_1160 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int qtdTestes = (int) lerNumFloat();
        int anos = 0;
        int popA = 0;
        int popB = 0;
        float crescimentoA = 0f;
        float crescimentoB = 0f;

        for (int i = 0; i < qtdTestes; i++) {
            popA = (int) lerNumFloat();
            popB = (int) lerNumFloat();
            crescimentoA = lerNumFloat();
            crescimentoB = lerNumFloat();

            anos = calcularTempo(popA, popB, crescimentoA, crescimentoB);
            if (anos > 100) {
                System.out.println("Mais de 1 seculo.");
            } else {
                System.out.println(anos + " anos.");
            }
        }
    }

    public static int calcularTempo(int popA, int popB, float crescimentoA, float crescimentoB) {
        int anos = 0;
        while (popA <= popB) {
            popA += (int) (popA * (crescimentoA / 100));
            popB += (int) (popB * (crescimentoB / 100));
            anos++;

            if (anos > 100) {
                break;
            }
        }
        return anos;
    }

    public static float lerNumFloat() {
        return Sc.nextFloat();
    }
}
