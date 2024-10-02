import java.util.Scanner;

public class VaiTerCopa {
    
    final static Scanner Sc = new Scanner(System.in);
    public static void main(String[] args) {
        String qtdCopas = null;
        int qtdReclamacoes = 0;
        
        do {
            qtdReclamacoes = lerNumInt();
            qtdCopas = verificarCopa(qtdReclamacoes);
            imprimir(qtdCopas);
        } while (Sc.hasNextInt());
    }
    
    public static void imprimir(String string) {
        System.out.println(string);
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
        int valor = 0;
        do {
            valor = Sc.nextInt();
        } while (valor < 0 || valor > 100);
        return valor;
    }

    
}