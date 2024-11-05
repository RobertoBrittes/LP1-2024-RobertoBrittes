package BeecrowdVetor;

import java.util.Scanner;

public class Bee1173 {
    final static Scanner Sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] vet = criarVetor(10);
        int numInicial = lerNumInt();
        
        vet[0] = numInicial;
        vet = encontrarValoresVetor(vet);

        imprimirVetor(vet);
    }

    public static int[] encontrarValoresVetor(int[] vet) {
        for (int i = 1; i < vet.length; i++) {
            vet[i] = vet[i-1]*2;
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
        } while (valor > 50);
        return valor;
    }

    public static int[] criarVetor(int tamVet) {
        int[] vetor = new int[tamVet];
        return vetor;
    }
    
}