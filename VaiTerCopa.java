import java.util.Scanner;

public class VaiTerCopa {

    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        String qtdCopas = null;
        int qtdReclamacoes = 0;

        do {
            qtdReclamacoes = lerNumInt();
            qtdCopas = verificarCopa(qtdReclamacoes);
            System.out.println(qtdCopas);
        } while (Sc.hasNextInt());
    }

    public static String verificarCopa(int qtdReclamacoes) {
        String qtdCopas = null;
        if (qtdReclamacoes != 0) {
            qtdCopas = "vai ter duas!";
        } else {
            qtdCopas = "vai ter copa!";
        }
        return qtdCopas;
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }

}