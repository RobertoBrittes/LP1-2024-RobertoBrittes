
// prof. Odair - 14:37
import java.util.Scanner;

public class RobertoBrittes_9999Frangolino {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int qtdFrangos = 0;
        int contLotes = 0;
        int qtdFrangao = 0;
        float porcentagemAcima = 0;
        float mediaPeso = 0f;
        float[] pesoFrango;

        while (true) {
            contLotes++;
            qtdFrangos = lerNumInt();

            if (qtdFrangos == 0) {
                break;
            }

            pesoFrango = criarVetorFloat(qtdFrangos);
            pesoFrango = lerVetFloat(pesoFrango);
            mediaPeso = calcularMedia(pesoFrango);
            qtdFrangao = contarQtdFrangao(mediaPeso, pesoFrango);
            porcentagemAcima = calcularPorcentagem(qtdFrangao, qtdFrangos);

            // colocar em um método para imprimir!
            System.out.printf("Lote %d\n", contLotes);
            System.out.printf("Média = %.2f\n", mediaPeso);
            System.out.printf("Frangão = %d\n", qtdFrangao);
            System.out.printf("Porcentagem acima = %.2f%%\n", porcentagemAcima);
            System.out.println();
        }
    }

    public static float calcularPorcentagem(int qtdFrangao, int qtdFrangos) {
        float porcentagemAcima = 0f;
        porcentagemAcima = ((float) qtdFrangao / qtdFrangos) * 100;
        return porcentagemAcima;
    }

    public static int contarQtdFrangao(float mediaPeso, float[] pesoFrango) {
        int qtdFrangao = 0;
        for (int i = 0; i < pesoFrango.length; i++) {
            if (pesoFrango[i] > mediaPeso) {
                qtdFrangao++;
            }
        }
        return qtdFrangao;
    }

    public static float calcularMedia(float[] pesoFrango) {
        float mediaPeso = 0f;
        float somaPeso = 0f;
        for (int i = 0; i < pesoFrango.length; i++) {
            somaPeso += pesoFrango[i];
        }
        mediaPeso = somaPeso / pesoFrango.length;
        return mediaPeso;
    }

    public static float[] lerVetFloat(float[] vet) {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = lerNumFloat();
        }
        return vet;
    }

    public static float[] criarVetorFloat(int n) {
        return new float[n];
    }

    public static int lerNumInt() {
        int valor = 0;
        do {
            valor = Sc.nextInt();
        } while (valor < 0 || valor > 10000);
        return valor;
    }

    public static float lerNumFloat() {
        float valorFloat = 0f;
        do {
            valorFloat = Sc.nextFloat();
        } while (valorFloat < 0);
        return valorFloat;
    }
}

/*
 * Conceito A
 */