package vetor;

import java.util.Scanner;

public class ex1_vetor {

    final static Scanner LER = new Scanner(System.in);

    public static void main(String[] args) {

        int n = 0;
        float media = 0f;

        n = lerN();

        int[] vetorNotas = new int[n];

        vetorNotas = lerNotas(vetorNotas);

        imprimirVetor(vetorNotas);

        media = calcularMedia(vetorNotas);

        imprimir(media + "");

    }

    public static int encontrarMaiorNota(int[] vetorNotas) {
        int maiorNota = vetorNotas[0];
        for (int i = 1; i < vetorNotas.length; i++) {
            maiorNota = Math.max(maiorNota, vetorNotas[i]);
        }
        return maiorNota;
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
        media = soma/(float)vetorNotas.length;
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