import java.util.Scanner;

public class Bee_1131 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int qtdGolsGremio = 0;
        int qtdGolsInter = 0;
        int qtdVitoriasGremio = 0;
        int qtdVitoriasInter = 0;
        int qtdEmpates = 0;
        int qtdGrenais = 0;
        String vencedor = null;

        do {
            qtdGrenais++;
            qtdGolsInter = lerNumInt();
            qtdGolsGremio = lerNumInt();

            if (qtdGolsGremio > qtdGolsInter) {
                qtdVitoriasGremio++;
            } else if (qtdGolsInter > qtdGolsGremio) {
                qtdVitoriasInter++;
            } else {
                qtdEmpates++;
            }

            System.out.println("Novo grenal (1-sim 2-nao)");
        } while (lerNumInt() == 1);

        imprimir(qtdGrenais + " grenais");
        imprimir("Inter:" + qtdVitoriasInter);
        imprimir("Gremio:" + qtdVitoriasGremio);
        imprimir("Empates:" + qtdEmpates);
        if (qtdVitoriasGremio > qtdGolsInter) {
            vencedor = "Gremio";
        } else if (qtdVitoriasInter > qtdVitoriasGremio) {
            vencedor = "Inter";
        } else {
            vencedor = "Nao houve vencedor";
        }
        if (vencedor == "Gremio" || vencedor == "Inter") {
            imprimir(vencedor + " venceu mais");
        } else {
            imprimir("Nao houve vencedor");
        }

    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }

    public static void imprimir(String string) {
        System.out.println(string);
    }
}
