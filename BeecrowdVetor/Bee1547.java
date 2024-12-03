package BeecrowdVetor;

import java.util.Scanner;

public class Bee1547 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] ganhador = criarVetorInt(2);
        int[] numEscolhidoAluno;
        int numSecreto = 0;
        int qtdCamisetas = lerNumInt();

        for (int i = 0; i < qtdCamisetas; i++) {
            numEscolhidoAluno = criarVetorInt(lerQtdAlunos());
            numSecreto = lerNumSecretoOuEscolhido();
            numEscolhidoAluno = lerVetor(numEscolhidoAluno);
            ganhador = verificarGanhador(ganhador, numEscolhidoAluno, numSecreto);
            System.out.println((ganhador[0]+1));
        }

    }

    public static int[] verificarGanhador(int[] ganhador, int[] numEscolhidoAluno, int numSecreto){
        ganhador[0] = 0;
        ganhador[1] = Math.abs(numEscolhidoAluno[0] - numSecreto);
        for (int i = 1; i < numEscolhidoAluno.length; i++) {
            if (Math.abs(numEscolhidoAluno[i] - numSecreto) < ganhador[1]) {
                ganhador[0] = i;
                ganhador[1] = Math.abs(numEscolhidoAluno[i] - numSecreto);
            }
        }
        return ganhador;
    }

    public static int[] lerVetor(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = lerNumSecretoOuEscolhido();
        }
        return vet;
    }

    public static int lerNumSecretoOuEscolhido() {
        int num = 0;
        do {
            num = Sc.nextInt();
        } while (num < 1 || num > 100);
        return num;
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }

    public static int lerQtdAlunos() {
        int qtdAlunos = 0;
        do {
            qtdAlunos = Sc.nextInt();
        } while (qtdAlunos < 4 || qtdAlunos > 10);
        return qtdAlunos;
    }

    public static int[] criarVetorInt(int n) {
        return new int[n];
    }
}