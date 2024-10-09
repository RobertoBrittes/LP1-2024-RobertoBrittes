import java.util.Scanner;

public class Bee_1099 {
    final static Scanner Sc = new Scanner(System.in);
    public static void main(String[] args) {
        int qtdTestes = lerNumInt();
        int x = 0;
        int y = 0;
        int limMax = 0;
        int limMin = 0;
        int soma = 0;

        for (int i = 0; i < qtdTestes; i++) {
            x = lerNumInt();
            y = lerNumInt();
            limMax = Math.max(x, y);
            limMin = Math.min(x, y);
            soma = calcularSoma(limMax, limMin);
            System.out.println(soma);
        }
    }
    
    public static int calcularSoma(int limMax, int limMin) {
        int soma = 0;
        boolean ehImpar = false;
        for (int i = limMin + 1; i < limMax; i++) {
            ehImpar = verificarImpar(i);
            if (ehImpar) {
                soma += i;
            }
        }
        return soma;
    }

    public static boolean verificarImpar(int i) {
        boolean ehImpar = false;
        if (i % 2 == 1) {
            ehImpar = true;
        }
        return ehImpar;
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }
}
