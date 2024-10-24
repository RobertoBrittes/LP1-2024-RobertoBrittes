package vetor;

import java.util.Scanner;

public class ex1_vetor {

    final static Scanner LER = new Scanner(System.in);

    public static void main(String[] args) {

        int n = 0;
        float media = 0f;
        float maiorNota = 0f;
        int indiceMaiorNota = 0;
        float menorNota = 0f;
        int indiceMenorNota = 0;

        n = lerN();

        int[] vetorNotas = new int[n];

        vetorNotas = lerNotas(vetorNotas);

        imprimirVetor(vetorNotas);

        media = calcularMedia(vetorNotas);

        maiorNota = encontrarMaiorNota(vetorNotas);
        indiceMaiorNota = encontrarIndiceMaiorNota(vetorNotas, maiorNota);

        menorNota = encontrarMenorNota(vetorNotas);
        indiceMenorNota = encontrarIndiceMenorNota(vetorNotas, indiceMenorNota);

        imprimir(media + "");
        imprimir(maiorNota + "");
        imprimir(indiceMaiorNota + "");
        imprimir(menorNota + "");
        imprimir(indiceMenorNota + "");

    }

    public static int encontrarMaiorNota(int[] vetorNotas) {
        int maiorNota = vetorNotas[0];
        for (int i = 1; i < vetorNotas.length; i++) {
            maiorNota = Math.max(maiorNota, vetorNotas[i]);
        }
        return maiorNota;
    }

    public static int encontrarIndiceMaiorNota(int[] vetorNotas, float maiorNota) {
        int indiceMaiorNota = 0;
        for (int i = 1; i < vetorNotas.length; i++) {
            if (vetorNotas[i] == maiorNota) {
                indiceMaiorNota = i;
                break;
            }
        }
        return indiceMaiorNota;
    }

    public static int encontrarMenorNota(int[] vetorNotas) {
        int menorNota = vetorNotas[0];
        for (int i = 1; i < vetorNotas.length; i++) {
            menorNota = Math.min(menorNota, vetorNotas[i]);
        }
        return menorNota;
    }

    public static int encontrarIndiceMenorNota(int[] vetorNotas, float menorNota) {
        int indiceMenorNota = 0;
        for (int i = 1; i < vetorNotas.length; i++) {
            if (vetorNotas[i] == menorNota) {
                indiceMenorNota = i;
                break;
            }
        }
        return indiceMenorNota;
    }

    public static void imprimir(String string) {
        System.out.println(string);
    }

    public static int somarNotas(int[] vetorNotas) {
        int soma = 0;
        for (int i = 0; i < vetorNotas.length; i++) {
            soma += vetorNotas[i];
        }
        return soma;
    }

    public static float calcularMedia(int[] vetorNotas) {
        float media = 0f;
        int soma = 0;
        soma = somarNotas(vetorNotas);
        media = soma / (float) vetorNotas.length;
        return media;
    }

    public static int[] lerNotas(int[] vetorNotas) {

        for (int i = 0; i < vetorNotas.length; i++) {
            System.out.println("Nota " + (i + 1) + ": ");
            vetorNotas[i] = lerNota();
        }

        return vetorNotas;

    }

    public static int lerNota() {
        int nota = 0;
        do {
            nota = LER.nextInt();
        } while (nota < 0 || nota > 10);
        return nota;
    }

    public static void imprimirVetor(int[] vetorNotas) {
        for (int i = 0; i < vetorNotas.length; i++) {
            System.out.println("Nota " + (i + 1) + ": " + vetorNotas[i]);
        }
    }

    public static int lerN() {
        int n = 0;

        do {
            System.out.println("N=");
            n = LER.nextInt();
        } while (n <= 0 || n > 10);

        return n;
    }

}