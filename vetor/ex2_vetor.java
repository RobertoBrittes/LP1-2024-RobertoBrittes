package vetor;

import java.util.Scanner;

public class ex2_vetor {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = lerNumInt();
        int[] numeros = criarVetorInt(n);
        
        numeros = lerVetor(numeros);
        boolean[] ehPar = criarVetorBool(n);
        ehPar = verificarParImpar(numeros, ehPar);
        
        int[] qtdParImpar = criarVetorInt(2);
        qtdParImpar = verificarQtdParImpar(numeros, ehPar, qtdParImpar);

        imprimirParImpar(qtdParImpar);

    }

    private static void imprimirParImpar(int[] qtdParImpar) {
        for (int i = 0; i < qtdParImpar.length; i++) {
            System.out.print(qtdParImpar[i] + " ");
        }
        System.out.println();
    }

    public static int[] verificarQtdParImpar(int[] numeros, boolean[] ehPar, int[] qtdParImpar) {
        //index 0 é par, index 1 é impar
        for (int i = 0; i < numeros.length; i++) {
            if (ehPar[i] == true) {
                qtdParImpar[0]++;
            } else {
                qtdParImpar[1]++;
            }
        }
        return qtdParImpar;
    }

    public static boolean[] verificarParImpar(int[] numeros, boolean[] ehPar) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                ehPar[i] = true;
            } else {
                ehPar[i] = false;
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
