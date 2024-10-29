package vetor;

import java.util.Random;
import java.util.Scanner;

public class Ex3_vetor {
    final static Scanner Sc = new Scanner(System.in);
    final static Random Rand = new Random();
    public static void main(String[] args) {
        int n = lerNumInt();
        int[] numeros = criarVetorInt(n);
        int x = 0;
        int[] posicaoVet = criarVetorInt(2);

        numeros = lerVetor(numeros);

        x = lerNumInt();

        posicaoVet = encontrarPosVetor(numeros, x, posicaoVet);

        imprimirPosicaoVetor(posicaoVet);

    }

    public static int gerarNum() {
        int num = 0;
        num = Rand.nextInt(19700621);
        return num;
    }

    public static void imprimirPosicaoVetor(int[] posicaoVet) {
        for (int i = 0; i < posicaoVet.length; i++) {
            System.out.print(posicaoVet[i] + " ");
        }
        System.out.println();
    }

    public static int[] encontrarPosVetor(int[] numeros, int x, int[] posicaoVet) {
        for (int i = 0; i < posicaoVet.length; i++) {
            if (numeros[i] == x) {
                posicaoVet[0] = i;
                posicaoVet[1] = numeros[i];
            }
        }
        return posicaoVet;
    }

    public static int lerNumInt() {
        int n = 0;

            n = Sc.nextInt();

        return n;
    }

    public static int[] criarVetorInt(int n) {
        int[] vetorInt = new int[n];
        return vetorInt;
    }

    public static int[] lerVetor(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = gerarNum();
        }
        return numeros;
    }
}
