
import java.util.Scanner;

public class Bee_2310 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int totalSaques = 0;
        int totalSaquesCorretos = 0;
        int totalBloqueios = 0;
        int totalBloqueiosCorretos = 0;
        int totalAtaques = 0;
        int totalAtaquesCorretos = 0;
        float percentualSaques = 0f;
        float percentualBloqueios = 0f;
        float percentualAtaques = 0f;
        String nome = null;
        int qtdJogadores = lerNumInt();

        for (int i = 0; i < qtdJogadores; i++) {
            Sc.nextLine();
            nome = Sc.nextLine();
            totalSaques += lerNumInt();
            totalBloqueios += lerNumInt();
            totalAtaques += lerNumInt();

            totalSaquesCorretos += lerNumInt();
            totalBloqueiosCorretos += lerNumInt();
            totalAtaquesCorretos += lerNumInt();

        }
        percentualSaques = calcularPercentual(totalSaquesCorretos, totalSaques);
        percentualBloqueios = calcularPercentual(totalBloqueiosCorretos, totalBloqueios);
        percentualAtaques = calcularPercentual(totalAtaquesCorretos, totalAtaques);

        System.out.printf("Pontos de Saque: %.2f %%.\n", percentualSaques);
        System.out.printf("Pontos de Bloqueio: %.2f %%.\n", percentualBloqueios);
        System.out.printf("Pontos de Ataque: %.2f %%.\n", percentualAtaques);
    }

    public static float calcularPercentual(int inteiro, int inteiro2) {
        float percentual = 0f;
        percentual = (float) (inteiro * 100.0) / inteiro2;
        return percentual;
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}
