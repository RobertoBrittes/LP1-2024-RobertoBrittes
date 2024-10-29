
package vetor;

import java.util.Random;
import java.util.Scanner;

public class Ex4_vetor {
    final static Scanner Sc = new Scanner(System.in);
    final static Random Rand = new Random();

    public static void main(String[] args) {
        int n = lerNumInt();
        int[] vet1 = criarVetorInt(n);
        n = lerNumInt();
        int[] vet2 = criarVetorInt(n);
        int[] vet3 = criarVetorInt(vet1.length + vet2.length);

        vet1 = lerVet1(vet1);
        vet2 = lerVet2(vet2);

        vet3 = concatenarVetores(vet1, vet2, vet3);

        imprimirValoresConcatenados(vet3);

    }

    public static int[] lerVet1(int[] vet1) {
        for (int i = 0; i < vet1.length; i++) {
            vet1[i] = gerarNum();
        }
        return vet1;
    }

    public static int[] lerVet2(int[] vet2) {
        for (int i = 0; i < vet2.length; i++) {
            vet2[i] = gerarNum();
        }
        return vet2;
    }

    public static void imprimirValoresConcatenados(int[] vet3) {
        for (int i = 0; i < vet3.length; i++) {
            System.out.print(vet3[i] + " ");
        }
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
