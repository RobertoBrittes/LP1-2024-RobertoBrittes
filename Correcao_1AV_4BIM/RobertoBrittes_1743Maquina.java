
// prof. Odair - 14:37
import java.util.Scanner;

public class RobertoBrittes_1743Maquina {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] conector1 = criarVetorInt(5);
        int[] conector2 = criarVetorInt(5);
        char compativel = 'Y';

        conector1 = lerVetorInt(conector1);
        conector2 = lerVetorInt(conector2);

        compativel = verificarCompatibilidade(conector1, conector2);

        imprimir(compativel);
    }

    public static char verificarCompatibilidade(int[] conector1, int[] conector2) {
        char compativel = 'Y';
        for (int i = 0; i < conector2.length; i++) {
            if (conector1[i] == conector2[i]) {
                compativel = 'N';
                break;
            }
        }
        return compativel;
    }

    public static void imprimir(char letra) {
        System.out.println(letra);
    }

    public static int[] criarVetorInt(int n) {
        return new int[n];
    }

    public static int[] lerVetorInt(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = lerNumInt();
        }
        return vet;
    }

    public static int lerNumInt() {
        int valor;
        do {
            valor = Sc.nextInt();
        } while (valor < 0 || valor > 1);
        return valor;
    }
}
/*
 * Conceito A
 */