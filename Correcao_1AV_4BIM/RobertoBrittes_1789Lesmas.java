
// prof. Odair - 14:37
import java.util.Scanner;

public class RobertoBrittes_1789Lesmas {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] velocidadeLesma;
        int nivelLesmaMaisVeloz = 0;
        int lesmaMaisVeloz = 0;

        while (Sc.hasNext()) {
            velocidadeLesma = criarVetorInt(lerQtdLesmas());
            velocidadeLesma = lerVetorInt(velocidadeLesma);

            lesmaMaisVeloz = verificarLesmaMaisVeloz(velocidadeLesma);
            nivelLesmaMaisVeloz = verificarNivelLesmaMaisVeloz(lesmaMaisVeloz);

            imprimir(nivelLesmaMaisVeloz);
        }
    }

    public static void imprimir(int inteiro) {
        System.out.println(inteiro);
    }

    public static int[] lerVetorInt(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            vet[i] = lerVelocidadeLesmas();
        }
        return vet;
    }

    public static int verificarNivelLesmaMaisVeloz(int lesmaMaisVeloz) {
        int nivelLesmaMaisVeloz = 0;
        if (lesmaMaisVeloz >= 20) {
            nivelLesmaMaisVeloz = 3;
        } else if (lesmaMaisVeloz >= 10) {
            nivelLesmaMaisVeloz = 2;
        } else {
            nivelLesmaMaisVeloz = 1;
        }
        return nivelLesmaMaisVeloz;
    }

    public static int verificarLesmaMaisVeloz(int[] velocidadeLesma) {
        int lesmaMaisVeloz = velocidadeLesma[0];
        for (int i = 1; i < velocidadeLesma.length; i++) {
            if (velocidadeLesma[i] > lesmaMaisVeloz) {
                lesmaMaisVeloz = velocidadeLesma[i];
            }
        }
        return lesmaMaisVeloz;
    }

    public static int lerQtdLesmas() {
        int qtdLesmas;
        do {
            qtdLesmas = Sc.nextInt();
        } while (qtdLesmas < 1 || qtdLesmas > 500);
        return qtdLesmas;
    }

    public static int lerVelocidadeLesmas() {
        int velocidadeLesma;
        do {
            velocidadeLesma = Sc.nextInt();
        } while (velocidadeLesma < 1 || velocidadeLesma > 50);
        return velocidadeLesma;
    }

    public static int[] criarVetorInt(int n) {
        return new int[n];
    }
}

/*
 * Conceito A
 */