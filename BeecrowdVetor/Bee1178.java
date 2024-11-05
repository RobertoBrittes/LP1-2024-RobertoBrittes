package BeecrowdVetor;

import java.util.Scanner;

public class Bee1178 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        double[] vet = criarVetor(100);
        double numInicial = lerNumDouble();

        vet[0] = numInicial;
        vet = encontrarValoresVetor(vet);

        imprimirVetor(vet);
    }

    public static double[] encontrarValoresVetor(double[] vet) {
        for (int i = 1; i < vet.length; i++) {
            vet[i] = vet[i - 1] / 2;
        }
        return vet;
    }

    public static void imprimirVetor(double[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("N[%d] = %.4f\n", i, vetor[i]);
        }
    }

    public static double lerNumDouble() {
        return Sc.nextDouble();
    }

    public static double[] criarVetor(int tamVet) {
        double[] vetor = new double[tamVet];
        return vetor;
    }

}