import java.util.Scanner;

public class Bee_2297 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int casoTeste = 1;
        int qtdRodadas = 0;
        int totalAldo = 0;
        int totalBeto = 0;
        int aldo = 0;
        int beto = 0;
        String vencedor = null;

        while (true) {
            qtdRodadas = lerNumInt();
            if (qtdRodadas == 0) {
                break;
            }

            totalAldo = 0;
            totalBeto = 0;

            for (int i = 0; i < qtdRodadas; i++) {
                aldo = lerNumInt();
                beto = lerNumInt();
                totalAldo += aldo;
                totalBeto += beto;
            }

            System.out.println("Teste " + casoTeste);
            casoTeste++;
            vencedor = verificarVencedor(totalAldo, totalBeto);
            System.out.println(vencedor);
            System.out.println();
        }
    }

    public static String verificarVencedor(int totalAldo, int totalBeto) {
        String vencedor = null;
        if (totalAldo > totalBeto) {
            vencedor = "Aldo";
        } else {
            vencedor = "Beto";
        }
        return vencedor;
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}
