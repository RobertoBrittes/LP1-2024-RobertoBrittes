import java.util.Scanner;

public class Bee_1101 {
    final static Scanner Sc = new Scanner(System.in);
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int limMin = 0;
        int limMax = 0;

        while (true) {
            x = lerNumInt();
            y = lerNumInt();
            if (x <= 0 || y <= 0) {
                break;
            }
            limMin = Math.min(x, y);
            limMax = Math.max(x , y);
            calcularSoma(limMax, limMin);
        }

    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }

    public static void calcularSoma(int limMax, int limMin) {
        int soma = 0;
        for (int i = limMin; i <= limMax; i++) {
            soma += i;
            System.out.print(i + " ");
        }
        System.out.print("Sum=" + soma);
        System.out.println();

    }
}
