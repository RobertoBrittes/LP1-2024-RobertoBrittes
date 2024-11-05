package BeecrowdVetor;

import java.util.Scanner;

public class Bee1177 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] vet = criarVetor(1000);
        int valorT = lerNumInt();

        vet = encontrarValoresVetor(vet, valorT);
        
        imprimirVetor(vet);
    }

    public static int[] encontrarValoresVetor(int[] vet, int valorT) {
        int j = 0;
        for (int i = 0; i < vet.length; i++) {
            if (j == valorT) {
                j = 0;
            }
            vet[i] = j;
            j++;
        }
        return vet;
    }

    public static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("N[" + i + "] = " + vetor[i]);
        }
    }
    public static int lerNumInt() {
        int valor = 0;
        do {
            valor = Sc.nextInt();
        } while (valor > 50 || valor < 2);
        return valor;
    }

    public static int[] criarVetor(int tamVet) {
        int[] vetor = new int[tamVet];
        return vetor;
    }
}
