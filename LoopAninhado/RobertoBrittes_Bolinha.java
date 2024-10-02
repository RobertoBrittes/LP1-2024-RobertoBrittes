public class RobertoBrittes_Bolinha {
    public static void main(String[] args) {
        imprimirBolinha();
    }

    public static void imprimirBolinha() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j <= i) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }
}