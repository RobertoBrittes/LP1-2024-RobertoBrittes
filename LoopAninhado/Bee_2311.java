import java.util.Scanner;

public class Bee_2311 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int qtdCompetidores = (int) lerNumFloat();
        String nome = null;
        float dificuldadeSalto = 0;
        final int QTD_SALTOS = 7;
        float menorNota = 11f;
        float maiorNota = -1f;
        float notaSalto = 0f;
        float soma = 0f;

        for (int i = 0; i < qtdCompetidores; i++) {
            menorNota = 11;
            maiorNota = -1;
            soma = 0;
            nome = lerString();
            dificuldadeSalto = lerNumFloat();
            for (int cont = 0; cont < QTD_SALTOS; cont++) {
                notaSalto = lerNumFloat();
                soma += notaSalto;
                menorNota = Math.min(menorNota, notaSalto);
                maiorNota = Math.max(maiorNota, notaSalto);
            }
            soma -= menorNota;
            soma -= maiorNota;
            soma *= dificuldadeSalto;
            System.out.print(nome);
            System.out.printf(" %.2f\n", soma);
        }

    }

    public static String lerString() {
        return Sc.next();
    }

    public static float lerNumFloat() {
        return Sc.nextFloat();
    }
}