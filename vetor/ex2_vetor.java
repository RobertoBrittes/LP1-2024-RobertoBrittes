package vetor;

import java.util.Scanner;

public class ex2_vetor {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = lerNumInt();
        int[] numeros = criarVetorInt(n);
        int[] qtdParImpar = criarVetorInt(2);

        numeros = lerVetor(numeros);
        boolean[] ehPar = criarVetorBool(n);

        qtdParImpar = verificarQtdParImpar(n, numeros, ehPar, qtdParImpar);

    }

    public static int[] verificarQtdParImpar(int n, int[] numeros, boolean[] ehPar, int[] qtdParImpar) {
    
        for (int i = 0; i < numeros.length; i++) {
            if (ehPar[i] == true) {
                qtdParImpar[0]++;
            } else {
                qtdParImpar[1]++;
            }
        }
        return qtdParImpar;
    }

    public static boolean[] verificarParImpar (int[] numeros, int n, boolean[] ehPar) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                ehPar[i] = true;
            }
        }
        return ehPar;
    }

    public static boolean[] criarVetorBool(int n) {
        boolean[] vetorBool = new boolean[n];
        return vetorBool;
    }

    public static int lerNumInt() {
        int n = 0;
        do { 
            n = Sc.nextInt();
        } while (n < 1 || n > 50);
        return n;
    }

    public static int[] criarVetorInt(int n) {
        int[] vetorInt = new int[n];
        return vetorInt;
    }

    public static int[] lerVetor(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = lerNumInt();
        }
        return numeros;
    }
}
