package BeecrowdVetor;

import java.util.Scanner;

public class Bee1175 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] valores = criarVetor(20);
        valores = lerVetInt(valores);

        valores = inverterPosVetor(valores);

        imprimirVetor(valores);
    }
    
    public static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("N[%d] = %d\n", i, vetor[i]);
        }
    }

    public static int[] inverterPosVetor(int[] valores) {
        int valorX = 0;
        for (int i = 0; i < valores.length; i++) {
            if (i == 10) {
                break;
            }

            valorX = valores[i];

            valores[i] = valores[(valores.length - 1) - i];
            valores[(valores.length - 1) - i] = valorX;

        }
        return valores;
    }

    public static int[] criarVetor(int tamVet) {
        int[] vetor = new int[tamVet];
        return vetor;
    }

    public static int[] lerVetInt(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = lerNumInt();
        }
        return vetor;
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}
