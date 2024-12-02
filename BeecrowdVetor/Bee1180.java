package BeecrowdVetor;


import java.util.Scanner;

public class Bee1180 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] valores = criarVetorInt(lerN());
        int[] indiceMenorValor = criarVetorInt(2);
        valores = lerVetor(valores);

        indiceMenorValor = encontrarMenorValor(valores, indiceMenorValor);

        System.out.printf("Menor valor: %d\nPosicao: %d\n", indiceMenorValor[0], indiceMenorValor[1]);
    }

    public static int lerN() {
        int valor = 0;
        do {
            valor = Sc.nextInt();
        } while (valor < 1 || valor > 1000);
        return valor;
    }

    public static int[] lerVetor(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = lerNumInt();
        }
        return vet;

    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }

    public static int[] criarVetorInt(int n) {
        return new int[n];
    }

    public static int[] encontrarMenorValor(int[] valores, int[] indiceMenorValor) {
        indiceMenorValor[0] = valores[0];
        for (int i = 1; i < valores.length; i++) {
            if (valores[i] < indiceMenorValor[0]) {
                indiceMenorValor[0] = valores[i];
                indiceMenorValor[1] = i;
            }
        }
        return indiceMenorValor;
    }
}
