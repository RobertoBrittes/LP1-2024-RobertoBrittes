import java.util.Scanner;

public class Bee_1214 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int qtdTestes = lerNumInt();
        float mediaTurma = 0;
        float percentualAcimaMedia = 0f;
        int qtdAcimaMedia = 0;
        int qtdPessoasTurma = 0;
        int soma = 0;
        int[] nota;

        for (int i = 0; i < qtdTestes; i++) {
            soma = 0;
            qtdPessoasTurma = lerNumInt();
            nota = lerVetor(qtdPessoasTurma);
            for (int j = 0; j < nota.length; j++) {
                soma += nota[j];
            }
            mediaTurma = calcularMediaTurma(soma, qtdPessoasTurma);
            qtdAcimaMedia = verificarAcimaMedia(nota, mediaTurma);
            percentualAcimaMedia = calcularpercentualAcimaMedia(qtdPessoasTurma, qtdAcimaMedia);
            System.out.printf("%.3f %s\n", percentualAcimaMedia, "%");
        }
    }

    public static int verificarAcimaMedia(int[] nota, float mediaTurma) {
        int qtdAcimaMedia = 0;
        for (int i = 0; i < nota.length; i++) {
            if (nota[i] > mediaTurma) {
                qtdAcimaMedia++;
            }
        }
        return qtdAcimaMedia;
    }

    public static float calcularMediaTurma(int soma, int qtdPessoasTurma) {
        float mediaTurma = 0f;
        mediaTurma = (float)soma/qtdPessoasTurma;
        return mediaTurma;
    }
    
    public static float calcularpercentualAcimaMedia(int qtdPessoasTurma, int qtdAcimaMedia) {
        float percentualAcimaMedia = 0f;
        percentualAcimaMedia = (float)(qtdPessoasTurma/qtdAcimaMedia)*100;
        return percentualAcimaMedia;
    }

    public static int[] lerVetor(int qtdPessoasTurma) {
        int[] vetor = new int[qtdPessoasTurma];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = lerNumInt();
        }
        return vetor;
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}