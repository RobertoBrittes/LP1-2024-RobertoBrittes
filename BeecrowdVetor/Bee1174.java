package BeecrowdVetor;

import java.util.Scanner;

public class Bee1174 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        float[] valores = criarVetor(100);

        valores = lerVetFloat(valores);

        imprimirVetor(valores);
    }

    public static void imprimirVetor(float[] valores) {
            for (int i = 0; i < valores.length; i++) {
                if (valores[i] <= 10) {
                    System.out.printf("A[%d] = %.1f\n", i, valores[i]);
            }
        }
    }

    public static float[] criarVetor(int tamVet) {
        float[] vetor = new float[tamVet];
        return vetor;
    }

    public static float[] lerVetFloat(float[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = lerNumFloat();
        }
        return vetor;
    }

    public static float lerNumFloat() {
        return Sc.nextFloat();
    }
}
