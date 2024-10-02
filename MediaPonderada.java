import java.util.Scanner;

public class MediaPonderada {
    
    final static Scanner Sc = new Scanner(System.in);
    public static void main(String[] args) {
        int qtdAlunos = lerNumInt();
        final int peso1 = 2;
        final int peso2 = 3;
        final int peso3 = 5;
        float nota1 = 0f;
        float nota2 = 0f;
        float nota3 = 0f;
        float media = 0f;

        for (int i = 0; i < qtdAlunos; i++) {
            nota1 = lerNumFloat();
            nota2 = lerNumFloat();
            nota3 = lerNumFloat();
            media = calcularMedia(peso1, peso2, peso3, nota1, nota2, nota3);
        }
    }

    public static float calcularMedia(int peso1, int peso2, int peso3, float nota1, float nota2, float nota3) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularMedia'");
    }

    public static float lerNumFloat() {
        return Sc.nextFloat();
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}
