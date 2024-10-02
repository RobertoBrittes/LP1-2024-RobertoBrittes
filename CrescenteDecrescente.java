import java.util.Scanner;

public class CrescenteDecrescente {
    final static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        do {
            x = lerNumInt();
            y = lerNumInt();
            if (x == y) {
                break;
            }
            imprimirTipo(x, y);
        } while (x != y);
    }

    public static void imprimirTipo(int x, int y) {
        if (x > y) {
            System.out.println("Decrescente");
        } else {
            System.out.println("Crescente");
        }
    }

    public static int lerNumInt() {
        return Sc.nextInt();
    }

}
