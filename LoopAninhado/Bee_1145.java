
import java.util.Scanner;

public class Bee_1145 {
    final static Scanner Sc = new Scanner(System.in);
    public static void main(String[] args) {
        int x = lerNumInt();
        int y = lerNumInt();

        int cont = 1;

        for (int i = 1; i <= y; i++) {
            System.out.print(i);

            if (cont == x || i == y) {
                System.out.println();
                cont = 1;
            } else {
                System.out.print(" ");
                cont++;
            }
        }
    }
    
    public static int lerNumInt() {
        return Sc.nextInt();
    }
}
