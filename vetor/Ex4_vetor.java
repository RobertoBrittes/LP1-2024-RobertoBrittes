package vetor;

import java.util.Random;
import java.util.Scanner;

public class Ex4_vetor {
    final static Scanner Sc = new Scanner(System.in);
    final static Random Rand = new Random();

    public static void main(String[] args) {
        int n = lerNumInt();
        int pX = 0;
        int pY = 0;
        int[] vet1 = criarVetorInt(n);
        n = lerNumInt();
        int[] vet2 = criarVetorInt(n);
        int[] vet3 = criarVetorInt(vet1.length + vet2.length);
        int[] vetEntrelacado = criarVetorInt(vet1.length + vet2.length);
        int[] vetInvertido = criarVetorInt(vet1.length);

        vet1 = lerVet(vet1);
        vet2 = lerVet(vet2);

        imprimirVetInt(vet1);
        imprimirVetInt(vet2);

        vet3 = concatenarVetores(vet1, vet2, vet3);

        imprimirVetInt(vet3);

        vetEntrelacado = entrelacarVetor(vet1, vet2, vetEntrelacado);

        imprimirVetInt(vetEntrelacado);

        vetInvertido = inverterVet(vet1, vetInvertido);

        imprimirVetInt(vetInvertido);

        pX = lerNumInt();
        pY = lerNumInt();

        vet1 = trocarPosVet(vet1, pX, pY);

        imprimirVetInt(vet1);
    }

    public static int[] trocarPosVet(int[] vet1, int pX, int pY) {
        int valorIndicePX = 0;
        if (pX > 0 && pY > 0 && pX < vet1.length && pY < vet1.length && pX != pY) {
            valorIndicePX = vet1[pX];
            vet1[pX] = vet1[pY];
            vet1[pY] = valorIndicePX;
        }
        return vet1;
    }

    public static int[] inverterVet(int[] vet1, int[] vetInvertido) {
        int j = vet1.length;
        for (int i = 0; i < vetInvertido.length; i++) {
            j--;
            vetInvertido[i] = vet1[j];
        }
        return vetInvertido;
    }

    public static int[] entrelacarVetor(int[] vet1, int[] vet2, int[] vetEntrelacado) {
        int j = 0;
        for (int i = 0; i < vetEntrelacado.length; i++) {
            if (i % 2 == 0) {
                vetEntrelacado[i] = vet1[j];
            } else {
                vetEntrelacado[i] = vet2[j];
                j++;
            }
        }
        return vetEntrelacado;
    }

    public static int[] lerVet(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = gerarNum();
        }
        return vet;
    }

    public static void imprimirVetInt(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    public static int[] concatenarVetores(int[] vet1, int[] vet2, int[] vet3) {
        for (int i = 0; i < vet1.length; i++) {
            vet3[i] = vet1[i];
        }
        for (int i = 0; i < vet2.length; i++) {
            vet3[i + vet1.length] = vet2[i];
        }
        return vet3;
    }

    public static int lerNumInt() {
        int n = 0;
        n = Sc.nextInt();
        return n;
    }

    public static int gerarNum() {
        int num = 0;
        num = Rand.nextInt(100);
        return num;
    }

    public static int[] criarVetorInt(int n) {
        int[] vetorInt = new int[n];
        return vetorInt;
    }
}
