import java.util.Scanner;

public class MediaPonderada {

    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int qtdAlunos = lerNumInt();
        final int PESO_1 = 2;
        final int PESO_2 = 3;
        final int PESO_3 = 5;
        float nota1 = 0f;
        float nota2 = 0f;
        float nota3 = 0f;
        float media = 0f;

        for (int i = 0; i < qtdAlunos; i++) {
            nota1 = lerNumFloat();
            nota2 = lerNumFloat();
            nota3 = lerNumFloat();
            media = calcularMedia(PESO_1, PESO_2, PESO_3, nota1, nota2, nota3);
            System.out.printf("%.1f\n", media);
        }
    }

    public static float calcularMedia(int PESO_1, int PESO_2, int PESO_3, float nota1, float nota2, float nota3) {
        float media = 0f;
        media = ((nota1 * PESO_1) + (nota2 * PESO_2) + (nota3 * PESO_3)) / (PESO_1 + PESO_2 + PESO_3);
        return media;
    }

    public static float lerNumFloat() {
        return Sc.nextFloat();
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}
