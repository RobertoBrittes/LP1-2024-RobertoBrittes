import java.util.Scanner;

public class Bee_2221 {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {

        int qtdInstancias = Sc.nextInt();
        int bonus = 0;
        int ataqueD = 0;
        int defesaD = 0;
        int levelD = 0;
        int ataqueG = 0;
        int defesaG = 0;
        int levelG = 0;
        float golpeDabriel = 0f;
        float golpeGuarte = 0f;
        String vencedor = null;

        for (int i = 0; i < qtdInstancias; i++) {
            bonus = lerNumInt();

            ataqueD = lerNumInt();
            defesaD = lerNumInt();
            levelD = lerNumInt();

            ataqueG = lerNumInt();
            defesaG = lerNumInt();
            levelG = lerNumInt();

            golpeDabriel = (ataqueD + defesaD) / 2;
            if (levelD % 2 == 0) {
                golpeDabriel += bonus;
            }

            golpeGuarte = (ataqueG + defesaG) / 2;
            if (levelG % 2 == 0) {
                golpeGuarte += bonus;
            }

            vencedor = verificarVencedor(golpeDabriel, golpeGuarte);

            System.out.println(vencedor);
        }
    }

    public static String verificarVencedor(float golpeDabriel, float golpeGuarte) {
        String vencedor = null;
        if (golpeDabriel > golpeGuarte) {
            vencedor = "Dabriel";
        } else if (golpeGuarte > golpeDabriel) {
            vencedor = "Guarte";
        } else {
            vencedor = "Empate";
        }
        return vencedor;
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}
